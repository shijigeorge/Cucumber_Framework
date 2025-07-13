package utilities;
// Importing required classes for file handling and properties
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
// Importing the constant which holds the path to the config properties file
import static constants.constant.CONFIG_PROPERTIES_DIRECTORY;

public class utilityFetchProperty
{
    /*This method reads a properties file and returns the value for the given key.
     * @param Key - The key to look up in the properties file (e.g., "browser", "url").
     * @return String - The value corresponding to the provided key.
     * @throws IOException - If the file is not found or can't be read.
     */
public static String fetchPropertyValue(String Key) throws IOException {
    // Create an input stream for the properties file using the path defined in a constant
    FileInputStream file =new FileInputStream(CONFIG_PROPERTIES_DIRECTORY);
    // Create a Properties object to load the file contents
    Properties property = new Properties();
    // Load the properties from the input stream
    property.load(file);
    // Return the value for the provided key as a String
    return property.get(Key).toString();

}
}
