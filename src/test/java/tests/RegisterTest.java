package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class RegisterTest {

    public WebDriver driver;

    @Test
    public void meatodaTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.get("http://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();

        WebElement registerButton = driver.findElement(By.id("enterimg"));
        registerButton.click();
        try {
            Thread.sleep(4000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement consentButon = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButon.click();

        WebElement firstnameButtonElement = driver.findElement(By.cssSelector("input[ng-model='FirstName']"));
        String firstnamevalue = "Dascalu";
        firstnameButtonElement.sendKeys(firstnamevalue);
        System.out.println(firstnamevalue);

        WebElement lastnameButtonElement = driver.findElement(By.cssSelector("input[ng-model='LastName']"));
        String lastnamevalue = "marius";
        lastnameButtonElement.sendKeys(lastnamevalue);
        System.out.println(lastnamevalue);

        WebElement addressElement = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        String addressValue = "When the night has come, i can see Jean Claude Van Dame";
        addressElement.sendKeys(addressValue);
        System.out.println(addressValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[ng-model='EmailAdress']"));
        String emailValue = "numeprenume@yahoo.com";
        emailElement.sendKeys(emailValue);
        System.out.println(emailValue);

        WebElement phoneElement = driver.findElement(By.cssSelector("input[ng-model='Phone']"));
        String phonelValue = "0123456789";
        phoneElement.sendKeys(phonelValue);
        System.out.println(phonelValue);

        List<WebElement> genderButtons = driver.findElements(By.cssSelector("div.col-md-4 input[type='radio']"));
        for (WebElement genderButton : genderButtons) {
            String genderValue = genderButton.getAttribute("value");
            switch (genderValue) {
                case "Male":
                    genderButton.click();
                    System.out.println("Radiobutton 'Male' selected.");
                    break;
                case "FeMale":
                    System.out.println("Radiobutton 'FeMale' found but not selected.");
                    break;

                default:
                    System.out.println("Unrecognized radio button value: " + genderValue);
                    break;
            }
        }
        List<WebElement> hobbiesElements = driver.findElements(By.cssSelector("div.col-md-4 input[type='checkbox']"));
        for (WebElement hobbieElemnt : hobbiesElements) {
            String value = hobbieElemnt.getAttribute("value");
            switch (value) {
                case "Cricket":
                    System.out.println("Checkbox 'Cricket' found but not selected.");
                    break;

                case "Movies":
                    if (!hobbieElemnt.isSelected()) {
                        hobbieElemnt.click();
                        System.out.println("Checkbox 'Movies' selected.");
                    } else {
                        System.out.println("Checkbox 'Movies' was already selected.");
                    }
                    break;

                case "Hockey":
                    if (!hobbieElemnt.isSelected()) {
                        hobbieElemnt.click();
                        System.out.println("Checkbox 'Hockey' selected.");
                    } else {
                        System.out.println("Checkbox 'Hockey' was already selected.");
                    }
                    break;
                default:
                    System.out.println("Unrecognized checkbox value: " + value);
                    break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement languageDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("msdd")));
        languageDropdownElement.click();

        WebElement romanianOptionElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Romanian']")));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", romanianOptionElement);
        romanianOptionElement.click();

        WebElement skillsDropdownElement = driver.findElement(By.id("Skills"));
        Select selectSkills = new Select(skillsDropdownElement);
        //selectSkills.selectByVisibleText("APIs"); //1
        //selectSkills.selectByVisibleText("iOS");  //2
        selectSkills.selectByVisibleText("SQL");  //3

        //Country does not work

        WebElement countryDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select2-selection select2-selection--single']")));
        countryDropdownElement.click();

        WebElement searchInputDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        searchInputDropdownElement.sendKeys("Denmark");

        WebElement selectCountryOptionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Denmark')]")));
        selectCountryOptionElement.click();

        WebElement yearSelectionDropdownElement = driver.findElement (By.id("yearbox"));
        Select selectYear = new Select(yearSelectionDropdownElement);
        selectYear.selectByVisibleText("1982");

        WebElement monthSelectionDropdownElement = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
        Select selectMonth = new Select(monthSelectionDropdownElement);
        selectMonth.selectByVisibleText("August");

        WebElement daySelectionDropdownElement = driver.findElement (By.id("daybox"));
        Select selectDay = new Select(daySelectionDropdownElement);
        selectDay.selectByVisibleText("17");

        WebElement firstPasswordElement = driver.findElement(By.id("firstpassword"));
        String firstPasswordElementValue = "QAZxsw1234!";
        firstPasswordElement.sendKeys(firstPasswordElementValue);

        WebElement secondPasswordElement = driver.findElement(By.id("secondpassword"));
        String secondPasswordElementValue = "QAZxsw1234!";
        secondPasswordElement.sendKeys(secondPasswordElementValue);

        //Refresh button
        //WebElement refreshButtonElement = driver.findElement(By.id("Button1"));
        //refreshButtonElement.click();

        WebElement submitButtonElement = driver.findElement(By.id("submitbtn"));
        submitButtonElement.click();
        // When the submit button is clicked and error regarding the selection of the Country is prompted (i think is intended or the option is just not working)

        driver.quit();

























        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scroolBy(0,350)",  "");



    }


    //WebElement dayElement = driver.findElement(By.name("DateOfBirthDay"));
    //Select daySelect = new Select(dayElement);
    //daySelect.selectByVisibleText("17");

    //WebElement monthElement = driver.findElement(By.name("DateOfBirthMonth"));
    //Select monthSelect = new Select(monthElement);
    //monthSelect.selectByVisibleText("August");

    //WebElement yearElement = driver.findElement(By.name("DateOfBirthYear"));
    //Select yearSelect = new Select(yearElement);
    //yearSelect.selectByVisibleText("1982");

       /* try {
            Thread.sleep(3000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        */
    //JavascriptExecutor js = (JavascriptExecutor) driver;
    //js.executeScript("window.scroolBy(0,350)",  "");
      /* WebElement languageDropdownElement = driver.findElement(By.cssSelector("div.ui-autocomplete-multiselect"));
        languageDropdownElement.click();

    List<WebElement> languageOptionsElement = driver.findElements(By.cssSelector("ul.ui-autocomplete li.ng-scope a"));

        for (WebElement option : languageOptionsElement) {
        String text = option.getText();

        if (text.equals("Romanian")) {
            option.click();
            System.out.println("Selected 'Romanian' language.");
            break;
        }
    */}













