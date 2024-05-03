package donationLog.controller;

import donationLog.entity.Donation;
import donationLog.persistence.DAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet that will delete donations
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
@WebServlet(
        urlPatterns = {"/deleteDonation"}
)
public class DeleteDonation extends HttpServlet {

    // Instantiate Logger.
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Removes a donation.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Extract the donation ID from the request parameter.
        int donationID = Integer.parseInt(request.getParameter("donationID"));

        // Instantiate DAO.
        DAO donationDAO = new DAO();

        // Retrieve the donation to delete.
        Donation donationToDelete = donationDAO.getDonationById(donationID);

        // Delete the donation from the database
        donationDAO.deleteDonation(donationToDelete);

        // Log the deleted donation
        StringBuilder logDonationMessage = new StringBuilder();
        logDonationMessage.append(donationToDelete).append(" was deleted.");
        logger.info(logDonationMessage.toString());

        // Set a session attribute for the donationDeleteMessage.
        StringBuilder deleteDonationMessage = new StringBuilder();
        deleteDonationMessage.append("You have successfully removed donation number ").append(donationID).append(".");
        request.getSession().setAttribute("donationDeleteMessage", deleteDonationMessage.toString());

        // Redirect to the ReadDonations servlet to display updated donation list.
        response.sendRedirect(request.getContextPath() + "/readDonations?submit=Show+All+Donations");
    }
}
