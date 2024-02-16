package donationLog.controller;

import donationLog.entity.Users;
import donationLog.persistence.UsersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/deleteUser"}
)
public class DeleteUser extends HttpServlet {

    // Instantiate Logger.
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Extract the donation ID from the request parameter.
        int userID = Integer.parseInt(request.getParameter("userID"));

        logger.debug("TEST In Delete User Before DAO call: {}",  request.getAttribute("userID"));

        // Instantiate UsersDAO.
        UsersDAO usersDAO = new UsersDAO();

        // Retrieve the donation to delete.
        Users donationToDelete = usersDAO.getById(userID);

        // Delete the donation from the database
        usersDAO.delete(donationToDelete);

        // Set a session attribute for the donationDeleteMessage.
        request.getSession().setAttribute("userDeleteMessage",
                "You have successfully removed user number " + userID + ".");

        // Redirect to the ReadUserss servlet to display updated donation list.
        response.sendRedirect(request.getContextPath() + "/readUsers?submit=Show+All+Users");
    }
}
