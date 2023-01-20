package pdm.group.uno.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import pdm.group.uno.entities.User;

@ApplicationScoped
public class UserService {
    public Response getUsers() {
        List<User> users = User.listAll();
        return Response.ok(users).build();
    }

    public Response getUserById(Long id) {
        return User.findByIdOptional(id)
                .map(user -> Response.ok(user).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    public Response storeUser(User user) {
        User.persist(user);

        if (user.isPersistent()) {
            return Response.created(URI.create("/user/" + user.getId())).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public Response updateUser(User user) {
        final Optional<User> userOptional = User.findByIdOptional(user.id);

        if (userOptional.isPresent()) {
            final User _user = userOptional.get();

            _user.update(user);

            if (_user.isPersistent()) {
                return Response.ok(_user).build();
            }

            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response deleteUserById(Long id) {
        boolean deleted = User.deleteById(id);

        if (deleted) {
            return Response.noContent().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
