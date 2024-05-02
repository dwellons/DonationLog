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
import javax.servlet.RequestDispatcher;

/**
 * A servlet that will update donations
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */

@WebServlet(
        name = "updateDonation",
        urlPatterns = { "/updateDonation" }
)
public class UpdateDonation extends HttpServlet {
    DAO donationDAO;

    // Instantiate Logger.
    private final Logger logger = LogManager.getLogger(this.getClass());

     // Create a valid or not valid variable for validating form entries.

    private boolean isValid;

    /**
     *
     * @param request  request from the session
     * @param response response from the session
     * @throws ServletException for servlet exceptions
     * @throws IOException      for io exceptions
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract the data for updating the Donation from the HTML form.
        String donationID = request.getParameter("donationID");
        String donorName = request.getParameter("donorName");
        String donationType = request.getParameter("donationType");
        String donationWeight = request.getParameter("donationWeight");

        // Validate the input from the form before updating the database.
        if (!validateUserInput(donorName, donationType, donationWeight, request)) {

            // Set a session attribute for the update message.
            request.getSession().setAttribute("donationUpdateMessage",
                    "Invalid Form Input. Please check your entries. "
                            + "Donor, Donation Type can only contain text"
                            + "Weight can only contain digits");

            // Forward to the Update Donation page.
            RequestDispatcher dispatcher = request.getRequestDispatcher("/DonationUpdate.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Instantiate DAO.
        donationDAO = new DAO();

        // Retrieve the existing Donation from the database.
        Donation donationToUpdate = donationDAO.getDonationById(Integer.parseInt(donationID));

        // Update the existing Donation with the new data.
        donationToUpdate.setDonationID(Integer.parseInt(donationID));
        donationToUpdate.setDonorName(donorName);
        donationToUpdate.setDonationType(donationType);
        donationToUpdate.setDonationWeight(donationWeight);

        // Call update in donationDAO.
        donationDAO.updateDonation(donationToUpdate);

        // Set the updated donation as an attribute in the request.
        request.setAttribute("donationToUpdate", donationToUpdate);

        // Set a session attribute for the update message.
        request.getSession().setAttribute("donationUpdateMessage",
                "You have updated the donation with ID: " + donationID);

        // Forward to the Update Donation page.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DonationSearch.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * Have to validate the input coming from the form.
     * If they enter a number in a text field or text in a number field
     * then the update message will be updated with an error message.
     *
     * @param donorName      the donor's name
     * @param donationType   the donation type
     * @param donationWeight the donation weight
     * @param request        the servlet request attribute
     * @return if the user input is valid or not
     * @throws IOException for io exceptions
     */
    private boolean validateUserInput(String donorName, String donationType,
                                      String donationWeight,
                                      HttpServletRequest request)
            throws IOException {

        // instantiate validation variable to valid, true
        isValid = true;

        // If the donor name and donation type aren't text.
        if (!donorName.matches("[a-zA-Z ]+") ||
                !donationType.matches("[a-zA-Z ]+")) {

            // Set the variable to not valid, false.
            isValid = false;
        }

        // If the weight isn't digits.
        if (!donationWeight.matches("[0-9]+")) {

            //set the variable to not valid, false
            isValid = false;
        }

        // If the form entries are invalid.
        if (!isValid) {
            request.getSession().setAttribute("donationUpdateMessage",
                    "Invalid Form Input. Please check your entries. "
                            + "Donor, Donation Type can only contain text"
                            + "Weight can only contain digits");
        }

        // Return the variable set to valid or invalid.
        return isValid;
    }
}