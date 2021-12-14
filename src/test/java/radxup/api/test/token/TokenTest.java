package radxup.api.test.token;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import radxup.api.listeners.ExtentReporter;
import radxup.api.service.token.TokenService;
import radxup.api.service.user.UserService;
import radxup.api.service.user.model.User;
import radxup.api.utils.http.IRestResponse;

public class TokenTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(TokenTest.class);

	
	@Test(testName = "RDX_01", description = "Test generate token")
	public void testGenerateToken() {
		HashMap<String, String> requestBody = new HashMap<>();
		requestBody.put("email", "var17@duke.edu");
		IRestResponse<Object> tokenResponse = TokenService.generateToken(requestBody);
		Assert.assertEquals(tokenResponse.getStatusCode(), 200);
		ExtentReporter.info("Generated token is as below");
		ExtentReporter.info(tokenResponse.getResponse().getBody().jsonPath().getString("token"));
	}

}
