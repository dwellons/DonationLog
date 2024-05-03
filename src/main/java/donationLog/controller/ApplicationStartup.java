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

    // properties object for new weatherDAO object
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
        // new weatherDAO object
        WeatherDAO weatherDAO = new weatherAPI.persistence.WeatherDAO(weatherProperties);

        // new weather object with weather info loaded from dao
        Weather weather = weatherDAO.getWeatherInfo();

        // get the temperature
        String temperature = weather.getWeatherObservation().getTemperature();

        // get the location
        String location = weather.getWeatherObservation().getStationName();

        // get the current condition
        String currentCondition = weather.getWeatherObservation().getWeatherCondition();
        String condition = "" ;

        if (Objects.equals(currentCondition, "n/a")) {
            condition = "Clear";
        } else {
            condition = currentCondition;
        }

        // Convert Temp from Celsius to Fahrenheit
        double tempFar = 0.00;
        tempFar = Double.parseDouble(temperature) * ((double) 9/5) + 32;

        // set the weather values in the request attribute
        getServletContext().setAttribute("temperature", tempFar);
        getServletContext().setAttribute("location", location);
        getServletContext().setAttribute("condition", condition);

    }
}