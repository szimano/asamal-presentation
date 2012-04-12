package pl.softwaremill.asamal.presentation.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.PathSegment;
import java.util.List;
import java.util.Map;

@Path("/")
public class Parametrized {

    @GET
    @Path("/params/{id}")
    public String parametrized(@PathParam("id") long id) {
        return "Got a paremeter: " + id;
    }

    @POST
    @Path("/two/params/{category}/{id}")
    public String twoParams(@PathParam("category") String category, @PathParam("id") String id) {
        return String.format("Got two parameters: %s and %s\n", category, id);
    }

    @GET
    @Path("/wild/{id}{sep:/?}{path:.*}")
    public String wildcardParams(@PathParam("id") String id, @PathParam("path") String optionalPath) {
        return String.format("Got id: %s\nWith optional params: %s", id, optionalPath);
    }

    /**
     * Try entering this link: /rest/matrix/audi-a4;name=Audi;model=A4;equipment=AC,SteeringWheel,Airbags
     */
    @GET
    @Path("/matrix/{car}")
    public String matrixPathSegment(@PathParam("car") PathSegment car) {
        String output = "Got car: " + car.getPath() + "<br/>\n";

        for (Map.Entry<String, List<String>> matrixParameters : car.getMatrixParameters().entrySet()) {
            output += matrixParameters.getKey() + " = " + matrixParameters.getValue().toString() + "<br/>\n";
        }

        return output;
    }
}
