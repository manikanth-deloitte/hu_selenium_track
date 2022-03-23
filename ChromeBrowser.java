import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.ous.jtoml.impl.SymbolToken.Equals;

public class ChromeBrowser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\amanikanth\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
        Thread.sleep(2000);

        //declare handle window
        String parentWindow = driver.getWindowHandle();

        //to get title
        String actualTitle = driver.getTitle();
        if(actualTitle.contains("PHPTRAVELS")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);

        //login option
        By loginBtn = By.xpath("//a[text()='Login']");
        driver.findElement(loginBtn).click();
        Thread.sleep(2000);
        String actualTitle1 = driver.getTitle();
        if(actualTitle1.contains(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);

        //navigate back to previous page
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);

        //get current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("current url: "+currentUrl);


        //click on price option
        By priceOpt = By.xpath("//a[text()='Pricing']");
        driver.findElement(priceOpt).click();
        Thread.sleep(2000);

        //Navigate backwards in the same
        driver.navigate().back();
        Thread.sleep(2000);

        //refresh
        driver.navigate().refresh();
        Thread.sleep(2000);

        //close
        driver.close();
    }

}
