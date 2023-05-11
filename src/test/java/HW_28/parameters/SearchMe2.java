package HW_28.parameters;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class SearchMe2 {
    @Test
    @Parameters({"input"})
    public void checkSearch(String text) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Я ищу ...']")));
        search.sendKeys(text);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@value='Найти']")));
        button.click();

        wait.until(ExpectedConditions.titleContains("Найдено по запросу"));
        WebElement h1Element = driver.findElement(By.tagName("h1"));
        if (h1Element.getText().contains("Результаты поиска")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-page__box-title']/label")));
            WebElement label = driver.findElement(By.xpath("//div[@class='search-page__box-title']/label"));
            assertEquals(label.getText(), "«" + text + "»", "Фактический результат = " + label.getText() +
                    ", Ожидаемый: " + text);
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
            String result = h1Element.getText().replace("Найдено по запросу ", "");
            assertEquals(result, "«" + text + "»", "Фактический результат = " + h1Element.getText() +
                    ", Ожидаемый: " + text);
        }
        driver.quit();
    }

}