package at.htl.boundary;

import at.htl.controller.CompanyRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("company")
public class CompanyResource {

    public CompanyRepository companyRepository = new CompanyRepository();

    @GET
    @Path("getByEmailPassword")
    public Response getByEmailPassword(
            @QueryParam("email") String email,
            @QueryParam("password") String password
    ) {
        return Response.ok(companyRepository.getCompanyByEmailPassword(email, password)).build();
    }
}
