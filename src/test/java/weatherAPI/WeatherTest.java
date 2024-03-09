package weatherAPI;

import weatherAPI.persistence.WeatherDAO;
import weatherAPI.entity.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    // this will only pass while the current condition matches
    @Test
    void getObservation() {
        WeatherDAO dao = new WeatherDAO();

        Weather weather = dao.getWeatherInfo();

        String observation = weather.getWeatherObservation().getObservation();

        assertEquals("KJVL 090615Z AUTO 34008KT 10SM OVC011 03/03 A2985 RMK AO2", observation);
    }

    // this will only pass while the current condition matches
    @Test
    void getClouds() {
        WeatherDAO dao = new WeatherDAO();

        Weather weather = dao.getWeatherInfo();

        String clouds = weather.getWeatherObservation().getClouds();

        assertEquals("overcast", clouds);
    }

    // this will only pass while the current condition matches
    @Test
    void getTemperature() {
        WeatherDAO dao = new WeatherDAO();

        Weather weather = dao.getWeatherInfo();

        String temperature = weather.getWeatherObservation().getTemperature();

        assertEquals("3", temperature);
    }

    @Test
    void getStationName() {
        WeatherDAO dao = new WeatherDAO();

        Weather weather = dao.getWeatherInfo();

        String placeName = weather.getWeatherObservation().getStationName();

        assertEquals("Janesville / Rock County", placeName);
    }

    // this will only pass while the current condition matches
    @Test
    void getWeatherCondition() {
        WeatherDAO dao = new WeatherDAO();

        Weather weather = dao.getWeatherInfo();

        String condition = weather.getWeatherObservation().getWeatherCondition();

        assertEquals("n/a", condition);
    }

    // this will only pass while the current condition matches
    @Test
    void getWindDirection() {
        WeatherDAO dao = new WeatherDAO();

        Weather weather = dao.getWeatherInfo();

        int windDirection = weather.getWeatherObservation().getWindDirection();

        assertEquals(340, windDirection);
    }

    // this will only pass while the current condition matches
    @Test
    void getWindSpeed() {
        WeatherDAO dao = new WeatherDAO();

        Weather weather = dao.getWeatherInfo();

        String windSpeed = weather.getWeatherObservation().getWindSpeed();

        assertEquals("08", windSpeed);
    }
}