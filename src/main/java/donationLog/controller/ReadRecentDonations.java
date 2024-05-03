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
 * A servlet that will search recent donations
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
@WebServlet(
        name = "ReadRecentDonations",
        urlPatterns = {"/ReadRecentDonations"}
)
public class ReadRecentDonations extends HttpServlet {

    /**
     * Reads the recent donations.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Instantiate a new DAO.
        DAO donationDAO = new DAO();

        // Get Recent entries.
        request.setAttribute("donations", donationDAO.getRecentDonations());

        /*
         * The servlet will forward the request and response
         * to the index.jsp page.
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);
    }
}