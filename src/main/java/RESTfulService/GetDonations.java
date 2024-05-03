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
 * A class that returns plain text.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
@Path("/donations")
public class GetDonations {

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response getListedDonations() throws IOException {

        // Create a new object.
        DAO donationDAO;

        // Instantiate DAO.
        donationDAO = new DAO();

        // Get all the donations.
        List<Donation> donations = donationDAO.getAllDonations();

        // Put them into a string.
        StringBuilder donationsOutput = new StringBuilder();
        donationsOutput.append("These are the listed donations: ").append(donations);

        // Return to the page.
        return Response.status(200).entity(donationsOutput.toString()).build();
    }
}