package utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonPropertiesFileUtils {
	private static String urlPropertiesFile = "src\\main\\resources\\config\\config.json";
	private static JSONParser parser = new JSONParser();
	private static FileReader reader;
	private static FileWriter writer;
	
	public static String getProperty(String key) throws IOException, ParseException {
				reader = new FileReader(urlPropertiesFile);
				JSONObject property = (JSONObject) parser.parse(reader);
				reader.close();
				return property.get(key).toString();
	}
	
	public static void writeJSONFile(JSONObject object) throws IOException, ParseException {
		writer = new FileWriter(urlPropertiesFile);
		writer.write(object.toJSONString());
		writer.flush();
		writer.close();
	}
	
	public static void addProperty(String key, String value) throws IOException, ParseException {
		System.out.println("key : "+key+"\tvalue : "+value);
		JSONObject object = JsonPropertiesFileUtils.getJSONProperties();
		object.put(key, value);
		JsonPropertiesFileUtils.writeJSONFile(object);
	}
	
	private static JSONObject getJSONProperties() throws IOException, ParseException {
		reader = new FileReader(urlPropertiesFile);
		JSONObject properties = (JSONObject) parser.parse(reader);
		reader.close();
		return properties;
	}
}
