package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class HotelStepdefs {
    HotelPage hotelpage = new HotelPage();
    AdminPage adminPage = new AdminPage();
    Select select ;
    @Given("user enter on the caretta hotels webpage")
    public void userEnterOnTheCarettaHotelsWebpage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
    }

    @And("user enter username")
    public void userEnterUsername() {
        hotelpage.hotelUserName.sendKeys("manager");
    }

    @And("user enter password")
    public void userEnterPassword() {
        hotelpage.hotelPassWord.sendKeys("Manager1!");
    }

    @Then("user enter login button")
    public void userEnterLoginButton() {
        hotelpage.loginButton.click();
    }

    @Then("user click the Hotel Management icon")
    public void userClickTheHotelManagementIcon() {
        adminPage.hotelManagement.click();
    }

    @Then("user click the Hotel List icon")
    public void userClickTheHotelListIcon() {
        adminPage.hotelList.click();
    }

    @When("user select Hotel Type1 from IDGroup column")
    public void userSelectHotelType1FromIDGroupColumn() {
        Select select = new Select(adminPage.selectIdgroup);
        select.selectByIndex(2);

    }

    @And("click on Search button")
    public void clickOnSearchButton() {
        adminPage.searchButton.click();
    }

    @Then("The column should not include Hotel Type2")
    public void theColumnShouldNotIncludeHotelType() throws InterruptedException {
        Thread.sleep(1000);
        for ( WebElement eachcell : adminPage.idgroupColumn ){
            Assert.assertTrue(!eachcell.getText().contains("Hotel Type2"));
        }
    }

    @When("user select Hotel Type2 from IDGroup column")
    public void userSelectHotelType2FromIDGroupColumn() {
        Select select = new Select(adminPage.selectIdgroup);
        select.selectByIndex(1);
    }

    @Then("The column should not include Hotel Type1")
    public void theColumnShouldNotIncludeHotelType1() throws InterruptedException {
        Thread.sleep(1000);
        for ( WebElement eachcell : adminPage.idgroupColumn ){
            Assert.assertTrue(!eachcell.getText().contains("Hotel Type1"));
        }
    }

    @When("click on Clear button")
    public void clickOnClearButton() {
        adminPage.clearButton.click();
    }

    @When("The column should include Hotel Type1 and Hotel Type2")
    public void theColumnShouldIncludeHotelType1AndHotelType2() throws InterruptedException {
        Thread.sleep(1000);
        List<String> allcells = new ArrayList<>();
        for ( WebElement eachcell : adminPage.idgroupColumn ){
            allcells.add(eachcell.getText());
        }
        Assert.assertTrue(allcells.contains("Hotel Type1")
                && allcells.contains("Hotel Type2"));
    }
}
