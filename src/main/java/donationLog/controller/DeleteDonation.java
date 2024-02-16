package donationLog.controller;

import donationLog.entity.Donation;
import donationLog.persistence.DonationDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/deleteDonation"}
)
public class DeleteDonation extends HttpServlet {

    // Instantiate Logger.
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Extract the donation ID from the request parameter.
        int donationID = Integer.parseInt(request.getParameter("donationID"));

        logger.debug("TEST In Delete Donations Before DAO call: {}",  request.getAttribute("donationID"));

        // Instantiate DonationDAO.
        DonationDAO donationDAO = new DonationDAO();

        // Retrieve the donation to delete.
        Donation donationToDelete = donationDAO.getById(donationID);

        // Delete the donation from the database
        donationDAO.delete(donationToDelete);

        // Set a session attribute for the donationDeleteMessage.
        request.getSession().setAttribute("donationDeleteMessage",
                "You have successfully removed donation number " + donationID + ".");

        // Redirect to the ReadDonations servlet to display updated donation list.
         response.sendRedirect(request.getContextPath() + "/readDonations?submit=Show+All+Donations");
    }
}
