package pl.softwaremill.asamal.presentation.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class SimpleGet {

    @GET
    @Path("/simple")
    public String simpleStuff() {
        return "I am simple";
    }
}
