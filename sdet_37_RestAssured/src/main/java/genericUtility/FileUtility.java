package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Hp Lap
 *
 */
public class FileUtility {
/**
 * To get the common data from the property file
 * @param key
 * @return
 * @throws IOException
 */ 
	public String getPropertyKeyValue(String key) throws IOException {
		
		FileInputStream fileInputStream = new FileInputStream(Iconstants.filePath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String value=properties.getProperty(key);
		return value;
		
	}
}
