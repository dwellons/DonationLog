package weatherAPI;

import weatherAPI.persistence.LocationDAO;
import weatherAPI.entity.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTest {


    @Test
    void getCountryCodeSuccess() {
        // new weather dao object
        LocationDAO dao = new LocationDAO();

        Location countryCode = dao.getLocationInfo();

        String placeName = countryCode.getPostalCodes().get(0).getCountryCode();

        assertEquals("US", placeName);
    }

    @Test
    void getPostalCodeSuccess() {
        LocationDAO dao = new LocationDAO();

        Location PostalCode = dao.getLocationInfo();

        String placeName = PostalCode.getPostalCodes().get(0).getPostalCode();

        assertEquals("53534", placeName);
    }

    @Test
    void getStateName() {
        LocationDAO dao = new LocationDAO();

        Location AdminName1 = dao.getLocationInfo();

        String placeName = AdminName1.getPostalCodes().get(0).getAdminName1();

        assertEquals("Wisconsin", placeName);
    }

    @Test
    void getLocationNameSuccess() {

        // new weather dao object
        LocationDAO dao = new LocationDAO();

        // new weather object with location info loaded from dao
        Location location = dao.getLocationInfo();

        // get the name of the location (placeName) out of location object
        // is only one item in the list (0)
        String placeName = location.getPostalCodes().get(0).getPlaceName();

        // does the place name equal edgerton? (input edgerton zip code)
        assertEquals("Edgerton", placeName);
    }

    @Test
    void getLatSuccess() {
        LocationDAO dao = new LocationDAO();

        Location location = dao.getLocationInfo();

        String placeLat = location.getPostalCodes().get(0).getLat();

        assertEquals("42.838605", placeLat);

    }

    @Test
    void getLngSuccess() {
        LocationDAO dao = new LocationDAO();

        Location location = dao.getLocationInfo();

        String placeLng= location.getPostalCodes().get(0).getLng();

        assertEquals("-89.064157", placeLng);

    }
}