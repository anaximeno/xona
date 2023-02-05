package pdm.group.uno.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import pdm.group.uno.entities.Interest;
import pdm.group.uno.helpers.Responder;

@ApplicationScoped
public class InterestService {
    public Response getInterests() {
        List<Interest> interests = Interest.listAll();
        return Response.ok(interests).build();
    }

    public Response getInterestById(Long id) {
        return Interest.findByIdOptional(id)
                .map(interest -> Response.ok(interest).build())
                .orElse(Response
                        .status(Response.Status.NOT_FOUND)
                        .entity(Responder.message("Interest não encontrado no sistema."))
                        .build());
    }

    public Response storeInterest(Interest interest) {
        Interest.persist(interest);

        if (interest.isPersistent()) {
            return Response
                .created(URI.create("/interest/" + interest.getId()))
                .entity(interest)
                .build();
        }

        return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(Responder.message("Interest não pode ser guardado no sistema."))
            .build();
    }

    public Response updateInterest(Interest interest) {
        final Optional<Interest> storedInterest = Interest.findByIdOptional(interest.getId());

        if (storedInterest.isPresent()) {
            final Interest _interest = storedInterest.get();

            _interest.update(interest);

            if (_interest.isPersistent()) {
                return Response.ok(_interest).build();
            }

            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response deleteUserById(Long id) {
        boolean deleted = Interest.deleteById(id);

        if (deleted) {
            return Response.noContent().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
