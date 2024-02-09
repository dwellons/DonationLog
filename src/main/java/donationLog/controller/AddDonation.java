package donationLog.controller;

import donationLog.entity.Donation;
import donationLog.persistence.DonationDAO;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Create a servlet that will add a new Donation to the application
 *
 *@author Darin Wellons
 */

@WebServlet(
        name = "addDonation",
        urlPatterns = { "/addDonation" }
)

public class AddDonation extends HttpServlet {
    DonationDAO donationDAO;

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * create a valid or not valid variable for validating form entries
     */
    private boolean isValid;

    /**
     * The doPost() method will perform the following:
     * Extract the data for the new Employee from the HTML form.
     * Call the add employee method in the EmployeeDirectory
     * instance and pass the form data as arguments.
     * Add the returned message to the session.
     * Send a redirect the browser to the Add Employee page
     * NOTE: It’s a doPost() method, not a doGet().
     * @param request request from the session
     * @param response response from the session
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     * @throws SQLException for connection exceptions
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        /**
         * Create a local variable that references the ServletContext.
         */
        ServletContext context = getServletContext();

        // Extract the data for the new Employee from the HTML form.
        String donor_name = request.getParameter("donorName");
        String donation_type = request.getParameter("donationType");
        String donation_weight = request.getParameter("donationWeight");

        /**
         * have to validate the input from the form before accessing database
         */
        if (!validateUserInput(donor_name, donation_type, donation_weight, request)) {

        logger.debug("test");

            // Send a redirect the browser to the Add Donation page
            response.sendRedirect(request.getContextPath() + "/DonationAdd.jsp");
            return;
        }

        // Instantiate donationDAO
        donationDAO = new DonationDAO();

        // get todays date
        Date donationDate = new Date();

        // create the new donation object
        Donation newDonation = new Donation(donor_name,donation_type,donation_weight,donationDate);

        /*
         * Call insert in donationDAO
         */
        donationDAO.insert(newDonation);

        response.sendRedirect(request.getContextPath() +
                "/DonationAdd.jsp");

        request.getSession().setAttribute("donationAddMessage",
                "You have added your donation.");
    }

    /**
     * have to validate the input coming from the form
     * if they enter a number in a text field or text in number field
     * then the add message will be updated with an error message
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

        // instantiate validation variable to valid, true
        isValid = true;

        /*
         * if the donor name and donation type aren't text
         */
        if (!donor_name.matches("[a-z A-Z]+") ||
              !donation_type.matches("[a-z A-Z]+")) {

             //set the variable to not valid, false
            isValid = false;
        }

        /*
         * if the weight isn't digits
         */
        if (!donation_weight.matches("[0-9]+")){

            //set the variable to not valid, false
            isValid = false;
        }

        /*
         * if the form entries are invalid
         */
        if (!isValid) {
            request.getSession().setAttribute("donationAddMessage",
                    "Invalid Form Input. Please check your entries. "
                            + "Donor, Donation Type can only contain text"
                            + "Weight can only contain digits");
        }

        // return the variable set to valid or invalid
        return isValid;
    }
}

