package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SignInTest {


    public WebDriver driver;

    @Test
    public void meatodaTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.get("http://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();

        WebElement signInButtonElement = driver.findElement(By.id("btn1"));
        signInButtonElement.click();

        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        emailField.sendKeys("numeprenume@yahoo.com");

        WebElement emailPasswordInButtonElement = driver.findElement(By.cssSelector("input[placeholder='Password'"));
        String emailPasswordInButtonElementvalue = "QAZxsw1234!";
        emailPasswordInButtonElement.sendKeys(emailPasswordInButtonElementvalue);

        WebElement enterButtonElement = driver.findElement(By.id("enterbtn"));
        enterButtonElement.click();

        driver.navigate().back();

        driver.quit();











    }
}