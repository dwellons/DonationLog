package donationLog.persistence;

import donationLog.entity.Donation;


import donationLog.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Before;
import org.junit.Test;



import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

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
        Donation retrievedDonation = donationDAO.getById(7);
        assertNotNull(retrievedDonation);
        assertEquals("Darin", retrievedDonation.getDonorName());
        logger.info("RESULTS: " + retrievedDonation + " " + retrievedDonation.getDonorName() + " RESULTS");
        // assertEquals shows this, don't really need logger.info for this.
    }

    @Test
    public void updateSuccess() {
        // get a record out of the database
        donationDAO = new DonationDAO();
        Donation donationToUpdate = donationDAO.getById(1);

        // change the name on that user
        donationToUpdate.setDonationType("Dairy");

        // do the update
        donationDAO.update(donationToUpdate);

        // retrieve the user and check that the name change worked
        Donation actualDonation = donationDAO.getById(1);

        // do comparison
        assertEquals("Dairy", actualDonation.getDonationType());
    }

    @Test
    public void testInsertSuccess() {
        donationDAO = new DonationDAO();

        Date birthdate = new Date(1989,10,16);

        int donationID = 0;
        Donation newDonation = new Donation(donationID, "Nirad", "Snollew", "nsnollew", birthdate);

        newDonation.setDonationDate(birthdate);

        int insertedUserId = donationDAO.insert(newDonation);

        assertNotEquals(0, insertedUserId);

        Donation insertedDonation = donationDAO.getById(insertedUserId);
        assertEquals("Nirad", insertedDonation.getDonorName());


    }
    @Test
    public void testDelete() {
        //create new user
        donationDAO = new DonationDAO();
        // get the user with id of two, delete it
        donationDAO.delete(donationDAO.getById(2));
        // if delete is working, shouldn't get a user back
        assertNull(donationDAO.getById(2));

    }
    @Test
    public void getAll() {
        donationDAO = new DonationDAO();
        List<Donation> donations = donationDAO.getAll();
        assertEquals(7, donations.size());

    }

    @Test
    public void testGetByPropertyEqual() {
        donationDAO = new DonationDAO();
        List<Donation> donations = donationDAO.getByPropertyLike("lastName", "Curry");
        assertEquals(1, donations.size());
        assertEquals(3, donations.get(0).getDonationID());

    }

    @Test
    public void testGetByPropertyLike() {
        donationDAO = new DonationDAO();
        List<Donation> donations = donationDAO.getByPropertyLike("lastName", "c");
        assertEquals(3, donations.size());
    }
}