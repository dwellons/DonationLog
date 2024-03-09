package donationLog.persistence;

import donationLog.entity.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherTest {


    @Test
    void getCountryCodeSuccess() {
        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        Weather countryCode = dao.getLocationInfo();

        String placeName = countryCode.getPostalCodes().get(0).getCountryCode();

        assertEquals("US", placeName);
    }

    @Test
    void getPostalCodeSuccess() {
        WeatherDAO dao = new WeatherDAO();

        Weather PostalCode = dao.getLocationInfo();

        String placeName = PostalCode.getPostalCodes().get(0).getPostalCode();

        assertEquals("53534", placeName);
    }

    @Test
    void getStateName() {
        WeatherDAO dao = new WeatherDAO();

        Weather AdminName1 = dao.getLocationInfo();

        String placeName = AdminName1.getPostalCodes().get(0).getAdminName1();

        assertEquals("Wisconsin", placeName);
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
        WeatherDAO dao = new WeatherDAO();

        Weather location = dao.getLocationInfo();

        String placeLat = location.getPostalCodes().get(0).getLat();

        assertEquals("42.838605", placeLat);

    }

    @Test
    void getLngSuccess() {
        WeatherDAO dao = new WeatherDAO();

        Weather location = dao.getLocationInfo();

        String placeLng= location.getPostalCodes().get(0).getLng();

        assertEquals("-89.064157", placeLng);

    }
}