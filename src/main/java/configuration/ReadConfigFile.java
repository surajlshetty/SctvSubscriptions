package configuration;

import com.learning.base.Baseclass;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ReadConfigFile  {


    public static Properties prop=null;
    // --------------Creating ConfigProperties File-----------------
    public ReadConfigFile(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/resources/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
