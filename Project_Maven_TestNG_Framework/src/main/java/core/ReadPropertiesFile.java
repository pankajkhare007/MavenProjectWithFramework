package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	
	 static Properties properties;
		public static void loadPropertiesFile() {
	         properties = new Properties();
	        FileInputStream input = null;

	        try {
	            // Provide the path to your properties file
	            input = new FileInputStream("src\\main\\resources\\Files\\configFile.properties");
	            properties.load(input);
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (input != null) {
	                try {
	                    input.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
		
		public static String getPropertiesValue(String propKey) {
		    // Access properties using keys
	        return properties.getProperty(propKey);
	       

	      
	       
			
		}



}
