package donationLog.controller;

import donationLog.entity.Users;
import donationLog.persistence.DAO;
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

        // Extract the user ID from the request parameter.
        int userID = Integer.parseInt(request.getParameter("ID"));

        logger.debug("TEST In Delete User Before DAO call: {}",  request.getAttribute("ID"));

        // Instantiate DAO.
        DAO usersDAO = new DAO();

        // Retrieve the user to delete.
        Users donationToDelete = usersDAO.getUserById(userID);

        // Delete the user from the database.
        usersDAO.deleteUser(donationToDelete);

        // Set a session attribute for the userDeleteMessage.
        request.getSession().setAttribute("userDeleteMessage",
                "You have successfully removed user number " + userID + ".");

        // Redirect to the ReadUsers servlet to display updated donation list.
        response.sendRedirect(request.getContextPath() + "/readUsers?submit=Show+All+Users");
    }
}
