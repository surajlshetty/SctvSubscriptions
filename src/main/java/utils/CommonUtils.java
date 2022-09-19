package utils;

import com.learning.base.Baseclass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils extends Baseclass {


    private WebDriver driver;
    public static final org.apache.log4j.Logger log = Logger.getLogger(CommonUtils.class);

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        log.debug("Button Helper : " + this.driver.hashCode());
    }

    public void click(By locator) {
        click((By) driver.findElement(locator));
        log.info(locator);
    }

    public void click(WebElement element){
        element.click();
        log.info(element);
    }



}
