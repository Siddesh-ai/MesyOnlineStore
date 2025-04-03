package ecommerce.mecys.genericutility.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("D:\\Selenium_Workspace\\fashion\\src\\main\\resources\\commandata.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);   //key means key value in property file
		
		return data;
	}

}
