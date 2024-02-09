package donationLog.controller;


import donationLog.persistence.DonationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */
@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchDonations extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //instantiate a new donationDAO
        // make sure you unit test things before using things on front end
        DonationDAO donationDAO = new DonationDAO();

        // if submit attribute = search
        if (request.getParameter("submit").equals("Submit")) {
            //get my donations (donations), call donationDAO method, pass in the last name
            request.setAttribute("donation", donationDAO.getByPropertyEqual(request.getParameter("searchType"), request.getParameter("searchTerm")));
        } else {
            // get all
            request.setAttribute("donation", donationDAO.getAll());
        }

        /*
         * The servlet will forward the request and response
         * to the Results JSP page.
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Results.jsp");
        dispatcher.forward(request, response);
    }
}