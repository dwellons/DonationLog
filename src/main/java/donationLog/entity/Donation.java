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

    /**
     * Instantiates constructors.
     */
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


    public int getDonationID() {
        return donationID;
    }

    public void setDonationID(int donationID) {
        this.donationID = donationID;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getDonationWeight() {
        return donationWeight;
    }

    public void setDonationWeight(String donationWeight) {
        this.donationWeight = donationWeight;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

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