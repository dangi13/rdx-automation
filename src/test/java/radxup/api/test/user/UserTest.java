package radxup.api.test.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import radxup.api.listeners.ExtentReporter;
import radxup.api.service.user.UserService;
import radxup.api.service.user.model.User;
import radxup.api.utils.http.IRestResponse;

public class UserTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);

	
	@Test(testName = "RDX_02", description = "Test getUser")
	public void testGetUser() {
		IRestResponse<User> user = UserService.getUser("5");
		ExtentReporter.info("Response is as below");
		ExtentReporter.info(user.getResponse().prettyPrint());
	}

	@Test(testName = "RDX_03", description = "Test deleteUser")
	public void testDeleteUser() {
		ExtentReporter.info("Deleting user");
		IRestResponse<User> batcherCount = UserService.deleteUser("2");
		ExtentReporter.info("Delete user status is: "+ batcherCount.getStatusCode());

	}

}
