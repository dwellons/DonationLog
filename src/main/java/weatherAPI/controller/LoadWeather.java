package weatherAPI.controller;

import weatherAPI.entity.Weather;
import weatherAPI.persistence.WeatherDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A servlet to display current weather conditions.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
@WebServlet(
        urlPatterns = {"/LoadWeather"}
)

public class LoadWeather extends HttpServlet {

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // properties object for new weatherDAO object
    private Properties weatherProperties;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // new weatherDAO object
        WeatherDAO dao = new WeatherDAO(weatherProperties);

        // new weather object with weather info loaded from dao
        Weather weather = dao.getWeatherInfo();

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
        request.setAttribute("temperature", tempFar);
        request.setAttribute("location", location);
        request.setAttribute("condition", condition);

        // forward the request, if needed:
        // RequestDispatcher dispatcher = request.getRequestDispatcher("DonationSearch.jsp");
        // dispatcher.forward(request, response);
    }
}