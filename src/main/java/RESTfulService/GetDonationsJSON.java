package RESTfulService;

import com.fasterxml.jackson.databind.ObjectMapper;
import donationLog.persistence.DAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import donationLog.entity.Donation;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * A class that returns JSON data.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
@Path("/donationsJSON")
public class GetDonationsJSON {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
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

        // JSON
        /*
        https://mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
         */
        ObjectMapper mapper = new ObjectMapper();

        // Object to JSON in file.
        mapper.writeValue(new File("/Volumes/WD_Black P40/GitHub/Personal/DonationLog/logs/user.json"),
                donationsOutput.toString());

        // Convert object to JSON string.
        String jsonInString = mapper.writeValueAsString(donationsOutput.toString());

        // Return to the page.
        return Response.status(200).entity(jsonInString).build();
    }
}
