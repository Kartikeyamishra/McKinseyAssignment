package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class FileRead {
	
	Properties properties;

	public FileRead(String FilePath) {

		try {
			FileInputStream Locator = new FileInputStream(FilePath);
			properties = new Properties();
			properties.load(Locator);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getData(String ElementName) throws Exception {
		// Read value using the logical name as Key
		String data = properties.getProperty(ElementName);
		return data;
	}
	
	public static void main(String[] args) throws Exception {
		//String filePath="C:/Users/kmishra/workspace/Demo/src/TestData.properties";
		//FileRead file=new FileRead(filePath);
		//System.out.println(file.getData("username"));
	}
}