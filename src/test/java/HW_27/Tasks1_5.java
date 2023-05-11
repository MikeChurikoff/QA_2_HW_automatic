package HW_27;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Tasks1_5 {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void checkNumberOfWindows() {
        driver.get("https://dan-it.com.ua/uk/");

        WebElement adultsMenu = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/a"));
        actions.moveToElement(adultsMenu).build().perform();

        WebElement openJavaWindow = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/ul/li[6]/a"));
        openJavaWindow.sendKeys(Keys.CONTROL, Keys.RETURN);

        WebElement openQaWindow = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/ul/li[8]/a"));
        openQaWindow.sendKeys(Keys.CONTROL, Keys.RETURN);

        WebElement openFrontEndWindow = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/ul/li[3]/a"));
        openFrontEndWindow.sendKeys(Keys.CONTROL, Keys.RETURN);

        Set<String> windows = driver.getWindowHandles();
        Assert.assertEquals(windows.size(), 4);
        System.out.println("Тест пройден: количество открытых окон равно 4.");
        driver.quit();
    }
    @Test
    public void checkOpenWindow() {
        driver.get("https://uhomki.com.ua/ru/");

        WebElement paymentAndDeliveryMenu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/div/div[1]/div/nav/span[3]/a"));
        actions.click(paymentAndDeliveryMenu).build().perform();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://uhomki.com.ua/ru/oplata-i-dostavka/";
        Assert.assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }
    @Test
    public void checkSearchingResults() throws InterruptedException {
        driver.get("https://uhomki.com.ua/ru/");

        WebElement inputSearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='поиск товаров']")));
        //actions.click(inputSearch).sendKeys("cмесь").sendKeys(Keys.ENTER).build().perform();
        inputSearch.sendKeys("смесь");
        Thread.sleep(500);
        inputSearch.sendKeys(Keys.ENTER);
        WebElement inputSearchResultsPage1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='поиск товаров']")));
        inputSearchResultsPage1.clear();
        WebElement searchTargetText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j-catalog-header")));
        String searchResultsText = searchTargetText.getText();
        Assert.assertTrue(searchResultsText.contains("смесь"), "Слово 'cмесь' не найдено.");

        inputSearchResultsPage1.sendKeys("спесь");
        Thread.sleep(500);
        inputSearchResultsPage1.sendKeys(Keys.ENTER);
        WebElement inputSearchResultsPage2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='поиск товаров']")));
        inputSearchResultsPage2.clear();
        searchTargetText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j-catalog-header")));
        searchResultsText = searchTargetText.getText();
        Assert.assertTrue(searchResultsText.contains("спесь"), "Слово 'спесь' не найдено.");

        inputSearchResultsPage2.sendKeys("ересь");
        Thread.sleep(500);
        inputSearchResultsPage2.sendKeys(Keys.ENTER);
        searchTargetText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j-catalog-header")));
        searchResultsText = searchTargetText.getText();
        Assert.assertTrue(searchResultsText.contains("ересь"), "Слово 'ересь' не найдено.");
        driver.quit();
    }
    @Test
    public void checkBoxCheck() {
        driver.get("https://www.guinnessworldrecords.com/Account/Login");

        WebElement rememberMeCheckbox = driver.findElement(By.id("RememberMe"));
        Assert.assertFalse(rememberMeCheckbox.isSelected(), "Чекбокс 'RememberMe' уже выбран");
        rememberMeCheckbox.click();
        Assert.assertTrue(rememberMeCheckbox.isSelected(), "Чекбокс'RememberMe' не выбран");
        rememberMeCheckbox.click();
        Assert.assertFalse(rememberMeCheckbox.isSelected(), "Checkbox 'RememberMe' опять не выбран");
        driver.quit();
    }
    @Test
    public void checkModalWindow(){
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");

        WebElement alertButton = driver.findElement(By.xpath("//*[@id=\"post-body-4292417847084983089\"]/div[1]/input"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        String expectedText = "Hi.. This is alert message!";
        String actualText = alert.getText();
        Assert.assertEquals(expectedText, actualText);
        alert.accept();
        driver.quit();
    }
}




















