package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminPage {

    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy (linkText = "Hotel List" )
    public WebElement hotelList;

    @FindBy (xpath = "//select[@id=\"lkpGroups\"]" )
    public WebElement selectIdgroup;

    @FindBy (xpath = "//*[.='Search']")
    public WebElement searchButton;

    @FindBy (xpath = "//tbody//tr//td[7]")
    public List <WebElement> idgroupColumn;

    @FindBy (xpath = "//*[.='Clear']")
    public WebElement clearButton;

    @FindBy (xpath = "//h3[@class='page-title']")
    public WebElement date;

    @FindBy (xpath = "//tbody//tr//td[1]")
    public List <WebElement> idHotelColumn;

    @FindBy(xpath = "//select[@name=\"datatable_ajax_length\"]")
    public WebElement selectUser;

    @FindBy(xpath = "//a[@title=\"Next\"]")
    public WebElement nextButton;

    @FindBy(xpath = "(//input[@type=\"text\"])[1]")
    public WebElement page2;

    @FindBy (xpath = "//button[@id=\"btnExportTable\"]")
    public WebElement downloadButton;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div[3]/div/div/div[2]/div/div/div[2]/table/tbody/tr[1]/td[8]/a")
    public WebElement firstDetails;

//    @FindBy(xpath = "//tbody//tr[1]//td[8]")
//    public WebElement firstDetails;



}
