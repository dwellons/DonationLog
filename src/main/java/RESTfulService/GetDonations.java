package RESTfulService;

import donationLog.persistence.DAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import donationLog.entity.Donation;
import java.io.IOException;
import java.util.List;

/**
 * A class that returns plain text
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */

@Path("/donations")
public class GetDonations {

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response getListedDonations() throws IOException {

        // create a new object
        DAO donationDAO;

        // instantiate DAO
        donationDAO = new DAO();

        // get all the donations
        List<Donation> donations = donationDAO.getAllDonations();

        // put them into a string
        String donationsOutput = "These are the listed donations: " + donations;

        return Response.status(200).entity(donationsOutput).build();
    }
}