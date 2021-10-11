package at.htl.boundary;

import at.htl.controller.JobOfferRepository;
import at.htl.entity.JobOffer;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("job-offer")
public class JobOffersResource {
    JobOfferRepository jobOfferRepository = new JobOfferRepository();

    @POST
    @Path("create")
    @Transactional
    public Response create(JobOffer jobOffer) {
        jobOfferRepository.save(jobOffer);
        return Response.created(URI.create("" + jobOffer.getJobOfferId())).build();
    }

    @GET
    @Path("getByCompanyId/{id}")
    public Response getByCompanyId(@PathParam("id") Long id) {
        return Response.ok(jobOfferRepository.getJobOffersByCompanyId(id)).build();
    }
}
