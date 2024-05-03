package donationLog.persistence;

import donationLog.entity.Donation;
import donationLog.entity.Users;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import java.util.List;

/**
 * A Data Access Object class.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
public class DAO{

    // DONATIONS

    // For Logging
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets donations by ID
     * @param id
     * @return
     */
    public Donation getDonationById(int id) {
        Session session = sessionFactory.openSession();
        Donation donation = session.get(Donation.class, id);
        session.close();
        return donation;
    }

    /**
     * Updates donations.
     * @param donation
     */
    public void updateDonation(Donation donation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // merge is for updating
        session.merge(donation);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts donations
     * @param donation
     * @return
     */
    public int insertDonation(Donation donation) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // persist is for adding
        session.persist(donation);
        transaction.commit();
        id = donation.getDonationID();
        session.close();
        return id;
    }

    /**
     * Deletes donations.
     * @param donation
     */
    public void deleteDonation(Donation donation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(donation);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all donations.
     * @return
     */
    public List<Donation> getAllDonations() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donation> query = builder.createQuery(Donation.class);
        Root<Donation> root = query.from(Donation.class);

        List<Donation> donations = session.createSelectionQuery( query ).getResultList();

        session.close();

        return donations;
    }

    /**
     * Searches for property that equals a determined value.
     * @param propertyName
     * @param value
     * @return
     */
    public List<Donation> getDonationByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        // will insert values into curly braces {}
        logger.debug("Searching for a donation with {} {} ", propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donation> query = builder.createQuery(Donation.class);
        Root<Donation> root = query.from(Donation.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Donation> donations = session.createSelectionQuery( query ).getResultList();

        session.close();
        return donations;
    }

    /**
     * Searches for a property that is like a determined value.
     * @param propertyName
     * @param value
     * @return
     */
    public List<Donation> getDonationByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        // will insert values into curly braces {}
        logger.debug("Searching for a donation with {} {} ", propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donation> query = builder.createQuery(Donation.class);
        Root<Donation> root = query.from(Donation.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Donation> donations = session.createQuery( query ).getResultList();
        session.close();
        return donations;
    }

    /**
     * Gets donations by user id.
     * @param userId The user id
     * @return A list of donations associated with the user id
     */
    public List<Donation> getDonationsByUserId(int userId) {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donation> query = builder.createQuery(Donation.class);
        Root<Donation> root = query.from(Donation.class);

        // get donations associated with the given user ID
        query.select(root).where(builder.equal(root.get("user").get("id"), userId));
        List<Donation> donations = session.createSelectionQuery(query).getResultList();

        session.close();

        return donations;
    }

    // USERS

    /**
     * Gets Users by ID.
     * @param id
     * @return
     */
    public Users getUserById(int id) {
        Users user = null;
        Session session = sessionFactory.openSession();
            user = session.get(Users.class, id);
        session.close();
        return user;
    }
    /**
     * Updates users.
     * @param user
     */
    public void updateUser(Users user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // merge is for updating
        session.merge(user);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts new users.
     * @param user
     * @return
     */
    public int insertUser(Users user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // persist is for adding
        session.persist(user);
        transaction.commit();
        id = user.getId();
        session.close();
        return id;
    }

    /**
     * Deletes users.
     * @param user
     */
    public void deleteUser(Users user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    /**
     * Returns a list of all users.
     * @return
     */
    public List<Users> getAllUsers() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        List<Users> users = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of users " + users);
        session.close();

        return users;
    }

    /**
     * Searches for users that match a determined value.
     * @param propertyName
     * @param value
     * @return
     */
    public List<Users> getUserByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        // will insert values into curly braces {}
        logger.debug("Searching for user with {} {} ", propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Users> users = session.createSelectionQuery( query ).getResultList();

        session.close();
        return users;
    }

    /**
     * Searches for users that are like a current value.
     * @param propertyName
     * @param value
     * @return
     */
    public List<Users> getUserByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Users> users = session.createQuery( query ).getResultList();
        session.close();
        return users;
    }

    /**
     * Gets the past 5 donations.
     * @return
     */
    public List<Donation> getRecentDonations() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donation> query = builder.createQuery(Donation.class);
        Root<Donation> root = query.from(Donation.class);

        // Use a typed query to use max results.
        TypedQuery<Donation> typedQuery = session.createQuery(query);

        // Limit to 5 results max.
        int maxResults = 5;
        typedQuery.setMaxResults(maxResults);

        List<Donation> donations = typedQuery.getResultList();

        session.close();

        return donations;
    }
}