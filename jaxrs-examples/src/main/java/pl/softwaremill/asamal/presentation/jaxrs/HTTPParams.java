package pl.softwaremill.asamal.presentation.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.PathSegment;
import java.util.List;
import java.util.Map;

@Path("/")
public class HTTPParams {

    @GET
    @Path("/query/{id}")
    public String parametrized(@PathParam("id") String id,
                               @QueryParam("key") String value) {
        return "Got a paremeter: " + id + " with key = " + value;
    }

    @GET
    @Path("/header")
    public String headerParams(@HeaderParam("User-Agent") String agent) {
        return "The request is with: "+agent;
    }
}
