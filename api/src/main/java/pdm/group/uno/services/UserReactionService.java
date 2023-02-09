package pdm.group.uno.services;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import pdm.group.uno.entities.User;
import pdm.group.uno.entities.UserReaction;
import pdm.group.uno.enums.Reaction;
import pdm.group.uno.helpers.JsonLike;
import pdm.group.uno.helpers.Responder;


@ApplicationScoped
public class UserReactionService {
    public Response getUserReactions(Long id) {
        final Optional<User> user = User.findByIdOptional(id);

        if (user.isPresent()) {
            final JsonLike reactions = Responder.newResponse();

            reactions.put("received", user.get().getReactionsReceived());
            reactions.put("given", user.get().getReactionsGiven());

            return Response.ok(reactions).build();
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
                .entity(Responder.message("Usuário com id " + userGivesId + " não encontrado no sistema"))
                .build();
        }

        if (userReceives.isEmpty()) {
            return Response
                .status(Status.NOT_FOUND)
                .entity(Responder.message("Usuário com id " + userReceivesId + " não encontrado no sistema"))
                .build();
        }

        userReaction.setUserThatReacts(userGives.get());
        userReaction.setUserThatReceivesReaction(userReceives.get());
        userReaction.setReaction(reaction);
        userReaction.persist();

        // TODO: verify if there is a match between them two and call the route in the link bellow:
        //  - https://api-explorer.cometchat.com/reference/add-friend

        return Response.ok().entity(Responder.message("Reação adicionada com sucesso!")).build();
    }
}