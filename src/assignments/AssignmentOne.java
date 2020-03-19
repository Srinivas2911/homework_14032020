package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentOne {
    /*Assignment 1-
        Navigate to google https://www.google.com/
        In Google search type "nopCommerce demo store" and click search
        click on the link "nopCommerce demo store"
        print the links count and text from the page.*/

    public static void main(String[] args) {

        String baseUrl = "https://www.google.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement search = driver.findElement(By.xpath("//input[@title='Search']"));
        search.sendKeys("nopCommerce demo store");
        search.submit();

        WebElement demoClick = driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']"));
        demoClick.click();

        // for finding the count and list of link items on the webpage
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links count :"+ (links.size()));
        for (int i = 1; i <= links.size(); i = i + 1) {
            System.out.println(links.get(i).getText());
        }
    }
}
