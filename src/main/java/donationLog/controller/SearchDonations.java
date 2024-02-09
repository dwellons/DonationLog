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
 * A simple servlet to welcome the user.
 * @author pwaite
 */
@WebServlet(
        urlPatterns = {"/searchDonations"}
)

public class SearchDonations extends HttpServlet {

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.debug("TEST In Search Donations Before DAO call" + request.getAttribute("donation"));

        //instantiate a new donationDAO
        // make sure you unit test things before using things on front end
        DonationDAO donationDAO = new DonationDAO();

        // if submit attribute = search
        if (request.getParameter("submit").equals("Submit")) {
            //get my donations (donations), call donationDAO method, pass in the donation
            request.setAttribute("donation", donationDAO.getByPropertyEqual(request.getParameter("searchType"), request.getParameter("searchTerm")));
        } else {
            // get all
            request.setAttribute("donation", donationDAO.getAll());
        }

        /*
         * The servlet will forward the request and response
         * to the Results JSP page.
         */

        // for search results
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/Results.jsp");
        // dispatcher.forward(request, response);

        RequestDispatcher dispatcher2 = request.getRequestDispatcher("/index.jsp");
        dispatcher2.forward(request,response);
    }
}