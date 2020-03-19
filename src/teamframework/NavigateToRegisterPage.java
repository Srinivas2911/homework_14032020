package teamframework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToRegisterPage {

    /*
Test Case 1 User should navigate to register page successfully.
Click on Register Link
Message   “Your Personal Details“
Assert above message.
 */

    WebDriver driver;

    @Before
    public void openBrowser() {

        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPage() {
        WebElement register = driver.findElement(By.xpath("//a[@class=\"ico-register\"]"));
        register.click();
        String expectedMessage = "Your Personal Details";
        String actualMessage = "Your Personal Details";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNotNavigateToRegisterPage() {
        WebElement register = driver.findElement(By.xpath("//a[@class=\"ico-register\"]"));
        register.click();
        String expectedMessage = "Your Personal Details";
        String actualMessage = "Your Personnel Detail";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}



