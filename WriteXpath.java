import jdk.javadoc.doclet.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteXpath {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\amanikanth\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");


        By logo = By.xpath("//img[@alt='logo']");
        By home = By.xpath("//a[contains(@class,'logo')]");
        By flight = By.xpath("//a[text()='flights']");
        By tours = By.xpath("//a[text()='Tours']");
        By company = By.xpath("//a[@href='company']");
        By signUpBtn = By.className("theme-btn theme-btn-small theme-btn-small waves-effect");
        By loginBtn = By.xpath("//a[text()='Login']");
        By agentsDropDown=By.id("agents");



    }
}
