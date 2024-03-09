package donationLog.persistence;

import donationLog.entity.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherTest {


    @Test
    void getCountryCodeSuccess() {
    }

    @Test
    void getPostalCodeSuccess() {
    }

    @Test
    void getAdminName1Success() {
    }

    @Test
    void getLocationNameSuccess() {

        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        // new weather object with location info loaded from dao
        Weather location = dao.getLocationInfo();

        // get the name of the location (placeName) out of location object
        // is only one item in the list (0)
        String placeName = location.getPostalCodes().get(0).getPlaceName();

        // does the place name equal edgerton? (input edgerton zip code)
        assertEquals("Edgerton", placeName);
    }

    @Test
    void getLatSuccess() {
    }

    @Test
    void getLngSuccess() {

    }

    @Test
    void testToStringSuccess() {
    }
}