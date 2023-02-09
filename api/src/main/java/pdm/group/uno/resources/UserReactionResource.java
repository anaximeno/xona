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
import pdm.group.uno.helpers.JsonLike;

@Path("/api/reaction")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class UserReactionResource {
    @Inject
    UserReactionService userReactionService;

    @GET
    @Path("/user/{id}")
    public Response show(@PathParam("id") Long id) {
        return userReactionService.getUserReactions(id);
    }

    @POST
    @Path("/")
    @Transactional
    public Response store(JsonLike body) {
        Long from = ((Integer) body.get("from")).longValue();
        Long to = ((Integer) body.get("to")).longValue();
        Reaction reaction = (Reaction) body.get("reaction");
        return userReactionService.addNewReaction(from, to, reaction);
    }

    @POST
    @Path("/like")
    @Transactional
    public Response storeLike(JsonLike body) {
        Long from = ((Integer) body.get("from")).longValue();
        Long to = ((Integer) body.get("to")).longValue();
        return userReactionService.addNewReaction(from, to, Reaction.Like);
    }

    @POST
    @Path("/dislike")
    @Transactional
    public Response storeDislike(JsonLike body) {
        Long from = ((Integer) body.get("from")).longValue();
        Long to = ((Integer) body.get("to")).longValue();
        return userReactionService.addNewReaction(from, to, Reaction.Dislike);
    }

    @POST
    @Path("/denounce")
    @Transactional
    public Response storeDenouce(JsonLike body) {
        Long from = ((Integer) body.get("from")).longValue();
        Long to = ((Integer) body.get("to")).longValue();
        return userReactionService.addNewReaction(from, to, Reaction.Denounce);
    }
}
