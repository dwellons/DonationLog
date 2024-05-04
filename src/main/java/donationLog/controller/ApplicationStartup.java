package donationLog.controller;

import donationLog.persistence.DAO;
import weatherAPI.entity.Weather;
import weatherAPI.persistence.WeatherDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Objects;
import java.util.Properties;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project-startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet {

    // Properties object for new weatherDAO object.
    private Properties weatherProperties;

    /**
     * Loads donations and weather information for application start up.
     * @throws ServletException
     */
    public void init() throws ServletException {


    /*
    Load Donations
     */
        // Instantiate a new DAO.
        DAO donationDAO = new DAO();

        // Get Recent entries.
        getServletContext().setAttribute("donations", donationDAO.getRecentDonations());


    /*
    Load Weather
     */
        // New weatherDAO object.
        WeatherDAO weatherDAO = new weatherAPI.persistence.WeatherDAO(weatherProperties);

        // New weather object with weather info loaded from dao.
        Weather weather = weatherDAO.getWeatherInfo();

        // Get the temperature.
        String temperature = weather.getWeatherObservation().getTemperature();

        // Get the location.
        String location = weather.getWeatherObservation().getStationName();

        // Get the current condition.
        String currentCondition = weather.getWeatherObservation().getWeatherCondition();
        String condition = "" ;

        if (Objects.equals(currentCondition, "n/a")) {
            condition = "Clear";
        } else {
            condition = currentCondition;
        }

        // Convert Temp from Celsius to Fahrenheit.
        int tempFar = (int) Math.round(Double.parseDouble(temperature) * ((double) 9/5) + 32);

        // Set the weather values in the request attribute.
        getServletContext().setAttribute("temperature", tempFar);
        getServletContext().setAttribute("location", location);
        getServletContext().setAttribute("condition", condition);

    }
}