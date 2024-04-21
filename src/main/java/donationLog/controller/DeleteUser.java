package donationLog.controller;

import donationLog.entity.Donation;
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
import java.util.List;

/**
 * A servlet that will delete a user
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */

@WebServlet(
        urlPatterns = {"/deleteUser"}
)
public class DeleteUser extends HttpServlet {

    // Instantiate Logger.
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the user id from the request
        int userID = Integer.parseInt(request.getParameter("ID"));

        // instantiate DAO
        DAO usersDAO = new DAO();

        // get the user to delete
        Users userToDelete = usersDAO.getUserById(userID);

        // get the users donations
        List<Donation> donations = usersDAO.getDonationsByUserId(1);

        // remove user id from those donations and set to null
        for (Donation donation : donations) {
            donation.setUser(null);
            usersDAO.updateDonation(donation); // Update donation to reflect disassociation
        }

        // delete the user from the database
        usersDAO.deleteUser(userToDelete);

        // set the userDeleteMessage
        request.getSession().setAttribute("userDeleteMessage",
                "You have successfully removed user number " + userID + ".");

        // redirect to the ReadUsers servlet
        response.sendRedirect(request.getContextPath() + "/readUsers?submit=Show+All+Users");
    }
}