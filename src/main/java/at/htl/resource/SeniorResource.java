package at.htl.resource;

import at.htl.controller.SeniorRepository;
import at.htl.entity.Senior;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;

public class SeniorResource {
    private LinkedList<Senior> seniors = new LinkedList<>();
    SeniorRepository seniorRepository = new SeniorRepository();

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
        seniorRepository.save(newSenior);
        return seniors;
    }

    @DELETE
    public LinkedList<Senior> deleteSenior(Senior senior) {
        seniors.removeIf(existingSenior -> existingSenior.equals(senior));
        return seniors;
    }
}
