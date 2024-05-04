package donationLog.controller;

import donationLog.entity.Donation;
import donationLog.entity.Users;
import donationLog.persistence.DAO;
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

    /**
     * Deletes a user.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the user id from the request.
        int userID = Integer.parseInt(request.getParameter("ID"));

        // Instantiate DAO.
        DAO usersDAO = new DAO();

        // Get the user to delete.
        Users userToDelete = usersDAO.getUserById(userID);

        // Get the users donations.
        List<Donation> donations = usersDAO.getDonationsByUserId(1);

        // Remove user id from those donations and set to null.
        for (Donation donation : donations) {
            donation.setUser(null);
            usersDAO.updateDonation(donation);
        }

        // Delete the user from the database.
        usersDAO.deleteUser(userToDelete);

        // Set the userDeleteMessage.
        StringBuilder deleteMessage = new StringBuilder();
        deleteMessage.append("You have successfully removed user number ").append(userID).append(".");
        request.getSession().setAttribute("userDeleteMessage", deleteMessage.toString());

        // Redirect to the ReadUsers servlet.
        response.sendRedirect(request.getContextPath() + "/readUsers?submit=Show+All+Users");
    }
}
