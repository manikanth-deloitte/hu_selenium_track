package tests;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SauceDemo;

import java.io.IOException;

public class LoginTest {
    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    SauceDemo login;

    @BeforeTest
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\amanikanth\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test(priority=1)
    public void validateLogin() throws IOException {
        login = new SauceDemo(driver);
        login.enterUsername();
        login.enterPassword();
        login.clickLogin();
    }
    @Test(priority = 2)
    public void validateHighest() throws InterruptedException {
        login.selectHighestPrice();

    }
    @Test(priority = 3)
    public void validateRemoveBtn() throws InterruptedException {
        login.removeAdd();
    }
}
