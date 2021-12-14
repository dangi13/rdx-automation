package radxup.api.utils.common;

import java.io.File;


/**  It contains all constants that are common throughout the framework and can be reused.
 * 
 * @author Jaikant
 *
 */
public class Constants {
	
	public static final String USER_DIR = "user.dir";
	// property files path
	public static final String CONFIG_FOLDER_PATH = System.getProperty(USER_DIR) + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config";

	// test results and report paths
	public static final String TEST_RESULT_DIRECTORY_PATH = System.getProperty(USER_DIR) + File.separatorChar + "test-result";
	public static final String EXECUTION_REPORTS_PATH = TEST_RESULT_DIRECTORY_PATH + File.separatorChar +  "execution-reports";
	public static final String CURRENT_DAY_EXECUTION_REPORT = EXECUTION_REPORTS_PATH  + File.separator + DateUtils.getCurrentDate();
	public static final String EXTENT_REPORT_HTML = CURRENT_DAY_EXECUTION_REPORT + File.separator + "execution-report " + DateUtils.getCurrentDateWithTime().replaceAll(":", "") + ".html";
	
	public static final String BASE_URL = Config.getProperty("base_url");

	
}
