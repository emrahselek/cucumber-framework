package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelPage {

    public HotelPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "UserName")
    public WebElement hotelUserName;

    @FindBy (name = "Password")
    public WebElement hotelPassWord;

    @FindBy (id = "btnSubmit")
    public WebElement loginButton;


}