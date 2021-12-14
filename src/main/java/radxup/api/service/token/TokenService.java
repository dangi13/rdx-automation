package radxup.api.service.token;

import static radxup.api.utils.common.Constants.BASE_URL;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.response.Response;
import radxup.api.model.Endpoint;
import radxup.api.service.user.UserService;
import radxup.api.service.user.model.User;
import radxup.api.utils.common.CommonUtils;
import radxup.api.utils.http.IRestResponse;
import radxup.api.utils.http.RequestType;
import radxup.api.utils.http.RestClient;
import radxup.api.utils.http.RestResponse;

public class TokenService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TokenService.class);
	private static String TOKEN_PAYLOAD = "";
	
	private static final Map<String, Endpoint> OPERATIONS = new HashMap<String, Endpoint>() {
		private static final long serialVersionUID = 1L;
		{
		    put("generateToken", new Endpoint(BASE_URL + "/api/users/token", RequestType.POST));
		}
	};

	public static RestResponse<Object> generateToken(HashMap<String, String> requestBody) {
		Endpoint endpointDetails = OPERATIONS.get("generateToken");
		Response response = RestClient.submitRequest(endpointDetails.getRoute(), endpointDetails.getRequestType(), requestBody);
		
		return new RestResponse<>(Object.class, response);
	}
	
	public static String getPayload() throws IOException {
		if (TOKEN_PAYLOAD.isEmpty())
			TOKEN_PAYLOAD =  CommonUtils.readFile(UserService.class.getResourceAsStream("tokenPayload.json"));
		
		return TOKEN_PAYLOAD;
	}
	
	public static void main(String[] args) {
		HashMap<String, String> requestBody = new HashMap<>();
		requestBody.put("email", "var17@duke.edu");
		IRestResponse<Object> tokenResponse = TokenService.generateToken(requestBody);
		System.out.println(tokenResponse.getResponse().getBody().jsonPath().getString("token"));
	}
}
