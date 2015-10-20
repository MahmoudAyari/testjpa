package jxRs;


import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Developer;


@Path("/status")
public class StatusEndpoint {

    private static final Logger logger = Logger.getLogger(StatusEndpoint.class.getName());

    @GET
    public Response getStatus() {

        return Response.status(Response.Status.OK).entity("JO").build();
    }
    
    @GET
    @Path("/test")
    public String helloWorld() {

        return "hello";
    }

    @GET
    @Path("/developer")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer getPerson() {
    	Developer d = new Developer();
    	d.setName("test");
    	d.setSurname("t");
        return d;
    }

    @POST
    @Path("/developer")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(Developer d) {
    	System.err.println(d.getName());
    }
    

}