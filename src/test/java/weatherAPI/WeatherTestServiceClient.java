package weatherAPI;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class creates the inital connection to geonames to collect returned JSON data
 * to use to create new POJO and client
 */
public class WeatherTestServiceClient {

    /**
     * Variable for username.
     * @type {string} username
     */
    String username = "dwellons";

    /**
     * Variable for the country.
     * @type {string} country
     */
    String country = "US";

    /**
     * The zip code
     * @type {int} zipCode
     */
    int zipCode = 53534;
    double lat = 42.838605;
    double lng = -89.064157;

    @Test
    public void testWeather() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.geonames.org/findNearByWeatherJSON?username=" +
                        username + "&lat=" + lat + "&lng=" + lng);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        String expectedLocationName = "";
        assertEquals(expectedLocationName, response);
    }

}
