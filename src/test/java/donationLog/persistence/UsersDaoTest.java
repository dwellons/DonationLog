package donationLog.persistence;

import donationLog.entity.Users;
import java.util.List;
import static org.junit.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import donationLog.util.Database;

public class UsersDaoTest {

    @Before
    public void setup() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    UsersDAO usersDAO;

    // for log messages
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testGetByIdSuccess() {
        usersDAO = new UsersDAO();

        // Assuming getById method exists in DonationDAO
        Users retrievedUser = usersDAO.getById(1);
        String expctedUserName = "dwellons";
        assertNotNull(retrievedUser);

        // Using equals();
        // Update the expected donor name based on the actual donor name you expect
        assertTrue(expctedUserName.equals(retrievedUser.getUserName()));

    }

    @Test
    public void updateSuccess() {
        // get a record out of the database
        usersDAO = new UsersDAO();
        Users userToUpdate = usersDAO.getById(1);
        String expectedFirstName = "Nirad";
        // change the name on that user
        userToUpdate.setFirstName("Nirad");

        // do the update
        usersDAO.update(userToUpdate);

        // retrieve the user and check that the name change worked
        Users actualDonation = usersDAO.getById(1);

        // Using equals();
        // do comparison
        assertTrue(expectedFirstName.equals(actualDonation.getFirstName()));


    }

    @Test
    public void testInsertSuccess() {
        usersDAO = new UsersDAO();

        Users newUser = new Users(0, "test", "test", "test", "test");

        int insertedUserId = usersDAO.insert(newUser);
        String expectedUser = "test";
        assertNotEquals(0, insertedUserId);


        Users insertedUser = usersDAO.getById(insertedUserId);

        // Using equals();
        assertTrue(expectedUser.equals(insertedUser.getFirstName()));

    }
    @Test
    public void testDelete() {
        //create new user
        usersDAO = new UsersDAO();
        // get the user with id of nine, delete it
        usersDAO.delete(usersDAO.getById(6));
        // if delete is working, shouldn't get a user back
        assertNull(usersDAO.getById(6));

        // Deletes previous test user that was inserted

    }
    @Test
    public void getAll() {
        usersDAO = new UsersDAO();
        int numberOfUsers = 5;
        List<Users> users = usersDAO.getAll();
        assertEquals(5, users.size());

    }

    @Test
    public void testGetByPropertyEqual() {
        usersDAO = new UsersDAO();
        List<Users> users = usersDAO.getByPropertyLike("userName", "dwellons");
        assertEquals(2, users.size());
        assertEquals(1, users.get(0).getID());

    }

    @Test
    public void testGetByPropertyLike() {
        usersDAO = new UsersDAO();
        List<Users> users = usersDAO.getByPropertyLike("firstName", "Nirad");
        assertEquals(2, users.size());
    }
}