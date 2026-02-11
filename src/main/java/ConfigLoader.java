

import java.util.Properties;
import java.io.InputStream;

public class ConfigLoader {

	private static Properties prop = new Properties();

    static {

        try {

            InputStream input =
                    ConfigLoader.class
                            .getClassLoader()
                            .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }

            prop.load(input);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
    	String value = prop.getProperty(key);

    	if(value == null){
    	    throw new RuntimeException("Key not found in config: " + key);
    	}

    	return value;

    }
}
