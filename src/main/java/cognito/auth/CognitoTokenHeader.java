package cognito.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CognitoTokenHeader{

	@JsonProperty("kid")
	private String kid;

	@JsonProperty("alg")
	private String alg;

	public String getKid(){
		return kid;
	}

	public String getAlg(){
		return alg;
	}
}