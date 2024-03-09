package donationLog.controller;


import donationLog.persistence.DonationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * A Servlet to Search Donations
 * @author Darin Wellons
 */
@WebServlet(
        urlPatterns = {"/readDonations"}
)

public class ReadDonations extends HttpServlet {

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.debug("TEST In Search Donations Before DAO call" + request.getAttribute("submit"));

        // Instantiate a new DonationDAO.
        DonationDAO donationDAO = new DonationDAO();

        // If submit attribute = Submit, search.
        if (request.getParameter("submit").equals("Submit")) {

            // Get my donations, call donationDAO method, pass in the donation.
            request.setAttribute("donations", donationDAO.getByPropertyEqual(request.getParameter("searchType"), request.getParameter("searchTerm")));
        } else {

            // Get all entries.
            request.setAttribute("donations", donationDAO.getAll());
        }

        /*
         * The servlet will forward the request and response
         * to the Results JSP page.
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DonationSearchResults.jsp");
        dispatcher.forward(request,response);
    }
}