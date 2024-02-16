package donationLog.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 * Create a servlet that has one simple purpose,
 * to forward to the Add Donation JSP Page
 *
 */
@WebServlet(
        name = "CreateDonationJSPDisplay",
        urlPatterns = { "/CreateDonationJSPDisplay" }
)
public class CreateDonationJSPDisplay extends HttpServlet {

    /**
     * The servlet will only have a doGet() method
     * which forwards to the JSP page
     * @param request request from the session
     * @param response response from the session
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Forward to DonationCreate JSP Page
        String url = "CreateDonation.jsp";


        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}