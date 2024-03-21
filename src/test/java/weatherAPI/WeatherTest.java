package weatherAPI;

import weatherAPI.persistence.WeatherDAO;
import weatherAPI.entity.Weather;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    // properties object for new weatherDAO object
    private Properties weatherProperties;

    // constructor for properties object
    public WeatherTest(Properties weatherProperties) {
        this.weatherProperties = weatherProperties;
    }

    // this will only pass while the current condition matches
    @Test
    void getObservation() {
        WeatherDAO dao = new WeatherDAO(weatherProperties);

        Weather weather = dao.getWeatherInfo();

        String observation = weather.getWeatherObservation().getObservation();

        assertEquals("KJVL 200215Z AUTO 27003KT 10SM CLR 06/M07 A2968 RMK AO2", observation);
    }

    // this will only pass while the current condition matches
    @Test
    void getClouds() {
        WeatherDAO dao = new WeatherDAO(weatherProperties);

        Weather weather = dao.getWeatherInfo();

        String clouds = weather.getWeatherObservation().getClouds();

        assertEquals("n/a", clouds);
    }

    // this will only pass while the current condition matches
    @Test
    void getTemperature() {
        WeatherDAO dao = new WeatherDAO(weatherProperties);

        Weather weather = dao.getWeatherInfo();

        String temperature = weather.getWeatherObservation().getTemperature();

        assertEquals("6", temperature);
    }

    @Test
    void getStationName() {
        WeatherDAO dao = new WeatherDAO(weatherProperties);

        Weather weather = dao.getWeatherInfo();

        String placeName = weather.getWeatherObservation().getStationName();

        assertEquals("Janesville / Rock County", placeName);
    }

    // this will only pass while the current condition matches
    @Test
    void getWeatherCondition() {
        WeatherDAO dao = new WeatherDAO(weatherProperties);

        Weather weather = dao.getWeatherInfo();

        String condition = weather.getWeatherObservation().getWeatherCondition();

        assertEquals("n/a", condition);
    }

    // this will only pass while the current condition matches
    @Test
    void getWindDirection() {
        WeatherDAO dao = new WeatherDAO(weatherProperties);

        Weather weather = dao.getWeatherInfo();

        int windDirection = weather.getWeatherObservation().getWindDirection();

        assertEquals(270, windDirection);
    }

    // this will only pass while the current condition matches
    @Test
    void getWindSpeed() {
        WeatherDAO dao = new WeatherDAO(weatherProperties);

        Weather weather = dao.getWeatherInfo();

        String windSpeed = weather.getWeatherObservation().getWindSpeed();

        assertEquals("03", windSpeed);
    }
}