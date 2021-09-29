package at.htl.boundary;

import at.htl.controller.SeniorRepository;
import at.htl.entity.Senior;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("senior")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SeniorResource {

    final SeniorRepository seniorRepository = new SeniorRepository();

    @POST
    @Transactional
    public Response create(Senior senior) {
        seniorRepository.save(senior);
        return Response.created(URI.create("senior/" + senior.getSeniorId())).build();
    }

    @GET
    @Path("all")
    public Response getAll() {
        return Response.ok(seniorRepository.listAll()).build();
    }
}
