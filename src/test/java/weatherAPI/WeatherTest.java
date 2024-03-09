package weatherAPI;

import weatherAPI.persistence.WeatherDAO;
import weatherAPI.entity.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    // this will only pass while the current condition matches
    @Test
    void getObservation() {
        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        // new weather object with weather info loaded from dao
        Weather weather = dao.getWeatherInfo();

        // get the name of the station
        String observation = weather.getWeatherObservation().getObservation();

        // does the place name equal edgerton? (input edgerton zip code)
        assertEquals("KJVL 090315Z AUTO 34012G17KT 10SM RA BKN010 OVC013 03/03 A2988 RMK AO2", observation);
    }

    // this will only pass while the current condition matches
    @Test
    void getClouds() {
        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        // new weather object with weather info loaded from dao
        Weather weather = dao.getWeatherInfo();

        // get the name of the station
        String clouds = weather.getWeatherObservation().getClouds();

        // does the place name equal edgerton? (input edgerton zip code)
        assertEquals("broken clouds", clouds);
    }

    // this will only pass while the current condition matches
    @Test
    void getTemperature() {
        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        // new weather object with weather info loaded from dao
        Weather weather = dao.getWeatherInfo();

        // get the name of the station
        String temperature = weather.getWeatherObservation().getTemperature();

        // does the place name equal edgerton? (input edgerton zip code)
        assertEquals("3", temperature);
    }

    @Test
    void getStationName() {
        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        // new weather object with weather info loaded from dao
        Weather weather = dao.getWeatherInfo();

        // get the name of the station
        String placeName = weather.getWeatherObservation().getStationName();

        // does the place name equal edgerton? (input edgerton zip code)
        assertEquals("Janesville / Rock County", placeName);
    }

    // this will only pass while the current condition matches
    @Test
    void getWeatherCondition() {
        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        // new weather object with weather info loaded from dao
        Weather weather = dao.getWeatherInfo();

        // get the name of the station
        String condition = weather.getWeatherObservation().getWeatherCondition();

        // does the place name equal edgerton? (input edgerton zip code)
        assertEquals("rain", condition);
    }

    // this will only pass while the current condition matches
    @Test
    void getWindDirection() {
        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        // new weather object with weather info loaded from dao
        Weather weather = dao.getWeatherInfo();

        // get the name of the station
        int windDirection = weather.getWeatherObservation().getWindDirection();

        // does the place name equal edgerton? (input edgerton zip code)
        assertEquals(340, windDirection);
    }

    // this will only pass while the current condition matches
    @Test
    void getWindSpeed() {
        // new weather dao object
        WeatherDAO dao = new WeatherDAO();

        // new weather object with weather info loaded from dao
        Weather weather = dao.getWeatherInfo();

        // get the name of the station
        String windSpeed = weather.getWeatherObservation().getWindSpeed();

        // does the place name equal edgerton? (input edgerton zip code)
        assertEquals("12", windSpeed);
    }
}