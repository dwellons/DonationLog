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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * A Servlet to Search Donations
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

        logger.debug("TEST In Search Donations Before DAO call" + request.getAttribute("submit"));

        // this will only pass while the current condition matches

        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        // new weather object with weather info loaded from dao
        Weather weather = dao.getWeatherInfo();

        // get the name of the station
        String temperature = weather.getWeatherObservation().getTemperature();

        // does the place name equal edgerton? (input edgerton zip code)

        /*
         * The servlet will forward the request and response
         * to the Results JSP page.
         */


        RequestDispatcher dispatcher = request.getRequestDispatcher("/DonationSearchResults.jsp");
        dispatcher.forward(request,response);
    }
}


