package reusableComponents;

/**
 * @author: Prakash Narkhede
 * @Youtube: https://www.youtube.com/automationtalks
 * @LinkedIn: https://www.linkedin.com/in/panarkhede89/
 */

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {

	
	static Properties prop = new Properties();
	
	public static String getPropertyValueByKey(String key) {
		//1. load data from properties file
		String propFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//2. read data
		String value = prop.get(key).toString();
		
		if(StringUtils.isEmpty(value)) {
			try {		
				throw new Exception("Không tìm thấy dữ liệu có key là : "+key + " trong tệp dữ liệu.");
			}catch(Exception e) {}
		}
		
		return value;
	}

}
