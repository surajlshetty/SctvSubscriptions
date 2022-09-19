package pages;

import com.learning.base.Baseclass;

import io.cucumber.java.en.When;
import stepDefinitions.HomepageSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.apache.log4j.Logger;

import java.util.List;

public class HomePage extends Baseclass {

	public static final Logger log = Logger.getLogger(HomepageSteps.class);
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
    
    @FindBy(xpath = "//div[@class='packages packages Light']/div//span[@class='amount']")
    private WebElement liteAmt;
    
    @FindBy(xpath = "//div[@class='packages packages Light']/div//span[@class='currency']")
    private WebElement liteCurrency;

    @FindBy(xpath = "//div[@class='packages packages Classic']/div//span[@class='amount']")
    private WebElement classicAmt;
    
    @FindBy(xpath = "//div[@class='packages packages Classic']/div//span[@class='currency']")
    private WebElement classicCurrency;
    
    @FindBy(xpath = "//div[@class='packages packages Premium']/div//span[@class='amount']")
    private WebElement premiumAmt;
    
    @FindBy(xpath = "//div[@class='packages packages Premium']/div//span[@class='currency']")
    private WebElement premiumCurrency;
    
    public void verifyUrl(){
         Assert.assertEquals(driver.getCurrentUrl(),"https://subscribe.stctv.com/sa-en");
     }

    public void verifyPlanHeading() throws Throwable {
        Assert.assertTrue(planHeading.isDisplayed(),"Choose Your Plan Heading is not present");
    }

    public void verifySubscriptionPackages()
    {
        Assert.assertTrue(litePkg.isDisplayed(),"Lite Package is not getting displayed on the page");
        String litepack = litePkg.getText();
        String liteamt = liteAmt.getText();
	  	String litecurrency = liteCurrency.getText();	  	
        //String amt = driver.findElement(By.xpath("//div[@class='packages packages Light']/div//span[@class='amount']")).getText();
	  	//String currency = driver.findElement(By.xpath("//div[@class='packages packages Light']/div//span[@class='currency']")).getText();
	  	Assert.assertEquals("15", liteamt);
	  	Assert.assertEquals("SAR", litecurrency);
	  	log.info("1st Package is "+litepack+" with amount "+liteamt+" and currency is "+litecurrency+".");
	  	
        Assert.assertTrue(classicPkg.isDisplayed(),"Classic Package is not getting displayed on the page");
        String classicpack = classicPkg.getText();
        String classicamt = classicAmt.getText();
	  	String classiccurrency = classicCurrency.getText();	  	
	  	//String amt2 = driver.findElement(By.xpath("//div[@class='packages packages Classic']/div//span[@class='amount']")).getText();
		//String currency2 = driver.findElement(By.xpath("//div[@class='packages packages Classic']/div//span[@class='currency']")).getText();
		Assert.assertEquals("25", classicamt);
	  	Assert.assertEquals("SAR", classiccurrency);
	  	log.info("2nd Package is "+classicpack+" with amount "+classicamt+" and currency is "+classiccurrency+".");
	  	
        Assert.assertTrue(premiumPkg.isDisplayed(),"Premium Package is not getting displayed on the page");
        String premiumpkg = premiumPkg.getText();
        String premiumamt = premiumAmt.getText();
	  	String premiumcurrency = premiumCurrency.getText();	  	
	  	//String amt3 = driver.findElement(By.xpath("//div[@class='packages packages Premium']/div//span[@class='amount']")).getText();
		//String currency3 = driver.findElement(By.xpath("//div[@class='packages packages Premium']/div//span[@class='currency']")).getText();
		Assert.assertEquals("60", premiumamt);
	  	Assert.assertEquals("SAR", premiumcurrency);
	  	log.info("3rd Package is "+premiumpkg+" with amount "+premiumamt+" and currency is "+premiumcurrency+".");
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
