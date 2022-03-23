import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\amanikanth\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");


       By checkin = By.xpath("//input[@id='checkin']");
       By checkout = By.xpath("//input[@id='checkout']");
       By minusAdults = By.xpath("//i[contains(@class,'minus')]//adult::div[contains(@class,'qtyDec')]");
        By plusAdults = By.xpath("//i[contains(@class,'plus')]//adult::div[contains(@class,'qtyDec')]");
        By minusChilds = By.xpath("//i[contains(@class,'minus')]//parent::div[contains(@class,'qtyDec')]");
        By plusChilds = By.xpath("//i[contains(@class,'plus')]//parent::div[contains(@class,'qtyDec')]");



    }
}
