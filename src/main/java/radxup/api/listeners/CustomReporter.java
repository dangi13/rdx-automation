package radxup.api.listeners;

import static radxup.api.utils.common.Constants.CURRENT_DAY_EXECUTION_REPORT;
import static radxup.api.utils.common.Constants.EXECUTION_REPORTS_PATH;
import static radxup.api.utils.common.Constants.TEST_RESULT_DIRECTORY_PATH;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import radxup.api.utils.common.CommonUtils;

/**
 * It provides complete reporting of the suite execution.
 *
 */
public class CustomReporter implements IReporter, ITestListener, IExecutionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomReporter.class);

	@Override
	public void onStart(ITestContext testContext) {
		ExtentReporter.onStart(testContext);

	}

	@Override
	public void onFinish(ITestContext testContext) {
		ExtentReporter.onFinish(testContext);
	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		ExtentReporter.onTestFail(testResult);
		LOGGER.error("Test Case Failed: {}", testResult.getMethod().getMethodName());
		LOGGER.error("Failure Reason : ", testResult.getThrowable());
		onTestCompletion(testResult, "FAILED");

	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		ExtentReporter.onTestSkip(testResult);
		LOGGER.info("Test Case Skipped: {}", testResult.getMethod().getMethodName());
		onTestCompletion(testResult, "SKIPPED");

	}

	@Override
	public void onTestStart(ITestResult testResult) {
		LOGGER.info("######################################## TEST CASE STARTED :  [{}] ###################################################################", testResult.getMethod().getMethodName());
		ExtentReporter.onTestStart(testResult);
		String testId = testResult.getMethod().getMethod().getAnnotation(Test.class).testName();
		String testDescription = testResult.getMethod().getDescription();
		String beautifiedDesc = String.format("<table><tr><th>TC ID</th><th>Description</th></tr><tr><td>%s</td><td>%s</td></tr></table>", testId,testDescription);
		ExtentReporter.info(beautifiedDesc);

		LOGGER.info("Execution Started For Test: {}", testResult.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult testResult) {
		ExtentReporter.onTestPass(testResult);
		LOGGER.info("Test Case Passed : {}", testResult.getMethod().getMethodName());
		onTestCompletion(testResult, "PASSED");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {

	}

	@Override
	public void onExecutionStart() {
		LOGGER.info("                            ##########################                                 ");
		LOGGER.info("############################ SUITE EXECUTION STARTED ################################");
		LOGGER.info("                            ##########################                                 ");
		ExtentReporter.onExceutionStart();

		CommonUtils.createDirectory(TEST_RESULT_DIRECTORY_PATH);
		CommonUtils.createDirectory(EXECUTION_REPORTS_PATH);
		CommonUtils.createDirectory(CURRENT_DAY_EXECUTION_REPORT);

		LOGGER.info("Test Result Directories created.");

	}

	@Override
	public void onExecutionFinish() {
		//TODO we can write database connection close code here
		
		LOGGER.info("                            ##########################                                 ");
		LOGGER.info("############################ SUITE EXECUTION FINISHED ################################");
		LOGGER.info("                            ##########################                                 ");
	}

	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String arg2) {

	}

	/**
	 * It will be used to perform the after test steps if any.
	 * 
	 * @param testResult
	 */
	private void onTestCompletion(ITestResult testResult, String testStatus) {
		ExtentReporter.setExecutionTime(testResult);
		String testCaseName = testResult.getMethod().getMethodName();
		ITestContext context = testResult.getTestContext();
		LOGGER.info("######## TEST CASE [{}] : {} ##########", testCaseName, testStatus);
		LOGGER.info("");
	}
}
