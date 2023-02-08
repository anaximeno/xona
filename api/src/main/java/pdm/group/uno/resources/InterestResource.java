package pdm.group.uno.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.inject.Inject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import pdm.group.uno.services.InterestService;
import pdm.group.uno.entities.Interest;



@Path("/api/interest")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class InterestResource {
    @Inject
    InterestService interestService;

    @GET
    @Path("/")
    public Response show() {
        return interestService.getInterests();
    }

    @GET
    @Path("/{id}")
    public Response index(@PathParam("id") Long id) {
        return interestService.getInterestById(id);
    }

    @POST
    @Path("/")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response store(Interest interest) {
        return interestService.storeInterest(interest);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Interest interest) {
        interest.setId(id);
        return interestService.updateInterest(interest);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        return interestService.deleteUserById(id);
    }
}
