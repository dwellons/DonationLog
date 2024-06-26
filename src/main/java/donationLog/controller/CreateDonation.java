package donationLog.controller;

import donationLog.entity.Donation;
import donationLog.entity.Users;
import donationLog.persistence.DAO;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Create a servlet that will add a new Donation to the application.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */

@WebServlet(
        name = "createDonation",
        urlPatterns = { "/createDonation" }
)

public class CreateDonation extends HttpServlet {

    // Instantiate DAO
    private DAO donationDAO;

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Create a valid or not valid variable for validating form entries.
     */
    private boolean isValid;

    /**
     * Creates a donation.
     * @param request request from the session
     * @param response response from the session
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     * @throws SQLException for connection exceptions
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // Extract the data for the new Donation from the HTML form.
        String donor_name = request.getParameter("donorName");
        String donation_type = request.getParameter("donationType");
        String donation_weight = request.getParameter("donationWeight");
        Users user = null;

        // Have to validate the input from the form before accessing database.
        if (!validateUserInput(donor_name, donation_type, donation_weight, request)) {

            // Send a redirect the browser to the Add Donation page.
            response.sendRedirect(request.getContextPath() + "/DonationCreate.jsp");
            return;
        }

        // Instantiate donationDAO.
        donationDAO = new DAO();

        // Get Today's date.
        Date donationDate = new Date();

        // Create the new donation object.
        Donation newDonation = new Donation(donor_name,donation_type,donation_weight,donationDate, user);

        // Call Insert in DAO.
        donationDAO.insertDonation(newDonation);

        // Log the new donation
        logger.info(newDonation);

        // Redirect to Read Recent Donations page.
        response.sendRedirect("ReadRecentDonations");

        request.getSession().setAttribute("donationAddMessage",
                "You have added your donation.");
    }

    /**
     * Have to validate the input coming from the form.
     * If they enter a number in a text field or text in number field,
     * then the add message will be updated with an error message.
     * @param donor_name the donors name
     * @param donation_type the donation type
     * @param donation_weight the donation weight
     * @param request the servlet request attribute
     * @return if the user input is valid or not
     * @throws IOException for io exceptions
     */
    private boolean validateUserInput(String donor_name, String donation_type,
                                      String donation_weight,
                                      HttpServletRequest request)
            throws IOException {

        // Instantiate validation variable to valid, true.
        isValid = true;

        StringBuilder errorMessage = new StringBuilder();

        // If the donor name and donation type aren't text.
        if (!donor_name.matches("[a-zA-Z ]+") ||
                !donation_type.matches("[a-zA-Z ]+")) {

            // Set the variable to not valid, false.
            isValid = false;
            errorMessage.append("Donor and Donation Type can only contain text.");
        }

        // If the weight isn't digits.
        if (!donation_weight.matches("[0-9]+")){

            // Set the variable to not valid, false
            isValid = false;
            errorMessage.append("Weight can only contain digits.");
        }

        // If the form entries are invalid.
        if (!isValid) {
            request.getSession().setAttribute("donationAddMessage",
                    "Invalid Form Input. Please check your entries. " + errorMessage.toString());
        }

        // Return the variable set to valid or invalid.
        return isValid;
    }
}
