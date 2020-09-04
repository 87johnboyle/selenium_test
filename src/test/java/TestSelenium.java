import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class TestSelenium {

    public static void main (String[] args){

        System.setProperty("webdriver.chrome.driver", "chromedriver");

            WebDriver driver=new ChromeDriver();
            driver.get("http://demo.guru99.com/");
            WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
                element.sendKeys("abc@gmail.com");

                WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
                button.click();
    }
}
