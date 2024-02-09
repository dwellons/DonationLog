package donationLog.persistence;

import donationLog.entity.Donation;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import donationLog.util.Database;

public class DonationDaoTest {

    @Before
    public void setup() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    DonationDAO donationDAO;

    // for log messages
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testGetByIdSuccess() {
        donationDAO = new DonationDAO();

        // Assuming getById method exists in DonationDAO
        Donation retrievedDonation = donationDAO.getById(9);

        assertNotNull(retrievedDonation);

        // Update the expected donor name based on the actual donor name you expect
        assertEquals("Kwik Trip", retrievedDonation.getDonorName());

        logger.info("RESULTS: " + retrievedDonation + " " + retrievedDonation.getDonorName() + " RESULTS");
    }


    @Test
    public void updateSuccess() {
        // get a record out of the database
        donationDAO = new DonationDAO();
        Donation donationToUpdate = donationDAO.getById(9);

        // change the name on that user
        donationToUpdate.setDonationType("Dairy");

        // do the update
        donationDAO.update(donationToUpdate);

        // retrieve the user and check that the name change worked
        Donation actualDonation = donationDAO.getById(9);

        // do comparison
        assertEquals("Dairy", actualDonation.getDonationType());
    }

    @Test
    public void testInsertSuccess() {
        donationDAO = new DonationDAO();

        Date donationDate = new Date(1989,10,16);

        int donationID = 0;
        Donation newDonation = new Donation(donationID, "Piggly Wiggly", "Bread", "130", donationDate);

        newDonation.setDonationDate(donationDate);

        int insertedUserId = donationDAO.insert(newDonation);

        assertNotEquals(0, insertedUserId);

        Donation insertedDonation = donationDAO.getById(insertedUserId);
        assertEquals("Piggly Wiggly", insertedDonation.getDonorName());


    }
    @Test
    public void testDelete() {
        //create new user
        donationDAO = new DonationDAO();
        // get the user with id of two, delete it
        donationDAO.delete(donationDAO.getById(9));
        // if delete is working, shouldn't get a user back
        assertNull(donationDAO.getById(9));

    }
    @Test
    public void getAll() {
        donationDAO = new DonationDAO();
        List<Donation> donations = donationDAO.getAll();
        assertEquals(6, donations.size());

    }

    @Test
    public void testGetByPropertyEqual() {
        donationDAO = new DonationDAO();
        List<Donation> donations = donationDAO.getByPropertyLike("donorName", "Kwik Trip");
        assertEquals(6, donations.size());
        assertEquals(9, donations.get(0).getDonationID());

    }

    @Test
    public void testGetByPropertyLike() {
        donationDAO = new DonationDAO();
        List<Donation> donations = donationDAO.getByPropertyLike("donorName", "Kwik Trip");
        assertEquals(6, donations.size());
    }
}