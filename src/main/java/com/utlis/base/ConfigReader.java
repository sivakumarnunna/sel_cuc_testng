package com.utlis.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;

public class ConfigReader {
    
	static String configfile = "src/test/resources/config.properties";
 
    // Method to set property in the properties file
    public static void setProperty( String key, String value) {
        try (OutputStream outputStream = new FileOutputStream(configfile)) {
            Properties properties = new Properties();
            properties.setProperty(key, value);
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get property from the properties file
    public static String getProperty(String key) {
        String value = null;
        try (InputStream inputStream = new FileInputStream(configfile)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            
            //override with enviroment variables
           Set<Object> keys = properties.keySet();
           for(Object property : keys) {
        	   
				  String env =   System.getenv(property.toString());
				  if(env!=null && !env.isEmpty()) {
					  setProperty(property.toString(),env);
				  }
           }
            value = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
