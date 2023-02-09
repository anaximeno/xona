package pdm.group.uno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import pdm.group.uno.entities.User;
import pdm.group.uno.entities.UserReaction;
import pdm.group.uno.enums.Reaction;
import pdm.group.uno.helpers.JsonLike;

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
            // TODO: verify if there is a match between them two and call the route in the
            // link bellow:
            // - https://api-explorer.cometchat.com/reference/add-friend
            return Response.ok().entity(JsonLike.message("Reação adicionada com sucesso!")).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}