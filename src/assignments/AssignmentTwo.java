package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class AssignmentTwo {

    /*
Navigate to website "https://demo.nopcommerce.com/"
Click on register link.
Fill the all fields.
Click on register button.
 */

    public static void main(String[] args) throws InterruptedException {

        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement register = driver.findElement(By.xpath("//div[@class=\"header-links\"]//a[@class=\"ico-register\"]"));
        register.click();

        Thread.sleep(3000);
        WebElement gender = driver.findElement(By.xpath("//span[@class=\"male\"]//input[@type=\"radio\"]"));
        gender.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id=\"FirstName\"]"));
        firstName.sendKeys("Roger");

        WebElement lastName = driver.findElement(By.xpath("//input[@id=\"LastName\"]"));
        lastName.sendKeys("Moore");

        WebElement date = driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"));
        date.sendKeys("1");

        WebElement month = driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"));
        month.sendKeys("January");

        WebElement year = driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"));
        year.sendKeys("1980");

        WebElement email = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
        email.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        email.sendKeys("Roger" + randomInt + "@gmail.com");

        WebElement company = driver.findElement(By.xpath("//input[@id=\"Company\"]"));
        company.sendKeys("Roger International Ltd");

        WebElement newsLetter = driver.findElement(By.xpath("//div[@class=\"inputs\"]//input[@type=\"checkbox\"]"));
        newsLetter.sendKeys("");

        WebElement password = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
        password.sendKeys("Roger1234");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]"));
        confirmPassword.sendKeys("Roger1234");

        WebElement registerClick = driver.findElement(By.xpath("//input[@id=\"register-button\"]"));
        registerClick.click();

    }
}
