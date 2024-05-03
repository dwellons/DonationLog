package weatherAPI.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class returns the weather data.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
public final class Weather{

	@JsonProperty("weatherObservation")
	private WeatherObservation weatherObservation;

	public void setWeatherObservation(WeatherObservation weatherObservation){
		this.weatherObservation = weatherObservation;
	}

	public WeatherObservation getWeatherObservation(){
		return weatherObservation;
	}

	/**
	 * Returns the weather information.
 	 * @return the weatherObservation
	 */
	@Override
 	public String toString(){
		return 
			"Weather{" + 
			"weatherObservation = '" + weatherObservation + '\'' + 
			"}";
	}
}