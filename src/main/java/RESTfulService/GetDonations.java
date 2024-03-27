package RESTfulService;

import donationLog.persistence.DAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import donationLog.entity.Donation;
import java.util.List;

@Path("/getDonations")
public class GetDonations {

    @GET
    @Produces({"text/plain"})
    public Response getListedDonations() {

        // create a new object
        DAO donationDAO;

        // instantiate DAO
        donationDAO = new DAO();

        // get all the donations
        List<Donation> donations = donationDAO.getAllDonations();

        // put them into a string
        String donationsOutput = "These are the listed donations: " + donations;

        // return to the page
        return Response.status(200).entity(donationsOutput).build();
    }
}
