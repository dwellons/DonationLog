package donationLog.persistence;

import donationLog.entity.Donation;
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

public class DonationDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get user by id
     */
    public Donation getById(int id) {
        Session session = sessionFactory.openSession();
        Donation donation = session.get(Donation.class, id);
        session.close();
        return donation;
    }

    /**
     * update donation
     * @param donation  Donation to be updated
     */
    public void update(Donation donation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // merge is for updating
        session.merge(donation);
        transaction.commit();
        session.close();
    }

    /**
     * insert a new donation
     * @param donation  Donation to be inserted
     */
    public int insert(Donation donation) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // persist is for adding
        session.persist(donation);
        transaction.commit();
        id = donation.getId();
        session.close();
        return id;
    }

    /**
     * Delete a donation
     * @param donation Donation to be deleted
     */
    public void delete(Donation donation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(donation);
        transaction.commit();
        session.close();
    }


    /** Return a list of all users
     *
     * @return All users
     */
    public List<Donation> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donation> query = builder.createQuery(Donation.class);
        Root<Donation> root = query.from(Donation.class);
        List<Donation> donations = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of donations " + donations);
        session.close();

        return donations;
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Donation> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        // will insert values into curly braces {}
        logger.debug("Searching for user with {} {} ", propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donation> query = builder.createQuery(Donation.class);
        Root<Donation> root = query.from(Donation.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Donation> donations = session.createSelectionQuery( query ).getResultList();

        session.close();
        return donations;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Donation> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donation> query = builder.createQuery(Donation.class);
        Root<Donation> root = query.from(Donation.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Donation> donations = session.createQuery( query ).getResultList();
        session.close();
        return donations;
    }

}
