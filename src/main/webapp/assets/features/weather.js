
const getWeather = () => {

    // new weather dao object
    let WeatherDAO = new WeatherDAO();

    // new weather object with weather info loaded from dao
    let Weather = WeatherDAO.getWeatherInfo();

    // get the temperature
    let temperature = Weather.getWeatherObservation().getTemperature();

    // get the location
    let location = Weather.getWeatherObservation.getStationName();

    // does the place name equal edgerton? (input edgerton zip code)
    assertEquals("3", temperature);



            // Convert Temp from Celsius to Fahrenheit
            let tempFar = 0.00;
            tempFar = (9/5 * temperature) + 32;

            // Convert wind from Knots to MPH
            let windMPH = 0.00;
            windMPH = wind * 1.151;

            // Call the formatTotal method
            tempFar = formatTotal(tempFar);
            windMPH = formatTotal(windMPH);

            // Displays the results in the DIV labeled results.
            document.getElementById("weather").getWeather.innerHTML =

                "<table id='resultsTable'>" +

                "<tr><th>Location</th>" +
                "<td>" + location + "</td></tr>" +

                "<tr><th>Temperature</th>" +
                "<td id= 'tempOut'>" + tempFar + "* F</td></tr>" +

                "<tr><th>Wind Speed / Direction</th>" +
                "<td id='windOut'>" + windMPH + " mph, </td></tr>" +

                "</table>";

}


