package weatherAPI.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weatherAPI.entity.Location;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * This class searches for weather information based on the stored zip code.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
public class LocationDAO {
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

    /**
     * gets the weather information for the stored zip code.
     * @return
     */
    public Location getLocationInfo() {
        Client client = ClientBuilder.newClient();

        WebTarget target =
                client.target("http://api.geonames.org/postalCodeSearchJSON?username=" +
                        username + "&postalcode=" + zipCode + "&country=" + country);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        Location location = null;

        try {
            location = mapper.readValue(response, Location.class);

        } catch (JsonProcessingException e) {
            //TODO setup logging
            throw new RuntimeException(e);
        }
        return location;
    }


}
