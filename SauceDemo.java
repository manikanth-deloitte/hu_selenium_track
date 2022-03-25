package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class SauceDemo extends ReadingExcel{
    WebDriver driver;
    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By login_button = By.xpath("//input[@id='login-button']");
    By filterHigh = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select//option[@value='hilo']");

    ReadingExcel excel = new ReadingExcel();
    public SauceDemo(WebDriver driver) throws IOException {
        this.driver = driver;
        excel.readCells();
    }

    public void enterUsername(){
        String name = excel.getName();
        WebElement nameEle = driver.findElement(username);
        nameEle.sendKeys(name);
    }

    public void enterPassword(){
        String pass = excel.getPass();
        WebElement passELe = driver.findElement(password);
        passELe.sendKeys(pass);
    }
    public void clickLogin() {
        WebElement loginEle = driver.findElement(login_button);
        loginEle.click();
    }
    public void selectHighestPrice() throws InterruptedException {
        WebElement filetrDrop = driver.findElement(filterHigh);
        filetrDrop.click();
        WebElement highPrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"));
        String dollarPrice = highPrice.getText();
        String subPrice = dollarPrice.substring(1);
        double price = Double.parseDouble(subPrice);
        double ExtentPrice = 100.00;
        if( price < ExtentPrice){
            System.out.println(dollarPrice+"is less than $100");
            WebElement highPriceButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
            highPriceButton.click();
            Thread.sleep(2000);
        }

    }
    public void removeAdd() throws InterruptedException{
        WebElement removeBtn = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-fleece-jacket\"]"));
        String sremove = removeBtn.getText();
        if(sremove.contains("REMOVE")){
            System.out.println("remove option is enabled");
            removeBtn.click();
            Thread.sleep(2000);
            WebElement highPriceButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
            String sadd = highPriceButton.getText();
            if(sadd.contains("ADD TO CART")){
                highPriceButton.click();
                Thread.sleep(2000);

            }

        }
    }

}
