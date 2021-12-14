package radxup.api.utils.http;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Jaikant Dangi
 *
 */
public class RestClient {
	private static final RequestSpecification request;

	static {
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}

	/**
	 * This function is responsible for performing http requests
	 * 
	 * @param endpoint    : e.g https://www.reques/us/v1/countries
	 * @param requestType : e.g RequestType.POST, RequestType.PUT, RequestType.GET
	 * @param body        : right now only json String
	 * @return api response
	 */
	public static Response submitRequest(String endpoint, RequestType requestType, Object... body) {
		System.out.println("Submitting request for : [" + endpoint + "]");
		Response response = null;
		// String requestBody = (String)body[0]; // right now its string, but it will be
		// generic in future

		switch (requestType) {
		case DELETE:
			response = request.delete(endpoint);
			break;
		case GET:
			response = request.get(endpoint);
			break;
		case POST:
			request.body((Object) body[0]);
			response = request.post(endpoint);
			break;
		case PUT:
			request.body((Object) body[0]);
			response = request.put(endpoint);
			break;
		case PATCH:
			request.body((Object) body[0]);
			response = request.put(endpoint);
			break;
		default:
			break;

		}

		return response;
	}

}
