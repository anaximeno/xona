package pdm.group.uno.services;

import java.net.http.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.quarkus.logging.Log;
import pdm.group.uno.entities.User;
import pdm.group.uno.entities.UserReaction;
import pdm.group.uno.enums.Reaction;
import pdm.group.uno.helpers.JsonLike;
import pdm.group.uno.helpers.Match;

@ApplicationScoped
public class UserReactionService {
    public static List<JsonLike> reactionsGivenResponseFormat(User user) {
        List<JsonLike> list = new ArrayList<JsonLike>();

        for (UserReaction reaction : user.getReactionsGiven()) {
            list.add(JsonLike
                    .from("user", reaction.getUserThatReceivesReaction().id)
                    .add("reaction", reaction.getReaction()));
        }

        return list;
    }

    public static List<JsonLike> reactionsReceivedResponseFormat(User user) {
        List<JsonLike> list = new ArrayList<JsonLike>();

        for (UserReaction reaction : user.getReactionsReceived()) {
            list.add(JsonLike
                    .from("user", reaction.getUserThatReacts().id)
                    .add("reaction", reaction.getReaction()));
        }

        return list;
    }

    public Response getUserReactions(Long id) {
        final Optional<User> user = User.findByIdOptional(id);

        if (user.isPresent()) {
            JsonLike response = JsonLike
                    .from("given", reactionsGivenResponseFormat(user.get()))
                    .add("received", reactionsReceivedResponseFormat(user.get()));
            return Response.ok(response).build();
        }

        return Response.status(Status.NOT_FOUND).build();
    }

    public Response addNewReaction(Long userGivesId, Long userReceivesId, Reaction reaction) {
        final UserReaction userReaction = new UserReaction();

        final Optional<User> userGives = User.findByIdOptional(userGivesId);
        final Optional<User> userReceives = User.findByIdOptional(userReceivesId);

        if (userGives.isEmpty()) {
            return Response
                    .status(Status.NOT_FOUND)
                    .entity(JsonLike.message("Usuário com id " + userGivesId + " não encontrado no sistema"))
                    .build();
        }

        if (userReceives.isEmpty()) {
            return Response
                    .status(Status.NOT_FOUND)
                    .entity(JsonLike.message("Usuário com id " + userReceivesId + " não encontrado no sistema"))
                    .build();
        }

        userReaction.setUserThatReacts(userGives.get());
        userReaction.setUserThatReceivesReaction(userReceives.get());
        userReaction.setReaction(reaction);
        userReaction.persist();

        if (userReaction.isPersistent()) {
            if (Match.isFromReaction(userReaction)) {
                addFriendNew(userReaction.getUserThatReacts(), userReaction.getUserThatReceivesReaction());
            }

            return Response.ok().entity(JsonLike.message("Reação adicionada com sucesso!")).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    private void addFriendNew(User user, User friend) {
        //TODO: update cometchat url
        final String BASE_COMETCHAT_URL = "https://appId.api-region.cometchat.io/v3";

        try {
            final String body = "accepted: [\"" + friend.getId() + "\"]";

            var client = HttpClient.newHttpClient();

            var request = HttpRequest.newBuilder(
                    URI.create(BASE_COMETCHAT_URL + "/users/" + user.getId() + "/friends"))
                    .header("accept", "application/json")
                    .header("content-type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            client.send(request, null);
        } catch (Exception e) {
            Log.error(e);
        }
    }
}