package teamframework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangehrmLiveTest {

/*    Automation Task
    WebSite: https://opensource-demo.orangehrmlive.com/index.php/auth/login
    Test case 1.
   * do login using a username and password shows on website and verifies the text
	"WelcomeAdmin" on the right hand side corner
    Test case 2.
    * User should log out successfully.
	1. Click on "WelcomeAdmin" link and click on Logout.
	2. Verify the text "LOGIN Panel" on the main page.

 */

        WebDriver driver;

    @Before
    public void openBrowser() {

        String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void OrangehrmLogin() {

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@id=\"txtPassword\"]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id=\"btnLogin\"]"));
        loginButton.click();

        WebElement welcome = driver.findElement(By.xpath("//a[@id=\"welcome\"]"));
        String expectedMessage = "Welcome Admin";
        String actualMessage = welcome.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void OrangehrmLogout() throws InterruptedException {

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@id=\"txtPassword\"]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id=\"btnLogin\"]"));
        loginButton.click();

        WebElement welcome = driver.findElement(By.xpath("//a[@id='welcome']"));
        welcome.click();

        Thread.sleep(3000);
        WebElement logOut = driver.findElement(By.xpath("//a[@href=\"/index.php/auth/logout\"]"));
        logOut.click();

        WebElement loginPanel = driver.findElement(By.xpath("//div[@id='logInPanelHeading']"));
        String expectedMessage = "LOGIN Panel";
        String actualMessage = loginPanel.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void closeBrowser() {
        driver.quit();

    }
}
