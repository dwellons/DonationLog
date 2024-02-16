package donationLog.persistence;

import donationLog.entity.Users;
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

public class UsersDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets Users by ID.
     * @param id
     * @return
     */
    public Users getById(int id) {
        Session session = sessionFactory.openSession();
        Users user = session.get(Users.class, id);
        session.close();
        return user;
    }

    /**
     * Updates users.
     * @param user
     */
    public void update(Users user) {
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
    public int insert(Users user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // persist is for adding
        session.persist(user);
        transaction.commit();
        id = user.getID();
        session.close();
        return id;
    }

    /**
     * Deletes users.
     * @param user
     */
    public void delete(Users user) {
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
    public List<Users> getAll() {

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
    public List<Users> getByPropertyEqual(String propertyName, String value) {
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
    public List<Users> getByPropertyLike(String propertyName, String value) {
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
}
