package donationLog.persistence;

import donationLog.entity.Donation;
import donationLog.entity.Users;
import java.util.List;
import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import donationLog.util.Database;

/**
 * A Test for the donations portion of the DAO
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
public class UsersDaoTest {

    // Instantiate new DAO
    DAO usersDAO;
    @Before
    public void setup() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        usersDAO = new DAO();
    }

    // for log messages
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testGetByIdSuccess() {
        Users retrievedUser = usersDAO.getUserById(1);
        String expctedUserName = "dwellons";
        assertNotNull(retrievedUser);

        assertTrue(expctedUserName.equals(retrievedUser.getUserName()));
    }

    @Test
    public void updateSuccess() {
        // get a record out of the database
        Users userToUpdate = usersDAO.getUserById(1);
        String expectedFirstName = "Nirad";
        // change the name on that user
        userToUpdate.setFirstName("Nirad");

        // do the update
        usersDAO.updateUser(userToUpdate);

        // retrieve the user and check that the name change worked
        Users actualDonation = usersDAO.getUserById(1);

        // do comparison
        assertTrue(expectedFirstName.equals(actualDonation.getFirstName()));
    }

    @Test
    public void testInsertSuccess() {
        // insert a test user
        Users newUser = new Users(0, "test", "test", "test", "test");
        int insertedUserId = usersDAO.insertUser(newUser);
        String expectedUser = "test";
        assertNotEquals(0, insertedUserId);

        Users insertedUser = usersDAO.getUserById(insertedUserId);

        // Using equals();
        assertTrue(expectedUser.equals(insertedUser.getFirstName()));

    }

    @Test
    public void testDelete() {

        // get the user
        Users userToDelete = usersDAO.getUserById(1);

        // get the users donations
        List<Donation> donations = usersDAO.getDonationsByUserId(1);

        // remove user id from those donations and set to null
        for (Donation donation : donations) {
            donation.setUser(null);
            usersDAO.updateDonation(donation); // Update donation to reflect disassociation
        }

        // delete the user
        usersDAO.deleteUser(userToDelete);

        // check that the user with ID 1 doesn't exist after deletion
        assertNull(usersDAO.getUserById(1));

        // check that the total count of donations remains the same
        assertEquals(7, usersDAO.getAllDonations().size());
    }


    @Test
    public void getUserById() {
        // get a record out of the database
        Users retrievedUser = usersDAO.getUserById(1);

        assertNotNull(retrievedUser);

        // does user name match what i expect
        assertEquals("dwellons", retrievedUser.getUserName());

        logger.info("RESULTS: " + retrievedUser + " " + retrievedUser.getUserName() + " RESULTS");
    }

    @Test
    public void getAll() {
        // gets all users
        int numberOfUsers = 5;
        List<Users> users = usersDAO.getAllUsers();
        assertEquals(5, users.size());
    }

    @Test
    public void testGetByPropertyEqual() {
        // gets user with property exactly like "dwellons"
        List<Users> users = usersDAO.getUserByPropertyLike("userName", "dwellons");
        assertEquals(2, users.size());
        assertEquals(1, users.get(0).getId());

    }

    @Test
    public void testGetByPropertyLike() {
        // gets users with property like "nirad"
        usersDAO = new DAO();
        List<Users> users = usersDAO.getUserByPropertyLike("firstName", "Nirad");
        assertEquals(2, users.size());
    }
}