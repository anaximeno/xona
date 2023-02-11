package pdm.group.uno.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import pdm.group.uno.entities.User;
import pdm.group.uno.helpers.JsonLike;

@ApplicationScoped
public class UserService {
    public static JsonLike userResourceFormat(User user) {
        return JsonLike
                .from("id", user.getId())
                .add("name", user.getName())
                .add("lastName", user.getLastName())
                .add("genre", user.getGenre())
                .add("bio", user.getBio())
                .add("email", user.getEmail())
                .add("birthDate", user.getBirthDate())
                .add("relationType", user.getRelationType())
                .add("sexualOrientation", user.getSexualOrientation());
    }

    public Response getUsers() {
        List<JsonLike> resource = new ArrayList<>();

        for (PanacheEntityBase user : User.listAll()) {
            resource.add(userResourceFormat((User) user));
        }

        return Response.ok(resource).build();
    }

    public Response getUserById(Long id) {
        final Optional<User> user = User.findByIdOptional(id);

        if (user.isPresent()) {
            return Response.ok(userResourceFormat(user.get())).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response storeUser(User user) {
        if (User.find("email", user.getEmail()).firstResult() != null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(JsonLike.message("Email já cadastrado no sistema"))
                    .build();
        }

        User.persist(user);

        if (user.isPersistent()) {
            return Response
                    .created(URI.create("/user/" + user.getId()))
                    .entity(userResourceFormat(user))
                    .build();
        }

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(JsonLike.message("Usuário não pôde ser guardado!"))
                .build();
    }

    public Response updateUser(User user) {
        final Optional<User> userOptional = User.findByIdOptional(user.id);

        if (userOptional.isPresent()) {
            final User _user = userOptional.get();

            _user.update(user);

            if (_user.isPersistent()) {
                return Response.ok(userResourceFormat(_user)).build();
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
