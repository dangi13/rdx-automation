package radxup.api.utils.common;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 *  It will contain all basic common utilities.
 *  
 *  @author Jaikant
 *
 */
public class CommonUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

	/**
	 * It creates directory or folder at provided path
	 * 
	 * @param directoryPath
	 */
	public static void createDirectory(String directoryPath) {
		LOGGER.info("Creating directory : {}", directoryPath);
		File directory = new File(directoryPath);
		 if (!directory.exists()) directory.mkdirs();
	}
	
	/** It will read any InputStream to a string if possible
	 * @param inputStream
	 * @return converted String
	 */
	public static String readFile (InputStream inputStream) {
		System.out.println("CommonUtils >> [readFile]");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	    StringBuilder out = new StringBuilder();
	    String newLine = System.getProperty("line.separator");
	    String line;
	    try {
			while ((line = reader.readLine()) != null) {
			    out.append(line);
			    out.append(newLine);
			}
		} catch (IOException e) {
			System.out.println("Exception occurred : " + e.getMessage());
			e.printStackTrace();
		}
	    
		return out.toString();
	}

}
