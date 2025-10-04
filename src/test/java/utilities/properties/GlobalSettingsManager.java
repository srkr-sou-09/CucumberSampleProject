package utilities.properties;

import enums.GlobalPropertiesEnums;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class GlobalSettingsManager {
 private static final String GLOBAL_SETTINGS_PROPERTIES_PATH = "./src/test/resources/globalSettings.properties";
 private static Properties properties;

 static {
     properties = new Properties();
     try {
         properties.load(Files.newInputStream(Paths.get(GLOBAL_SETTINGS_PROPERTIES_PATH)));
     } catch (IOException e) {
         throw new RuntimeException("No File is found in "+GLOBAL_SETTINGS_PROPERTIES_PATH);
     }
 }

 public String getGlobalSettingsPropertiesValue(GlobalPropertiesEnums key) {
     return (String) properties.getProperty(key.getValue(),"").trim();
 }
}
