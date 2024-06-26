package donationLog.controller;

import donationLog.entity.Users;
import donationLog.persistence.DAO;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A servlet that will add a new User to the application.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
@WebServlet(
        name = "createUser",
        urlPatterns = { "/createUser" }
)
public class CreateUser extends HttpServlet {

    // Instantiate DAO
    private DAO usersDAO;

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Create a valid or not valid variable for validating form entries.
    private boolean isValid;

    /**
     * Creates a user.
     * @param request request from the session
     * @param response response from the session
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     * @throws SQLException for connection exceptions
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // Extract the data for the new User from the HTML form.
        String user_name = request.getParameter("userName");
        String password = request.getParameter("password");
        String first_name = request.getParameter("firstName");
        String last_name = request.getParameter("lastName");

        int id = 0;

        // Have to validate the input from the form before accessing database.
        if (!validateUserInput(user_name, first_name, last_name, request)) {

            // Send a redirect the browser to the Add User page
            response.sendRedirect(request.getContextPath() + "/UserCreate.jsp");
            return;
        }

        // Instantiate usersDAO.
        usersDAO = new DAO();

        // Create the new user object.
        Users newUser = new Users(id, user_name, password, first_name, last_name);

        // Call Insert in DAO.
        usersDAO.insertUser(newUser);

        // Log the new user
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("You have added the user: ")
                .append(request.getParameter("userName"));
        logger.info(logMessage.toString());

        // Redirect to show all users page.
        response.sendRedirect("/DonationLog_war/readUsers?submit=Show+All+Users");

        // Set the userAddMessage
        request.getSession().setAttribute("userAddMessage",
                logMessage.toString());
    }

    /**
     * Have to validate the input coming from the form.
     * If they enter a number in a text field or text in number field,
     * then the add message will be updated with an error message.
     * @param user_name the username
     * @param first_name the first name
     * @param last_name the last name
     * @param request the http request
     * @return isValid if the entry is valid
     * @throws IOException
     */
    private boolean validateUserInput(String user_name,
                                      String first_name, String last_name,
                                      HttpServletRequest request)
            throws IOException {

        // Instantiate validation variable to valid, true.
        isValid = true;

        // If the donor name and donation type aren't text
        if (!user_name.matches("[a-zA-Z ]+") ||
                !first_name.matches("[a-zA-Z ]+") ||
                !last_name.matches("[a-zA-Z ]+")){

            // Set the variable to not valid, false.
            isValid = false;
        }

        // If the form entries are invalid.
        if (!isValid) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("Invalid Form Input. Please check your entries. ")
                    .append("Username, First Name and Last Name can only contain text.");
            request.getSession().setAttribute("userAddMessage", errorMessage.toString());
        }

        // Return the variable set to valid or invalid.
        return isValid;
    }
}