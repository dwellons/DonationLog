package weatherAPI.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class defines the weather information
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
public final class WeatherObservation{

	@JsonProperty("elevation")
	private int elevation;

	@JsonProperty("lng")
	private Object lng;

	@JsonProperty("weatherConditionCode")
	private String weatherConditionCode;

	@JsonProperty("observation")
	private String observation;

	@JsonProperty("ICAO")
	private String iCAO;

	@JsonProperty("clouds")
	private String clouds;

	@JsonProperty("dewPoint")
	private String dewPoint;

	@JsonProperty("cloudsCode")
	private String cloudsCode;

	@JsonProperty("datetime")
	private String datetime;

	@JsonProperty("countryCode")
	private String countryCode;

	@JsonProperty("temperature")
	private String temperature;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("stationName")
	private String stationName;

	@JsonProperty("weatherCondition")
	private String weatherCondition;

	@JsonProperty("windDirection")
	private int windDirection;

	@JsonProperty("windSpeed")
	private String windSpeed;

	@JsonProperty("lat")
	private Object lat;

	public void setElevation(int elevation){
		this.elevation = elevation;
	}

	public int getElevation(){
		return elevation;
	}

	public void setLng(Object lng){
		this.lng = lng;
	}

	public Object getLng(){
		return lng;
	}

	public void setWeatherConditionCode(String weatherConditionCode){
		this.weatherConditionCode = weatherConditionCode;
	}

	public String getWeatherConditionCode(){
		return weatherConditionCode;
	}

	public void setObservation(String observation){
		this.observation = observation;
	}

	public String getObservation(){
		return observation;
	}

	public void setICAO(String iCAO){
		this.iCAO = iCAO;
	}

	public String getICAO(){
		return iCAO;
	}

	public void setClouds(String clouds){
		this.clouds = clouds;
	}

	public String getClouds(){
		return clouds;
	}

	public void setDewPoint(String dewPoint){
		this.dewPoint = dewPoint;
	}

	public String getDewPoint(){
		return dewPoint;
	}

	public void setCloudsCode(String cloudsCode){
		this.cloudsCode = cloudsCode;
	}

	public String getCloudsCode(){
		return cloudsCode;
	}

	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	public String getDatetime(){
		return datetime;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setTemperature(String temperature){
		this.temperature = temperature;
	}

	public String getTemperature(){
		return temperature;
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public int getHumidity(){
		return humidity;
	}

	public void setStationName(String stationName){
		this.stationName = stationName;
	}

	public String getStationName(){
		return stationName;
	}

	public void setWeatherCondition(String weatherCondition){
		this.weatherCondition = weatherCondition;
	}

	public String getWeatherCondition(){
		return weatherCondition;
	}

	public void setWindDirection(int windDirection){
		this.windDirection = windDirection;
	}

	public int getWindDirection(){
		return windDirection;
	}

	public void setWindSpeed(String windSpeed){
		this.windSpeed = windSpeed;
	}

	public String getWindSpeed(){
		return windSpeed;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"WeatherObservation{" + 
			"elevation = '" + elevation + '\'' + 
			",lng = '" + lng + '\'' + 
			",weatherConditionCode = '" + weatherConditionCode + '\'' + 
			",observation = '" + observation + '\'' + 
			",iCAO = '" + iCAO + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",dewPoint = '" + dewPoint + '\'' + 
			",cloudsCode = '" + cloudsCode + '\'' + 
			",datetime = '" + datetime + '\'' + 
			",countryCode = '" + countryCode + '\'' + 
			",temperature = '" + temperature + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",stationName = '" + stationName + '\'' + 
			",weatherCondition = '" + weatherCondition + '\'' + 
			",windDirection = '" + windDirection + '\'' + 
			",windSpeed = '" + windSpeed + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}