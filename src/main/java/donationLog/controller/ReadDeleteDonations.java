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
        urlPatterns = {"/readDeleteDonations"}
)

public class ReadDeleteDonations extends HttpServlet {

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.debug("TEST In Read Delete Donations Before DAO call" + request.getAttribute("submit"));

        // Instantiate a new DonationDAO.
        DonationDAO donationDAO = new DonationDAO();

        // If submit attribute = Submit, search.
        if (request.getParameter("submit").equals("Remove")) {
            //get my donations (donations), call donationDAO method, pass in the donation
            request.setAttribute("donations", donationDAO.getById(Integer.parseInt(request.getParameter("donationID"))));
        } else {
            // Get all entries.
            request.setAttribute("donations", donationDAO.getAll());
        }

        /*
         * The servlet will forward the request and response
         * to the Results JSP page.
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DonationDelete.jsp");
        dispatcher.forward(request,response);
    }
}