import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestSelenium {

    public static void main (String[] args) throws InterruptedException, IOException {

        //Start Chrome Driver
        System.setProperty("webdriver.chrome.driver", "chromedriver");
            WebDriver driver=new ChromeDriver();

            //Initialise variables with login details
            String user="";
            String pass="";

            //Open twitter, maximise window, hold until login window loads into DOM.
            driver.get("http://twitter.com/login");
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("session[username_or_email]")));

            //Input login details and submit.
            WebElement userTextField = driver.findElement(By.name("session[username_or_email]"));
                userTextField.sendKeys(user);
            WebElement passTextField = driver.findElement(By.name("session[password]"));
                passTextField.sendKeys(pass);
            driver.findElement(By.xpath("//div[@data-testid='LoginForm_Login_Button']")).click();
                WebDriverWait wait2 = new WebDriverWait(driver, 10);
                    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [@data-testid='SideNav_NewTweet_Button']")));


            //Find Tweet box, click, send tweet, click send.
            WebElement tweetBox=driver.findElement(By.xpath("//div [@name='tweet' and @class='tweet-box rich-editor is-showPlaceholder’]"));
                tweetBox.click();
                    tweetBox.sendKeys("Hello! I am sending this tweet through Selenium, a web testing automation framework. Fun!");
                driver.findElement(By.xpath(".//div[@test-id='tweetButton']")).click();
                    Thread.sleep(2000);

            //Take screenshot, save to desktop
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(src, new File(""));

    }
}
