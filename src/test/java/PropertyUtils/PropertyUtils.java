package PropertyUtils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertyUtils {

    private Properties properties;

    public PropertyUtils(String fileName){
        loadFile(fileName);
    }

    //facem o metoda care sa incarce un fisier
    public void loadFile(String fileName) {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/" + fileName + ".properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
        }

    }

    //facem o metoda care returneaza toate datele dintr-un fisier
    public HashMap<String, String> getAllData() {
        HashMap<String, String> testData = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            testData.put(key, properties.getProperty(key));
        }
        return testData;
    }

}
