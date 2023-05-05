package HW_25;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HW25_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/search");
        Actions actions = new Actions(driver);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        searchBox.submit();
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Guinness World Records")));
        actions.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();

        searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.clear();
        searchBox.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        searchBox.submit();
        link = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("AlertsDemo")));
        actions.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();

        searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("APjFqb")));
        searchBox.clear();
        searchBox.sendKeys("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        searchBox.submit();
        link = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("W3Schools Tryit Editor")));
        actions.click(link).build().perform();

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        WebElement iframeInputNameSurname = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(iframeInputNameSurname);

        WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fname")));
        enterName.clear();
        enterName.sendKeys("Mike");

        WebElement enterSurname = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lname")));
        enterSurname.clear();
        enterSurname.sendKeys("Churikoff");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/form/input[3]"));
        actions.moveToElement(submitButton).click().perform();

        WebElement textNote = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]")));
        System.out.println(textNote.getText());

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> allWindowsHandlesList = new ArrayList<String>(windowHandles);
        String createAccount = allWindowsHandlesList.get(1);
        driver.switchTo().window(createAccount);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Guinness World Records")));
        WebElement enterLastName = driver.findElement(By.id("LastName"));
        enterLastName.sendKeys("Churikoff");
        WebElement enterFirstName = driver.findElement(By.id("FirstName"));
        enterFirstName.sendKeys("Mike");
        WebElement enterDateOfBirthDay = driver.findElement(By.id("DateOfBirthDay"));
        enterDateOfBirthDay.sendKeys("13");
        WebElement enterDateOfBirthMonth = driver.findElement(By.id("DateOfBirthMonth"));
        enterDateOfBirthMonth.sendKeys("11");
        WebElement enterDateOfBirthYear = driver.findElement(By.id("DateOfBirthYear"));
        enterDateOfBirthYear.sendKeys("2000");

        Select selectCountry = new Select(driver.findElement(By.id("Country")));
        selectCountry.selectByVisibleText("Ukraine");

        WebElement selectState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='State']")));
        selectState.sendKeys("Kyiv");

        WebElement enterEmail = driver.findElement(By.id("EmailAddress"));
        enterEmail.sendKeys("mailmail@mail.cim");

        WebElement enterConfirmEmailAddress = driver.findElement(By.id("ConfirmEmailAddress"));
        enterConfirmEmailAddress.sendKeys("mailmail@mail.cim");

        WebElement enterPassword = driver.findElement(By.id("Password"));
        enterPassword.sendKeys("blablabla");

        WebElement enterConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
        enterConfirmPassword.sendKeys("blablabl");
        enterConfirmPassword.sendKeys(Keys.ENTER);

        WebElement alarmText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/div/form/section[2]/div[2]/div[2]/span/span")));
        System.out.println(alarmText.getText());

        String alertsDemoWindowHandle = allWindowsHandlesList.get(2);
        driver.switchTo().window(alertsDemoWindowHandle);

        WebElement alertBoxButton = driver.findElement(By.id("alertBox"));
        WebElement confirmBoxButton = driver.findElement(By.id("confirmBox"));
        WebElement promptBoxButton = driver.findElement(By.id("promptBox"));

        alertBoxButton.click();

        Alert alertBox = driver.switchTo().alert();
        alertBox.accept();
        WebElement boxOutputText = driver.findElement(By.id("output"));
        System.out.println(boxOutputText.getText());

        confirmBoxButton.click();
        Alert confirmBox = driver.switchTo().alert();
        confirmBox.dismiss();
        System.out.println(boxOutputText.getText());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        promptBoxButton.click();
        Alert promptBox = driver.switchTo().alert();
        //promptBox.sendKeys("Final step of this task");
        String sendkeys = "Final step of this task";
        promptBox.sendKeys(sendkeys);
        promptBox.accept();
        Thread.sleep(2000);
        System.out.println(boxOutputText.getText());

        driver.quit();
    }
}








