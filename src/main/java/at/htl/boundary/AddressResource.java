package at.htl.boundary;

import at.htl.controller.AddressRepository;
import at.htl.entity.Address;

import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("address")
public class AddressResource {

    final AddressRepository addressRepository = new AddressRepository();

    @POST
    @Transactional
    public Response create(Address address) {
        addressRepository.save(address);
        return Response.created(URI.create("address/" + address.getAddressId())).build();
    }

}
