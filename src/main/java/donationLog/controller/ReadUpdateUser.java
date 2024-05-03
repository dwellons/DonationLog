package donationLog.controller;

import donationLog.persistence.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A servlet that will update users
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */

@WebServlet(
        urlPatterns = {"/readModifyUser"}
)

public class ReadUpdateUser extends HttpServlet {

    /**
     * Gets a user ready to be updated.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Instantiate a new DAO.
        DAO userDAO = new DAO();

        // If submit attribute = Submit, search.
        if (request.getParameter("submit").equals("Modify")) {

            // Get my users, call userDAO method, pass in the donation.
            request.setAttribute("users", userDAO.getUserById(Integer.parseInt(request.getParameter("userID"))));
        } else {

            // Get all entries.
            request.setAttribute("users", userDAO.getAllUsers());
        }

        /*
         * The servlet will forward the request and response
         * to the Results JSP page.
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserUpdate.jsp");
        dispatcher.forward(request,response);
    }
}