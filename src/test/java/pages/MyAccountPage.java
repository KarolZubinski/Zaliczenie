package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPage {

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"address-link\"]/span/i")
   public WebElement addresses;

    public void clickToAddresses() {
        addresses.click();
    }

}