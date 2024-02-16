package donationLog.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 * A class to represent a Donation.
 *
 * @author Darin Wellons
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
    private Users user_id;

    // Empty Constructor.
    public Donation() {
    }

    /**
     * Instantiates a new Donation.
     * @param donationID
     * @param donorName
     * @param donationType
     * @param donationWeight
     * @param donationDate
     */
    public Donation(int donationID, String donorName, String donationType, String donationWeight, Date donationDate) {
        this.donationID = donationID;
        this.donorName = donorName;
        this.donationType = donationType;
        this.donationWeight = donationWeight;
        this.donationDate = donationDate;

    }


    /**
     * Empty Constructor
     * @return
     */
    public int getDonationID() {
        return donationID;
    }

    /**
     * Constructor
     * @param donationID
     */
    public void setDonationID(int donationID) {
        this.donationID = donationID;
    }


    /**
     *
     * @return
     */
    public String getDonorName() {
        return donorName;
    }

    /**
     *
     * @param donorName
     */
    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    /**
     *
     * @return
     */
    public String getDonationType() {
        return donationType;
    }

    /**
     *
     * @param donationType
     */
    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    /**
     *
     * @return
     */
    public String getDonationWeight() {
        return donationWeight;
    }

    /**
     *
     * @param donationWeight
     */
    public void setDonationWeight(String donationWeight) {
        this.donationWeight = donationWeight;
    }

    /**
     *
     * @return
     */
    public Date getDonationDate() {
        return donationDate;
    }

    /**
     *
     * @param donationDate
     */
    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    /**
     *
     * @return
     */
    public Users getUser_id() {
        return user_id;
    }

    /**
     *
     * @param user_id
     */
    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    /**
     *
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
                ", user_id=" + user_id +
                '}';
    }
}