package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.EditHotelPage;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HotelStepdefs {
    HotelPage hotelpage = new HotelPage();
    AdminPage adminPage = new AdminPage();
    Select select ;
    EditHotelPage editHotel = new EditHotelPage();
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
    public void userSelectHotelTypeFromIDGroupColumn() {
        Select select = new Select(adminPage.selectIdgroup);
        select.selectByIndex(2);

    }

    @And("click on Search button")
    public void clickOnSearchButton() {
        adminPage.searchButton.click();
    }

    @When("The column should not include Hotel Type2")
    public void theColumnShouldNotIncludeHotelType2() throws InterruptedException {
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

    @And("click on Clear button")
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

    @And("click on Details of the first hotel")
    public void clickOnDetailsOfTheFirstHotel() throws InterruptedException {
        Thread.sleep(1000);
        adminPage.firstDetails.click();
    }

    @And("verify Edit hotel page is displayed")
    public void verifyEditHotelPageIsDisplayed() throws InterruptedException {
        String currentWindow=Driver.getDriver().getWindowHandle();
        String nextWindow="";
        Set<String> allWindowHandles=Driver.getDriver().getWindowHandles();
        for (String eachHandle:allWindowHandles) {
            if(eachHandle!=currentWindow){
                nextWindow=eachHandle;
            }
        }
        Driver.getDriver().switchTo().window(nextWindow);
        Thread.sleep(1000);
        Assert.assertEquals("Admin - Edit Hotel" ,Driver.getDriver().getTitle());
    }

    @Given("user is on th Edit hotel Page")
    public void userIsOnThEditHotelPage() throws InterruptedException {
        Thread.sleep(1000);
        adminPage.firstDetails.click();
        String currentWindow=Driver.getDriver().getWindowHandle();
        String nextWindow="";
        Set<String> allWindowHandles=Driver.getDriver().getWindowHandles();
        for (String eachHandle:allWindowHandles) {
            if(eachHandle!=currentWindow){
                nextWindow=eachHandle;
            }
        }

        Driver.getDriver().switchTo().window(nextWindow);

    }

    @And("changes the hotel code")
    public void changesTheHotelCode() throws InterruptedException {
        Thread.sleep(1000);
        editHotel.hotelCode.clear();
        editHotel.hotelCode.sendKeys("445533" + Keys.ENTER);
    }

    @And("verify the success message")
    public void verifyTheSuccessMessage() {
    }

    @When("user clicks on download button")
    public void userClicksOnDownloadButton() {
        adminPage.downloadButton.click();
    }

    @Then("verify the excel file is downloaded")
    public void verifyTheExcelFileIsDownloaded() throws InterruptedException {
        Thread.sleep(1000);
        String path = System.getProperty("user.home") + "/Downloads/Admin - List Of Hotels.xlsx";
        Boolean checkPath = Files.exists(Paths.get(path));
        Assert.assertTrue(checkPath);
    }
    @Then("verify the number of default View record is 10")
    public void verifyTheNumberOfDefaultViewRecordIs10() {
        int pageOf10 = adminPage.idHotelColumn.size();
        Assert.assertEquals(10,pageOf10);

    }

    @When("user selects 20")
    public void userSelects20() {
        Select select = new Select(adminPage.selectUser);
        select.selectByValue("20");
    }

    @When("user clicks clicks on > symbol")
    public void userClicksClicksOnSymbol() {
        adminPage.nextButton.click();
    }

    @Then("verify user goes to the page 2")
    public void verifyUserGoesToThePage() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("2",adminPage.page2.getAttribute("value"));
    }

    @Then("verify the number of default View record is 20")
    public void verifyTheNumberOfDefaultViewRecordIs20() throws InterruptedException {
        Thread.sleep(1000);
        int pageOf20 = adminPage.idHotelColumn.size();
        Assert.assertEquals(20,pageOf20);
    }

    @And("Verify the date reflext current date as DD Month YYYY")
    public void verifyTheDateReflextCurrentDateAsDDMonthYYYY() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate currentDate = LocalDate.now();
        String expectedDate = dateTimeFormatter.format(currentDate);
        String actualDate = adminPage.date.getText();
        Assert.assertEquals(expectedDate,actualDate);
    }


}