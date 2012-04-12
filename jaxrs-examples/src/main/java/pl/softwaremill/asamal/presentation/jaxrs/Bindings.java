package pl.softwaremill.asamal.presentation.jaxrs;

//http://docs.jboss.org/resteasy/docs/2.3.1.GA/userguide/html/Content_Marshalling_Providers.html
//
//Media Types	                            Java Type
//application/*+xml, text/*+xml,
//application/*+json,
//application/*+fastinfoset,
//application/atom+*	                    JaxB annotated classes
//application/*+xml, text/*+xml	            org.w3c.dom.Document
//*/*	                                    java.lang.String
//*/*	                                    java.io.InputStream
//text/plain	                            primitives, java.lang.String,
//                                            or any type that has a String constructor,
//                                            or static valueOf(String) method for input,
//                                            toString() for output
//*/*	                                    javax.activation.DataSource
//*/*	                                    java.io.File
//*/*	                                    byte[]
//application/x-www-form-urlencoded	        javax.ws.rs.core.MultivaluedMap

import pl.softwaremill.asamal.presentation.bindings.Country;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class Bindings {

    @GET
    @Path("/autobind/country/{country}")
    public String providedCountry(@PathParam("country") Country country) {
        return "Loaded country: " + country;
    }
}
