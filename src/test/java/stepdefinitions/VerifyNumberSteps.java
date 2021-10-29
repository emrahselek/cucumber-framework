package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;

public class VerifyNumberSteps {

    AdminPage adminPage=new AdminPage();
    Select select;

    @Then("verify the number of default View record is 10")
    public void verifyTheNumberOfDefaultViewRecordIs10() {
        int pageof10 = adminPage.idHotelColumn.size();
        Assert.assertEquals(10,pageof10);
    }

    @When("user selects 20")
    public void userSelects() {
        Select select = new Select(adminPage.selectUser);
        select.selectByValue("20");
    }

    @When("user clicks clicks on > symbol")
    public void userClicksClicksOnSymbol() {
        adminPage.nextButton.click();
    }

    @Then("verify user goes to the page 2")
    public void verifyUserGoesToThePage2() throws InterruptedException {
        Thread.sleep(1000);
//        Assert.assertEquals(2,adminPage.page2.getAttribute("value"));
    }

    @Then("verify the number of default View record is 20")
    public void verifyTheNumberOfDefaultViewRecordIs20() throws InterruptedException {
        Thread.sleep(1000);
        int pageof20 = adminPage.idHotelColumn.size();
        Assert.assertEquals(20,pageof20);
    }

}
