package weatherAPI.entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents weather for a location
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
public class Location {

	@JsonProperty("postalCodes")
	private List<PostalCodesItem> postalCodes;

	/**
	 * sets the postal codes (item returned from geonames)
	 * @param postalCodes
	 */
	public void setPostalCodes(List<PostalCodesItem> postalCodes){
		this.postalCodes = postalCodes;
	}

	/**
	 * gets the postal codes (item returned from geonames)
	 * @return
	 */
	public List<PostalCodesItem> getPostalCodes(){
		return postalCodes;
	}

	/**
	 * returns the returned information (postalCodes)
	 * @return the postal codes
	 */
	@Override
 	public String toString(){
		return postalCodes.toString();
}
}