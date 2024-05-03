package donationLog.controller;


import donationLog.persistence.DAO;

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
 * A servlet that will search users
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */

@WebServlet(
        urlPatterns = {"/readUsers"}
)

public class ReadUsers extends HttpServlet {

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Reads the users.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Instantiate a new DonationDAO.
        DAO usersDAO = new DAO();

        // If submit attribute = Submit, search.
        if (request.getParameter("submit").equals("Submit")) {

            // Get my Users, call usersDAO method, pass in the donation.
            request.setAttribute("users", usersDAO.getUserByPropertyEqual(request.getParameter("searchType"), request.getParameter("searchTerm")));
        } else {
            // Get all entries.
            request.setAttribute("users", usersDAO.getAllUsers());
        }

        /*
         * The servlet will forward the request and response
         * to the Results JSP page.
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSearchResults.jsp");
        dispatcher.forward(request,response);
    }
}