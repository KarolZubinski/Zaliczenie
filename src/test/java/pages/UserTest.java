package pages;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions (features = "src/Cucumber/Features/", plugin = {"pretty","html:out"})

public class UserTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        //otwieram strone na ktorej uzytkownik jest zalogowany
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //czekaj zanim rzucisz wyjatkiem (bo nie mozesz znalezc elementu, bo element zniknal)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void Test() {
        //dodaje kontruktora AddressPage
        LoginPage loginPage = new LoginPage(driver);
        //loginAs do zalogowania
        loginPage.loginAs( "kasperkucharski@teleworm.us", "123456789");
        Assert.assertEquals("Kasper Kucharski", loginPage.getLoggedUsername());

        //czekaj zanim rzucisz wyjatkiem (bo nie mozesz znalezc elementu, bo element zniknal)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickToAddresses();


        AddressPage AddressPage = new AddressPage(driver);

        //czekaj zanim znowu odpalisz
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //sprawdzenie poprawnosci adresu
        //AddressCheckPage addressCheckPage = new AddressCheckPage(driver);
        //Assert.assertEquals(expectedText, actualText);
    }


    @After
    public void tearDown () {
        //zakoncz
        //driver.quit();

    }
}

