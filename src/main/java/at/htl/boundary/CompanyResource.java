package at.htl.boundary;

import at.htl.controller.CompanyRepository;
import at.htl.entity.Company;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("company")
public class CompanyResource {

    public CompanyRepository companyRepository = new CompanyRepository();

    @POST
    @Path("create")
    @Transactional
    public Response create(Company company) {
        companyRepository.save(company);
        return Response.created(URI.create("company/" + company.getCompanyId())).build();
    }

    @GET
    @Path("getByEmailPassword")
    public Response getByEmailPassword(
            @QueryParam("email") String email,
            @QueryParam("password") String password
    ) {
        return Response.ok(companyRepository.getCompanyByEmailPassword(email, password)).build();
    }
}
