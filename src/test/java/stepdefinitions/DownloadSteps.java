package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AdminPage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadSteps {

    AdminPage adminPage=new AdminPage();

    @Given("user clicks on download button")
    public void userClicksOnDownloadButton() {
        adminPage.downloadButton.click();
    }

    @Then("verify the excel file is donwload")
    public void verifyTheExcelFileIsDownload() throws InterruptedException {
        Thread.sleep(1000);
        String path = "/Users/orcunfazli/Downloads/Admin - List Of Hotels.xlsx";
        Boolean checkPath = Files.exists(Paths.get(path));
        Assert.assertTrue(checkPath);
    }

}
