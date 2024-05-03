package donationLog.controller;

import donationLog.entity.Users;
import donationLog.persistence.DAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

/**
 * A servlet that will update users
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
@WebServlet(
        name = "updateUser",
        urlPatterns = { "/updateUser" }
)
public class UpdateUser extends HttpServlet {

    // Instantiate DAO.
    DAO usersDAO;

    // Create a valid or not valid variable for validating form entries.
    private boolean isValid;

    /**
     * Updates a user.
     * @param request  request from the session
     * @param response response from the session
     * @throws ServletException for servlet exceptions
     * @throws IOException      for io exceptions
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract the data for updating the Donation from the HTML form.
        int userID = Integer.parseInt(request.getParameter("ID"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastName");

        // Validate the input from the form before updating the database.
        if (!validateUserInput(userName, firstName, lastName, request)) {

            // Set a session attribute for the update message.
            request.getSession().setAttribute("userUpdateMessage",
                    "Invalid Form Input. Please check your entries. "
                            + "Username, First Name and Last Name can only contain letters.");

            // Forward to the Update User page.
            RequestDispatcher dispatcher = request.getRequestDispatcher("/UserUpdate.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Instantiate DonationDAO.
        usersDAO = new DAO();

        // Retrieve the existing Donation from the database.
        Users userToUpdate = usersDAO.getUserById(userID);

        // Update the existing Donation with the new data.
        userToUpdate.setUserName(userName);
        userToUpdate.setPassword(password);
        userToUpdate.setFirstName(firstName);
        userToUpdate.setLastName(lastName);

        // Call update in donationDAO.
        usersDAO.updateUser(userToUpdate);

        // Set the updated donation as an attribute in the request.
        request.setAttribute("userToUpdate", userToUpdate);

        // Set a session attribute for the update message.
        request.getSession().setAttribute("userUpdateMessage",
                "You have updated the User with ID: " + userID);

        // Forward to the Update User page.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserUpdate.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * Have to validate the input coming from the form.
     * If they enter a number in a text field or text in a number field,
     * then the update message will be updated with an error message
     * @param userName the username
     * @param firstName the first name
     * @param lastName the last name
     * @param request the servlet request attribute
     * @return if the user input is valid or not
     * @throws IOException for io exceptions
     */
    private boolean validateUserInput(String userName, String firstName,
                                      String lastName,
                                      HttpServletRequest request)
            throws IOException {

        // Initialize validation variable to valid, true
        isValid = true;


        // If the username, first name and last name aren't text.
        if (!userName.matches("[a-zA-Z ]+") ||
                !firstName.matches("[a-zA-Z ]+") ||
                !lastName.matches("[a-zA-Z ]+")) {

            // Set the validation variable to not valid, false.
            isValid = false;
        }


        // If the form entries are invalid.
        if (!isValid) {
            request.getSession().setAttribute("userUpdateMessage",
                    "Invalid Form Input. Please check your entries. "
                            + "Username, First Name and Last Name can only contain text.");
        }

        // Return the variable set to valid or invalid.
        return isValid;
    }
}