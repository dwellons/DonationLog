package RESTfulService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/getDonations")
public class GetDonations {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    // Adding ability for html and json as well
    @Produces({"text/plain", "text/html", "application/json"})

    public Response getMessage() {

        // Return a simple message
        String output = "Hello Darin" ;

        // HTML
        String html = "<html><body><h1>Hello Darin"  + "</h1></body></html>";

        //JSON
        String json = "{\"Hello Darin\": \"";

        // have to add each item to be built, or it will not be!
        return Response.status(200).entity(output).entity(json).entity(html).build();
    }
}
