package at.htl.resource;

import at.htl.entity.Senior;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;

@Path("/seniors")
public class SeniorResource {
    private LinkedList<Senior> seniors = new LinkedList<>();

    public SeniorResource() {
        //seniors.add(new Senior("bertl.broame@gmail.com", "bertl123"));
        //seniors.add(new Senior("gustav.jauk@aon.com", "ungustl321"));
    }

    @GET
    public LinkedList<Senior> getListOfSeniors() {
        return seniors;
    }

    @POST
    public LinkedList<Senior> addSenior(Senior newSenior) {
        seniors.add(newSenior);
        return seniors;
    }

    @DELETE
    public LinkedList<Senior> deleteSenior(Senior senior) {
        seniors.removeIf(existingSenior -> existingSenior.equals(senior));
        return seniors;
    }
}
