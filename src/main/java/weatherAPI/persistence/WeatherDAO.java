package weatherAPI.persistence;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weatherAPI.entity.Weather;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

/**
 * This class searches for weather information based on the stored zip code.
 */
public class WeatherDAO implements PropertiesLoader{
    private Properties properties;

    /*
     * load the properties file containing the driver, connection url, userid and pwd.
     */
    private void loadProperties() {
        properties = loadProperties("/weather.properties");
    }

    /**
     * gets the weather information for the stored zip code.
     * @return
     */
    public Weather getWeatherInfo() {
        loadProperties();
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target( properties.getProperty("url") +
                properties.getProperty("username") + "&lat=" + properties.getProperty("lat") +
                "&lng=" + properties.getProperty("lng"));

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