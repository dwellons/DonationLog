package donationLog.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A servlet to sign out the user.
 *
 * @author Darin Wellons
 */
@WebServlet(
        name = "signOut",
        urlPatterns = { "/signOut" }
)
public class SignOut extends HttpServlet {

    /**
     * Signs out a user.
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = req.getRequestDispatcher("ReadRecentDonations");
        dispatcher.forward(req, resp);
    }
}