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
import javax.servlet.RequestDispatcher;

@WebServlet(
        name = "updateDonation",
        urlPatterns = { "/updateDonation" }
)
public class UpdateDonation extends HttpServlet {
    DonationDAO donationDAO;

    /*
     *Instantiate Logger
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /*
     * create a valid or not valid variable for validating form entries
     */
    private boolean isValid;

    /**
     * The doPost() method will perform the following:
     * Extract the data for updating the Donation from the HTML form.
     * Call the update donation method in the DonationDAO
     * instance and pass in the form data as arguments.
     * Add the returned message to the session.
     * Send a redirect to the browser to the Update Donation page.
     * NOTE: It’s a doPost() method, not a doGet().
     *
     * @param request  request from the session
     * @param response response from the session
     * @throws ServletException for servlet exceptions
     * @throws IOException      for io exceptions
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract the data for updating the Donation from the HTML form.
        int donationID = Integer.parseInt(request.getParameter("donationID"));
        String donorName = request.getParameter("donorName");
        String donationType = request.getParameter("donationType");
        String donationWeight = request.getParameter("donationWeight");

        // Validate the input from the form before updating the database
        if (!validateUserInput(donorName, donationType, donationWeight, request)) {
            logger.debug("TEST In Update Donation");

            // Set a session attribute for the update message
            request.getSession().setAttribute("donationUpdateMessage",
                    "Invalid Form Input. Please check your entries. "
                            + "Donor, Donation Type can only contain text"
                            + "Weight can only contain digits");

            // Forward to the Update Donation page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/DonationUpdate.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Instantiate DonationDAO
        donationDAO = new DonationDAO();

        // Retrieve the existing Donation from the database
        Donation donationToUpdate = donationDAO.getById(donationID);

        // Update the existing Donation with the new data
        donationToUpdate.setDonorName(donorName);
        donationToUpdate.setDonationType(donationType);
        donationToUpdate.setDonationWeight(donationWeight);

        // Call update in donationDAO
        donationDAO.update(donationToUpdate);

        // Set the updated donation as an attribute in the request
        request.setAttribute("donationToUpdate", donationToUpdate);

        // Set a session attribute for the update message
        request.getSession().setAttribute("donationUpdateMessage",
                "You have updated the donation with ID: " + donationID);

        // Forward to the Update Donation page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DonationUpdate.jsp");
        dispatcher.forward(request, response);

        logger.debug("TEST in UpdateDonation.java - donationToUpdate:  " + donationToUpdate);


    }



    /**
     * have to validate the input coming from the form
     * if they enter a number in a text field or text in a number field
     * then the update message will be updated with an error message
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

        /*
         * if the donor name and donation type aren't text
         */
        if (!donorName.matches("[a-zA-Z ]+") ||
                !donationType.matches("[a-zA-Z ]+")) {

            //set the variable to not valid, false
            isValid = false;
        }

        /*
         * if the weight isn't digits
         */
        if (!donationWeight.matches("[0-9]+")) {

            //set the variable to not valid, false
            isValid = false;
        }

        /*
         * if the form entries are invalid
         */
        if (!isValid) {
            request.getSession().setAttribute("donationUpdateMessage",
                    "Invalid Form Input. Please check your entries. "
                            + "Donor, Donation Type can only contain text"
                            + "Weight can only contain digits");
        }

        // return the variable set to valid or invalid
        return isValid;
    }
}
