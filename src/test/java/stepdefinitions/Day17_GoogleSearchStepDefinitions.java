package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Day17_GoogleSearchStepDefinitions {
    /*This step definition class will have JAVA CODE
     * */

    GooglePage googlePage = new GooglePage();

    @Given("user is on the google page")
    public void user_in_on_the_google_page() {
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));

    }
    @Given("user search for iPhone")
    public void user_search_for_i_phone() {
        googlePage.googleSearchBox.sendKeys("iphone"+ Keys.ENTER);

    }
    @Then("verify the result has iPhone")
    public void verify_the_result_has_i_phone() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("iphone"));

    }
    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();

    }

    @Then("see my name on the console")
    public void see_my_name_on_the_console() {

    }

    @Given("user search for tea pot")
    public void user_search_for_tea_pot() {
        googlePage.googleSearchBox.sendKeys("tea pot"+Keys.ENTER);

    }
    @Then("verify the result has tea pot")
    public void verify_the_result_has_tea_pot() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("tesa pot"));

    }

    @Given("user search for flower")
    public void user_search_for_flower() {
        googlePage.googleSearchBox.sendKeys("flower"+Keys.ENTER);
    }
    @Then("verify the result has flower")
    public void verify_the_result_has_flower() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("flower"));

    }
    @Given("user search for tesla")
    public void user_search_for_tesla() {
     googlePage.googleSearchBox.sendKeys("tesla"+Keys.ENTER);
    }
    @Then("verify the result has tesla")
    public void verify_the_result_has_tesla() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("tesla"));

    }



}
