package weatherAPI.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weatherAPI.entity.Weather;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * This class searches for weather information based on the stored zip code.
 */
public class WeatherDAO {
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

    /**
     * gets the weather information for the stored zip code.
     * @return
     */
    public Weather getWeatherInfo() {
        Client client = ClientBuilder.newClient();

        WebTarget target =
                client.target("http://api.geonames.org/findNearByWeatherJSON?username=" +
                        username + "&lat=" + lat + "&lng=" + lng);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        Weather weather = null;

        try {
            weather = mapper.readValue(response, Weather.class);

        } catch (JsonProcessingException e) {
            //TODO setup logging
            throw new RuntimeException(e);
        }
        return weather;
    }



}
