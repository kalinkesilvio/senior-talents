package at.htl.boundary;

import at.htl.controller.SeniorRepository;
import at.htl.entity.Senior;

import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("senior")
public class SeniorResource {

    final SeniorRepository seniorRepository = new SeniorRepository();

    @POST
    @Transactional
    public Response create(Senior senior) {
        seniorRepository.save(senior);
        return Response.created(URI.create("senior/" + senior.getSeniorId())).build();
    }
}
