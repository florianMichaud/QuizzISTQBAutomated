package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	private static String urlPropertiesFile = "src\\main\\resources\\config\\config.properties";
	private static final String EMPTY_STRING = "";
	
	
	public static String getProperties(String propertie) throws IOException {
		InputStream inputStream = new FileInputStream("src\\main\\resources\\config\\config.properties");
		
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties.getProperty(propertie,EMPTY_STRING);
	}

}
