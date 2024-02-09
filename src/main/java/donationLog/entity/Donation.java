package donationLog.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * A class to represent a Donation.
 *
 * @author Darin Wellons
 */
@Entity
@Table(name = "donations") // CASE SENSITIVE
public class Donation {
    @Column(name = "donor_name") // Don't have to specify if column is named the same thing as var name (string below)
    private String donorName;

    @Column(name = "donation_type")
    private String donationType;

    @Column(name = "donation_weight")
    private String donationWeight;

    @Id // need to do this for primary key
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int donationID;

    @Column(name = "donation_date")
    private Date donationDate;

    /**
     * Instantiates a new Donation.
     */
    public Donation() {
    }

    /**
     * Instantiates a new Donation.
     *
     * @param donorName the donors name
     * @param donationType  the donation type
     * @param donationWeight  the donation weight
     * @param donationDate the date of the donation
     */
    public Donation(String donorName, String donationType, String donationWeight, Date donationDate) {
        this.donorName = donorName;
        this.donationType = donationType;
        this.donationWeight = donationWeight;
        this.donationDate = donationDate;

    }

    /**
     * Gets the donors name
     *
     * @return the donors name
     */
    public String getDonorName() {
        return donorName;
    }

    /**
     * Sets donors name
     *
     * @param donorName the donor name
     */
    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    /**
     * Gets donation type
     *
     * @return the donation type
     */
    public String getDonationType() {
        return donationType;
    }

    /**
     * Sets donation type
     *
     * @param donationType the donation type
     */
    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    /**
     * Gets a donations weight
     *
     * @return the donation weight
     */
    public String getDonationWeight() {
        return donationWeight;
    }

    /**
     * Sets the donation's weight
     *
     * @param donationWeight the donations weight
     */
    public void setDonationWeight(String donationWeight) {
        this.donationWeight = donationWeight;
    }

    /**
     * Gets donationID.
     *
     * @return the donationID
     */
    public int getId() {
        return donationID;
    }

    /**
     * Sets donationID.
     *
     * @param donationID the donationID
     */
    public void setId(int donationID) {

        this.donationID = donationID;
    }

    /**
     * Gets donationDate
     *
     * @return the date of the donation
     */
    public Date getDonationDate() {
        return donationDate;
    }

    /**
     * Sets donationDate.
     *
     * @param donationDate the date of the donation
     */
    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "donorName='" + donorName + '\'' +
                ", donationType='" + donationType + '\'' +
                ", donationWeight='" + donationWeight + '\'' +
                ", donationID='" + donationID + '\'' +
                ", donationDate='" + donationDate + '\'' +
                '}';
    }
}