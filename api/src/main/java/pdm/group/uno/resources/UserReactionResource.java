package pdm.group.uno.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pdm.group.uno.enums.Reaction;
import pdm.group.uno.services.UserReactionService;


@Path("/api/reaction")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class UserReactionResource {
    @Inject
    UserReactionService userReactionService;

    @GET
    @Path("/{id}")
    public Response show(@PathParam("id") Long id) {
        return userReactionService.getUserReactions(id);
    }

    @POST
    @Path("?from={userFromId}&to={userToId}&type={reactionType}")
    @Transactional
    public Response store(@PathParam("userFromId") Long userFromId, @PathParam("userToId") Long userToId, @PathParam("reactionType") Reaction reaction) {
        return userReactionService.addNewReaction(userFromId, userToId, reaction);
    }

    @POST
    @Path("/like?from={userFromId}&to={userToId}")
    @Transactional
    public Response storeLike(@PathParam("userFromId") Long userFromId, @PathParam("userToId") Long userToId) {
        return userReactionService.addNewReaction(userFromId, userToId, Reaction.Like);
    }

    @POST
    @Path("/dislike?from={userFromId}&to={userToId}")
    @Transactional
    public Response storeDislike(@PathParam("userFromId") Long userFromId, @PathParam("userToId") Long userToId) {
        return userReactionService.addNewReaction(userFromId, userToId, Reaction.Dislike);
    }

    @POST
    @Path("/denounce?from={userFromId}&to={userToId}")
    @Transactional
    public Response storeDenouce(@PathParam("userFromId") Long userFromId, @PathParam("userToId") Long userToId) {
        return userReactionService.addNewReaction(userFromId, userToId, Reaction.Denounce);
    }
}
