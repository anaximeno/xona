package pdm.group.uno.domain.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import pdm.group.uno.domain.entities.UserEntity;

@ApplicationScoped
public class UserService {
    public Response getUsers() {
        List<UserEntity> users = UserEntity.listAll();
        return Response.ok(users).build();
    }

    public Response getUserById(Long id) {
        return UserEntity.findByIdOptional(id)
                .map(user -> Response.ok(user).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    public Response storeUser(UserEntity user) {
        UserEntity.persist(user);

        if (user.isPersistent()) {
            return Response.created(URI.create("/user/" + user.getId())).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public Response deleteUserById(Long id) {
        boolean deleted = UserEntity.deleteById(id);

        if (deleted) {
            return Response.noContent().build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
