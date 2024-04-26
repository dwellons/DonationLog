package donationLog.controller;

import donationLog.persistence.DAO;

import javax.servlet.ServletConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project-startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet {

    @Override
    public void init() throws ServletException {

        // Instantiate a new DAO.
        DAO donationDAO = new DAO();

        // Get Recent entries.
        getServletContext().setAttribute("donations", donationDAO.getRecentDonations());



    }
}