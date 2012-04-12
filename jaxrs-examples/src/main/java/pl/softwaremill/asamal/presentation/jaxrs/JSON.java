package pl.softwaremill.asamal.presentation.jaxrs;

import pl.softwaremill.asamal.presentation.json.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class JSON {

    @GET
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserInJSON(@PathParam("name") String name) {
        return new User(name, name + "ski", 40 + name.length());
    }

    /*
      curl -H "Content-Type:application/json" -XPUT http://localhost:8080/jaxrs-examples-1.0-SNAPSHOT/rest/addUser -d '{"name":"Tomek","lastName":"Szymanski","shoeNumber":43}'
     */
    @PUT
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addUser(User user) {
        return "Added user: " + user.toString() + "\n";
    }
}
