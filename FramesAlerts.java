import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FramesAlerts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\amanikanth\\Downloads\\chromedriver.exe");
        Frames();
        DragDrop();
        Alerts();
        RoundWayTrip();
        Thread.sleep(2000);

    }
    public static void Frames() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        By frame = By.xpath("//a[@href='/frames']");
        driver.findElement(frame).click();
        Thread.sleep(2000);
        By nestedFrame = By.xpath("//a[@href='/nested_frames']");
        driver.findElement(nestedFrame).click();
        Thread.sleep(2000);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftFrame = driver.findElement(By.cssSelector("body"));
        System.out.println("left title is : "+leftFrame.getText());
        driver.quit();

    }
    public static void DragDrop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement frame=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame);
        WebElement dragEle = driver.findElement(By.id("droppable"));
        WebElement dropEle = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragEle,dropEle).perform();
        Thread.sleep(5000);
        driver.quit();
    }
    public static void Alerts() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        By javascript=By.xpath("//a[@href='/javascript_alerts']");
        driver.findElement(javascript).click();
        Thread.sleep(2000);
        By jsPrompt=By.xpath("//button[@onclick='jsPrompt()']");
        driver.findElement(jsPrompt).click();
        System.out.println("Getting the text of the alert:");
        System.out.println(driver.switchTo().alert().getText());
        System.out.println("Passing the keys to the alert:");
        driver.switchTo().alert().sendKeys("Test");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String result=driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        String expected="You entered: Test";
        if(expected.equals(result)==true)
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Fail");
        }
        driver.quit();

        //additional scenario
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        driver.get("Launch: https://the-internet.herokuapp.com/drag_and_drop");
//        WebElement fromEle = driver.findElement(By.id("column-a"));
//        WebElement toEle = driver.findElement(By.id("column-b"));
//        Thread.sleep(2000);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        js.executeScript("function createEvent(typeOfEvent) {\n"
//                +"var event =document.createEvent(\"CustomEvent\");\n" +
//                "event.initCustomEvent(typeOfEvent,true, true, null);\n" +
//                "event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +
//                "this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +
//                "return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +
//                "function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +
//                "event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" +
//                "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +
//                "}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +
//                "var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +
//                "var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +
//                "var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +
//                "}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +
//                "simulateHTML5DragAndDrop(source,destination);",fromEle,toEle);
//        driver.quit();
    }
    public static void RoundWayTrip() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.goibibo.com/");
        driver.manage().window().maximize();
        By sel = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/ul/li[2]/span[2]");
        driver.findElement(sel).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[1]/div/div/p")).click();
        WebElement from =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div/input"));
        from.sendKeys("New York");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/ul/li[1]/div/div[1]/div/p[1]/span[1]")).click();
        from=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div/input"));
        from.sendKeys("Seattle");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[@class='sc-bBHHxi cTvqKV' and contains(text(),'Seattle/Tacoma Intl-WA')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]/div[6]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[3]/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='sc-dtMgUX daltrV']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[4]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div[6]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[4]/div[2]/div[3]/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[3]/a[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[3]/span")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}
