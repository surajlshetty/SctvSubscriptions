package stepDefinitions;

import com.learning.base.Baseclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pages.HomePage;


public class HomepageSteps extends Baseclass {

    public static final Logger log = Logger.getLogger(HomepageSteps.class);
    HomePage homePage = new HomePage(driver);
    @Given("^User redirects to the sctv page$")
    public void user_redirects_to_the_site() {

     log.info("Redirection done");
    }

    @Then("^Verify the title of the sctv page$")
    public void verify_website_title() {

        log.info("Redirection was successful");
    }

    @And("^Verify URL of sctv Website$")
    public void verify_website_current_url() {
        homePage.verifyUrl();
        log.info("Url is verified");
    }

    @When("^User verify the plan heading on the page$")
    public void user_verify_the_plan_heading_on_the_page() throws Throwable {
        homePage.verifyPlanHeading();
        log.info("Plan Heading is verified");
    }

    @Then("^User validate all the subscription packages$")
    public void user_validate_all_the_subscription_packages() throws Throwable {
        homePage.verifySubscriptionPackages();
        log.info("All  the Subscription packages is getting displayed on the page");
    }



    @Given("^User click on About us$")
    public void user_click_on_About_us() throws InterruptedException {
        homePage.clickonAboutus();
        log.info("click on About done");
    }
    @And("^Verify click on testimonial$")
    public void user_click_on_testimonial() {

        homePage.clickOnTestimonals();

        log.info("Click on Testimonals done");
    }

    @And("^Verify read all client names$")
    public void user_real_all_client_names() {
        // Write code here that turns the phrase above into concrete actions

        homePage.getClientName();
        log.info("Got the client names");
    }



}
