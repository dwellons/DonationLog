package donationLog.controller;

import donationLog.persistence.DAO;
import weatherAPI.entity.Weather;
import weatherAPI.persistence.WeatherDAO;

import javax.servlet.ServletConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project-startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet {

    @Override
    public void init() throws ServletException {

        // Instantiate a new DAO.
        DAO donationDAO = new DAO();

        // Get Recent entries.
        getServletContext().setAttribute("donations", donationDAO.getRecentDonations());


// Add Weather to DAO?
        /*
        // new weatherDAO object
        DAO dao = new DAO();

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

        // store the weather values in the session to display in sidebar

        getServletContext().setAttribute("temperature", tempFar);
        getServletContext().setAttribute("location", location);
        getServletContext().setAttribute("condition", condition);

        // set the weather values in the request attribute
        getServletContext().setAttribute("temperature", tempFar);
        getServletContext().setAttribute("location", location);
        getServletContext().setAttribute("condition", condition);



         */
    }
}