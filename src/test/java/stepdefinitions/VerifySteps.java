package stepdefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.AdminPage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VerifySteps {
    AdminPage adminPage = new AdminPage();

    @And("Verify the date reflext current date as DD Month YYYY")
    public void verifyTheDateReflextCurrentDateAsDDMonthYYYY() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate currentDate = LocalDate.now();
        String expectedDate = dateTimeFormatter.format(currentDate);
        String actualDate = adminPage.date.getText();
        Assert.assertEquals(expectedDate,actualDate);
    }

}