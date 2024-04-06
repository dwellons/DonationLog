package donationLog.persistence;

import donationLog.entity.Donation;
import donationLog.entity.Users;
import java.util.Date;
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
public class DonationDaoTest {

     @Before
    public void setup() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
         donationDAO = new DAO();
     }

    // Instantiate new DAO's
    DAO donationDAO;

    // for log messages
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testGetByIdSuccess() {
        // get a record out of the database
        Donation retrievedDonation = donationDAO.getDonationById(12);

        assertNotNull(retrievedDonation);

        // Update the expected donor name based on the actual donor name you expect
        assertEquals("Kwik Trip", retrievedDonation.getDonorName());

        logger.info("RESULTS: " + retrievedDonation + " " + retrievedDonation.getDonorName() + " RESULTS");
    }

    @Test
    public void updateSuccess() {
        // get a record out of the database
        Donation donationToUpdate = donationDAO.getDonationById(12);

        // change the name on that user
        donationToUpdate.setDonationType("Dairy");

        // do the update
        donationDAO.updateDonation(donationToUpdate);

        // retrieve the user and check that the name change worked
        Donation actualDonation = donationDAO.getDonationById(12);

        // do comparison
        assertEquals("Dairy", actualDonation.getDonationType());
    }

    @Test
    public void testInsertSuccess() {

        Date donationDate = new Date(1989,10,16);
        int donationID = 0;
        int userID = 1;
        Donation newDonation = new Donation(donationID, "Piggly Wiggly", "Bread", "130", donationDate);

        newDonation.setDonationDate(donationDate);

        int insertedUserId = donationDAO.insertDonation(newDonation);

        assertNotEquals(0, insertedUserId);

        Donation insertedDonation = donationDAO.getDonationById(insertedUserId);
        assertEquals("Piggly Wiggly", insertedDonation.getDonorName());
    }
    @Test
    public void testDelete() {
        // get the donation with id of 12, delete it
        donationDAO.deleteDonation(donationDAO.getDonationById(12));
        // if delete is working, shouldn't get a donation back
        assertNull(donationDAO.getDonationById(12));

        // check that user is still there after deleting a donation they made
        Users retrievedUser = donationDAO.getUserById(1);
        String expctedUserName = "dwellons";
        assertNotNull(retrievedUser);
        assertTrue(expctedUserName.equals(retrievedUser.getUserName()));
    }
    @Test
    public void getAll() {
        // get all the donations in the list
        List<Donation> donations = donationDAO.getAllDonations();
        assertEquals(7, donations.size());

    }

    @Test
    public void testGetByPropertyEqual() {
        // get all donations with property name exactly like "kwik trip"
        List<Donation> donations = donationDAO.getDonationByPropertyLike("donorName", "Kwik Trip");
        assertEquals(4, donations.size());
        assertEquals(12, donations.get(0).getDonationID());

    }

    @Test
    public void testGetByPropertyLike() {
        // get all donations with property name like "kwik trip"
        List<Donation> donations = donationDAO.getDonationByPropertyLike("donorName", "Kwik Trip");
        assertEquals(4, donations.size());
    }
}