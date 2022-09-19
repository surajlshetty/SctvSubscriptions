package com.learning.base;

import configuration.ReadConfigFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static configuration.ReadConfigFile.prop;


public class Baseclass {

    public   static  WebDriver driver;



    public static WebDriver createWebDriver() {
        String browserName = "chrome";

        switch(browserName) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/resources/lib/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/lib/chromedriver.exe");
                driver = new ChromeDriver();break;

        }
        return driver;
    }

    public static void launchbrowser() {

        driver = Baseclass.createWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String baseurl = "https://subscribe.stctv.com/sa-en";
        driver.get(baseurl);
    }

    public static void closeBrowser() {
        driver.quit();
    }
}