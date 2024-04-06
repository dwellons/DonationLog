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
    DAO usersDAO;

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Create a valid or not valid variable for validating form entries.
    private boolean isValid;

    /**
     * The doPost() method will perform the following:
     * Extract the data for the new Employee from the HTML form.
     * Call the add employee method in the EmployeeDirectory
     * instance and pass the form data as arguments.
     * Add the returned message to the session.
     * Send a redirect the browser to the Add Employee page
     * NOTE: It’s a doPost() method, not a doGet().
     * @param request request from the session
     * @param response response from the session
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     * @throws SQLException for connection exceptions
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        /**
         * Create a local variable that references the ServletContext.
         */
        ServletContext context = getServletContext();

        // Extract the data for the new User from the HTML form.
        String user_name = request.getParameter("userName");
        String password = request.getParameter("password");
        String first_name = request.getParameter("firstName");
        String last_name = request.getParameter("lastName");

        int id = 0;

        // Have to validate the input from the form before accessing database.
        if (!validateUserInput(user_name, password, first_name, last_name, request)) {

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

        // Redirect to Results page.

        response.sendRedirect("/DonationLog_war/readUsers?submit=Show+All+Users");

        request.getSession().setAttribute("userAddMessage",
                "You have added a new user.");
    }

    /**
     * Have to validate the input coming from the form.
     * If they enter a number in a text field or text in number field,
     * then the add message will be updated with an error message.
     * @param user_name the username
     * @param password the password
     * @param first_name the first name
     * @param last_name the last name
     * @param request the http request
     * @return isValid if the entry is valid
     * @throws IOException
     */
    private boolean validateUserInput(String user_name, String password,
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
            request.getSession().setAttribute("userAddMessage",
                    "Invalid Form Input. Please check your entries. "
                            + "Username, First Name and Last Name can only contain text.");
        }

        // Return the variable set to valid or invalid.
        return isValid;
    }
}