package pdm.group.uno.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pdm.group.uno.services.UserService;
import pdm.group.uno.entities.User;

@Path("/user")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserService userService;

    @GET
    @Path("/")
    public Response show() {
        return userService.getUsers();
    }

    @GET
    @Path("/{id}")
    public Response index(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }

    @POST
    @Path("/")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response store(User user) {
        return userService.storeUser(user);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, User user) {
        user.setId(id);
        System.out.print(user.getName() == null);
        return userService.updateUser(user);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        return userService.deleteUserById(id);
    }
}
