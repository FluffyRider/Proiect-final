package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ShopingBooks {

    public WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));


    @Test
    public void meatodaTest() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.get("http://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();


        WebElement skipSignInButtonElement = driver.findElement(By.id("btn2"));
        skipSignInButtonElement.click();

        WebElement consentButon = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButon.click();

        WebElement practiceButtonElement = driver.findElement(By.linkText("Practice Site"));
        practiceButtonElement.click();

        WebElement shopButtonElement = driver.findElement(By.linkText("Shop"));
        shopButtonElement.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,650)", "");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement androidBookElement = driver.findElement(By.cssSelector("a[data-product_id='169']"));
        androidBookElement.click();


        WebElement programingBookElement = driver.findElement(By.cssSelector("a[data-product_id='182']"));
        programingBookElement.click();

        WebElement htmlBookElement = driver.findElement(By.cssSelector("a[data-product_id='170']"));
        htmlBookElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement shoppingCartElement = driver.findElement(By.id("wpmenucartli"));
        shoppingCartElement.click();



    }
}