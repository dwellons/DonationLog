package weatherAPI.controller;

import weatherAPI.entity.Weather;
import weatherAPI.persistence.WeatherDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A Servlet to Display Current Weather Conditions
 * @author Darin Wellons
 */
@WebServlet(
        urlPatterns = {"/displayWeather"}
)

public class displayWeather extends HttpServlet {

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

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

        // forward the request and response to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayWeather.jsp");
        dispatcher.forward(request, response);
    }
}
