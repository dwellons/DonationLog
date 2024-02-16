package donationLog.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

/**
 * A class to represent a User.
 *
 * @author Darin Wellons
 */
@Entity
@Table(name = "user") // CASE SENSITIVE
public class Users {

    @Id // Need to do this for primary key
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "userName") // Don't have to specify if column is named the same thing as var name (string below)
    private String userName;


    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Donation> donations = new ArrayList<>();


    /**
     * Instantiates a User constructor.
     */
    public Users() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id the id
     * @param userName the userName
     * @param password  the password
     * @param firstName the first name of the user
     * @param lastName the last name of the user

     */
    public Users(int id, String userName, String password, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public void addDonation (Donation donation) {
        donations.add(donation);
        donation.setUser_id(this);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getID() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setID(int id) {

        this.id = id;
    }

    /**
     * Gets the userName
     *
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets userName
     *
     * @param userName the userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets a password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets firstName
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets firstName.
     *
     * @param firstName the firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets lastName
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets lastName
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}