package teamframework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class UserShouldRegisterSucessfully {

    /*Test Case 2 User should register successfully.
        Click on Register
        Enter correct details in field
        Click on register  button.
        Expected Result:
        Success Message  “Your registration completed”
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
    public void userShouldNavigateToRegisterPage() throws InterruptedException {
        WebElement register = driver.findElement(By.xpath("//a[@class=\"ico-register\"]"));
        register.click();

        Thread.sleep(3000);
        WebElement gender = driver.findElement(By.xpath("//span[@class=\"male\"]//input[@type='radio']"));
        gender.click();

        WebElement firstname = driver.findElement(By.xpath("//div [@class=\"inputs\"]//input[@name=\"FirstName\"]"));
        firstname.sendKeys("Roger");

        WebElement lastname = driver.findElement(By.xpath("//div [@class=\"inputs\"]//input[@name=\"LastName\"]"));
        lastname.sendKeys("Moore");

        WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        day.sendKeys("1");

        WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.sendKeys("January");

        WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("1980");

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        email.sendKeys("Roger" + randomInt + "@gmail.com");

        WebElement companyname = driver.findElement(By.xpath("//input[@id='Company']"));
        companyname.sendKeys("Roger International Ltd.");

        WebElement newsletter = driver.findElement(By.xpath("//div[@class=\"inputs\"]//input[@type=\"checkbox\"]"));
        newsletter.sendKeys("");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Roger1980");

        WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmpassword.sendKeys("Roger1980");

        WebElement registerbutton = driver.findElement(By.xpath("//input[@id='register-button']"));
        registerbutton.click();

        WebElement cnfmMsg = driver.findElement(By.xpath("//div[@class=\"result\"]"));
        cnfmMsg.getText();

        String expectedMessage = "Your registration completed";
        String actualMessage = cnfmMsg.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void userShouldNotRegister() throws InterruptedException {
        WebElement register = driver.findElement(By.xpath("//a[@class=\"ico-register\"]"));
        register.click();

        Thread.sleep(3000);
        WebElement gender = driver.findElement(By.xpath("//span[@class=\"male\"]//input[@type='radio']"));
        gender.click();

        WebElement firstName = driver.findElement(By.xpath("//div [@class=\"inputs\"]//input[@name=\"FirstName\"]"));
        firstName.sendKeys("Roger");

        WebElement lastName = driver.findElement(By.xpath("//div [@class=\"inputs\"]//input[@name=\"LastName\"]"));
        lastName.sendKeys("Moore");

        WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        day.sendKeys("1");

        WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.sendKeys("January");

        WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("1980");

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        email.sendKeys("Roger" + randomInt + "@gmail.com");


        WebElement companyName = driver.findElement(By.xpath("//input[@id='Company']"));
        companyName.sendKeys("Roger International Ltd.");

        WebElement newsletter = driver.findElement(By.xpath("//div[@class=\"inputs\"]//input[@type=\"checkbox\"]"));
        newsletter.sendKeys("");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Roger1980");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("Roger1999");

        WebElement registerButton = driver.findElement(By.xpath("//input[@id='register-button']"));
        registerButton.click();

        WebElement cnfmMsg = driver.findElement(By.xpath("//div[@class=\"result\"]"));
        cnfmMsg.getText();

        String expectedMessage = "Your registration completed";
        String actualMessage = cnfmMsg.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

