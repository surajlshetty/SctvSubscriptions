package pages;

import com.learning.base.Baseclass;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Baseclass {


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='About']")
    private WebElement about;

    @FindBy(xpath = "//*[text()='Testimonials']")
    private WebElement testimonials;

    @FindBy(xpath = "//*[@class=\"oxygen-unslider-container unslider-horizontal\"]/ul/li/div/div[2]/div[1]")
    private List<WebElement> cleintName;

    @FindBy(xpath="//h3[@class='selectPlan-title-withHeader'][1]")
    private WebElement planHeading;

    @FindBy(xpath = "//div[@class='packages packages Light']//h1")
    private WebElement litePkg;

    @FindBy(xpath = "//div[@class='packages packages Classic']//h1")
    private WebElement classicPkg;

    @FindBy(xpath = "//div[@class='packages packages Premium']//h1")
    private WebElement premiumPkg;


     public void verifyUrl(){

         Assert.assertEquals(driver.getCurrentUrl(),"https://subscribe.stctv.com/sa-en");
     }

    public void verifyPlanHeading() throws Throwable {
        Assert.assertTrue(planHeading.isDisplayed(),"Choose Your Plan Heading is not present");
    }

    public void verifySubscriptionPackages()
    {
        Assert.assertTrue(litePkg.isDisplayed(),"Lite Package is not getting displayed on the page");
        Assert.assertTrue(classicPkg.isDisplayed(),"Classic Package is not getting displayed on the page");
        Assert.assertTrue(premiumPkg.isDisplayed(),"Premium Package is not getting displayed on the page");
    }


    public void clickonAboutus() throws InterruptedException {
         Thread.sleep(2000);

        Actions action = new Actions(driver);
        action.moveToElement(about).build().perform();

    }

     public void clickOnTestimonals(){
         Assert.assertTrue(testimonials.isDisplayed(),"Share confirmation option is not present");
         testimonials.click();
     }


    public void getClientName(){
      //  List<WebElement> listElement = driver.findElements(By.xpath(String.valueOf(cleintName)));

        for(int i =0;i<cleintName.size();i++) {
            String elementText = cleintName.get(i).getText();
            System.out.println(elementText);
        }


    }
}
