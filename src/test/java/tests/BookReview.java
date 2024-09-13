package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BookReview {

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

        WebElement androidGuideElement = driver.findElement(By.xpath("//h3[text()='Android Quick Start Guide']"));
        androidGuideElement.click();

        //scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement reviewButtonElement = driver.findElement(By.xpath("//li[@class='reviews_tab']/a[@href='#tab-reviews']"));
        reviewButtonElement.click();

        js.executeScript("window.scrollBy(0,550)", "");

        WebElement starRatingElement = driver.findElement(By.cssSelector("a.star-5"));
        starRatingElement.click();

        WebElement textReviewElement = driver.findElement(By.id("comment"));
        String textReviewElementValue = "is a must-have for anyone eager to dive into Android with ease. Its clear, step-by-step instructions simplify the setup and navigation of your device, " +
                "making complex tasks feel like a breeze. Whether you're a beginner or just need a refresher, this guide offers straightforward explanations and practical tips that get you up and running quickly." +
                " another comment to not duplicate the tested comments";
        textReviewElement.sendKeys(textReviewElementValue);

        js.executeScript("window.scrollBy(0,550)", "");

        WebElement nameReviewElement = driver.findElement(By.id("author"));
        String nameReviewElementValue = "Dascalu Marius";
        nameReviewElement.sendKeys(nameReviewElementValue);

        WebElement emailReviewElement = driver.findElement(By.id("email"));
        String emailReviewElementValue = "numeprenume@yahoo.com";
        emailReviewElement.sendKeys(emailReviewElementValue);

        WebElement checkboxRatingElement = driver.findElement(By.id("wp-comment-cookies-consent"));
        checkboxRatingElement.click();

        WebElement submitRatingElement = driver.findElement(By.id("submit"));
        submitRatingElement.click();


    }
}
