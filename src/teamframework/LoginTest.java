package teamframework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

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
    public void verifyUserShouldLoginSucessfully() throws InterruptedException {

        WebElement loginLink = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginLink.click();

        Thread.sleep(3000);

        WebElement emailField = driver.findElement(By.xpath("//input[@class='email']"));
        emailField.click();
        emailField.sendKeys("Roger123@gmail.com");

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Roger1980");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Log in\"]"));
        loginButton.click();
    }
        @Test
        public void verifyUserShouldNotLoginSucessfully() throws InterruptedException {

            WebElement loginLink = driver.findElement(By.xpath("//a[@class='ico-login']"));
            loginLink.click();

            Thread.sleep(3000);

            WebElement emailField = driver.findElement(By.xpath("//input[@class='email']"));
            emailField.click();
            emailField.sendKeys("Roger123@gmail.com");

            WebElement passwordField = driver.findElement(By.id("Password"));
            passwordField.sendKeys("abcd1980");
            WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Log in\"]"));
            loginButton.click();


            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
            String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect";
            String actualErrorMessage = errorMessage.getText();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        }
            @After
            public void closeBrowser() throws InterruptedException {
                Thread.sleep(3000);
                driver.quit();
            }


}
