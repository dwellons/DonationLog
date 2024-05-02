package donationLog.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 * A class to represent a donation.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */

@Entity
@Table(name = "donations") // CASE SENSITIVE
public class Donation {

    @Id // Need to do this for primary key
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int donationID;
    @Column(name = "donor_name") // Don't have to specify if column is named the same thing as var name (string below)
    private String donorName;

    @Column(name = "donation_type")
    private String donationType;

    @Column(name = "donation_weight")
    private String donationWeight;

    @Column(name = "donation_date")
    private Date donationDate;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private Users user;

    // Empty Constructor.
    public Donation() {
    }

    /**
     * Instantiates a new Donation.
     * @param donorName
     * @param donationType
     * @param donationWeight
     * @param donationDate
     */
    public Donation( String donorName, String donationType, String donationWeight, Date donationDate, Users user) {
        this.donorName = donorName;
        this.donationType = donationType;
        this.donationWeight = donationWeight;
        this.donationDate = donationDate;
        this.user = user;
    }

    /**
     * gets donationID
     * @return donationID
     */
    public int getDonationID() {
        return donationID;
    }

    /**
     * sets donationID
     * @param donationID
     */
    public void setDonationID(int donationID) {
        this.donationID = donationID;
    }

    /**
     * gets donorName
     * @return
     */
    public String getDonorName() {
        return donorName;
    }

    /**
     * sets donorName
     * @param donorName
     */
    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    /**
     * gets donationType
     * @return
     */
    public String getDonationType() {
        return donationType;
    }

    /**
     * sets donationType
     * @param donationType
     */
    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    /**
     * gets donationWeight
     * @return
     */
    public String getDonationWeight() {
        return donationWeight;
    }

    /**
     * sets donationWeight
     * @param donationWeight
     */
    public void setDonationWeight(String donationWeight) {
        this.donationWeight = donationWeight;
    }

    /**
     * gets donationDate
     * @return
     */
    public Date getDonationDate() {
        return donationDate;
    }

    /**
     * sets donationDate
     * @param donationDate
     */
    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    /**
     * gets user_id
     *
     * @return
     */
    public Users getUser() {
        return user;
    }

    /**
     * sets user_id
     * @param user
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * The returned donation information
     * @return
     */
    @Override
    public String toString() {
        return "Donation{" +
                "donationID=" + donationID +
                ", donorName='" + donorName + '\'' +
                ", donationType='" + donationType + '\'' +
                ", donationWeight='" + donationWeight + '\'' +
                ", donationDate=" + donationDate +
                ", user_id=" + user +
                '}';
    }
}