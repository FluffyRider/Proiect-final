package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class ShopingBooks {

    public WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));


    @Test
    public void meatodaTest() throws InterruptedException {


        //ChromeOptions options = new ChromeOptions();
       //options.addArguments("--disable-search-engine-choice-screen");
        driver = new FirefoxDriver();
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement androidBookElement = driver.findElement(By.cssSelector("a[data-product_id='169']"));
        Assert.assertTrue(androidBookElement.isDisplayed(), "Android Book is not displayed");
        androidBookElement.click();
        System.out.println("Clicked Android book element");

        Thread.sleep(3000);

        WebElement programingBookElement = driver.findElement(By.cssSelector("a[data-product_id='182']"));
        Assert.assertTrue(programingBookElement.isDisplayed(), "Programming Book is not displayed");
        programingBookElement.click();
        System.out.println("Clicked Programming book element");

        Thread.sleep(3000);

        WebElement htmlBookElement = driver.findElement(By.cssSelector("a[data-product_id='170']"));
        Assert.assertTrue(htmlBookElement.isDisplayed(), "HTML Book is not displayed");
        htmlBookElement.click();
        System.out.println("Clicked HTML book element");

        WebElement basketButtonElement = driver.findElement(By.id("wpmenucartli"));
        basketButtonElement.click();

        Thread.sleep(3000);

        WebElement removebook1Element = driver.findElement((By.cssSelector("a.remove[data-product_id='170']")));
        removebook1Element.click();
        System.out.println("Clicked remove button element");

        Thread.sleep(3000);

        WebElement removebook2Element = driver.findElement((By.cssSelector("a.remove[data-product_id='182']")));
        removebook2Element.click();
        System.out.println("Clicked remove button element");

        Thread.sleep(3000);

        WebElement removebook3Element = driver.findElement((By.cssSelector("a.remove[data-product_id='169']")));
        removebook3Element.click();
        System.out.println("Clicked remove button element");

        WebElement returnToShopButtonElement = driver.findElement(By.xpath("//a[@class='button wc-backward']"));
        returnToShopButtonElement.click();

        driver.quit();



    }
}