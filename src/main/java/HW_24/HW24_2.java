package HW_24;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HW24_2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.ashortjourney.com/");
        Actions actions = new Actions(driver);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        //Работают оба метода, но второй более четко отрабатывает. Первый иногда лагает, непонятно из-за чего.
        //А вообще достала меня именно эта ДЗ. Как то криво тут все).


     /*   for (int i = 1; i <= 7; i++) {
            WebElement firstCircle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '40']")));
            WebElement secondCircle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '8']")));

            int x = secondCircle.getSize().width / 2;
            int y = secondCircle.getSize().height / 2;

            actions.clickAndHold(firstCircle).build().perform();
            actions.moveToElement(secondCircle, x, y).build().perform();
            actions.release().build().perform();
        }

        WebElement textarea = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='postcard-back-content']/textarea")));
        Thread.sleep(5000);
        actions.moveToElement(textarea).click().sendKeys("Задание выполнено").build().perform();



*/


        WebElement scene1Circle1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '40']")));
        WebElement scene1Circle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '8']")));


        actions.clickAndHold(scene1Circle1).build().perform();
        actions.moveToElement(scene1Circle2).build().perform();
        actions.moveByOffset(50, 50).build().perform();
        actions.release().build().perform();

        WebElement scene2Circle1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '40']")));
        WebElement scene2Circle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '8']")));

        actions.clickAndHold(scene2Circle1).build().perform();
        actions.moveToElement(scene2Circle2).build().perform();
        actions.release().build().perform();

        WebElement scene3Circle1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '40']")));
        WebElement scene3Circle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '8']")));

        actions.clickAndHold(scene3Circle1).build().perform();
        actions.moveToElement(scene3Circle2).build().perform();
        actions.release().build().perform();

        WebElement scene4Circle1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '40']")));
        WebElement scene4Circle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '8']")));

        actions.clickAndHold(scene4Circle1).build().perform();
        actions.moveToElement(scene4Circle2).build().perform();
        actions.release().build().perform();

        WebElement scene5Circle1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '40']")));
        WebElement scene5Circle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '8']")));

        actions.clickAndHold(scene5Circle1).build().perform();
        actions.moveToElement(scene5Circle2).build().perform();
        actions.release().build().perform();

        WebElement scene6Circle1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '40']")));
        WebElement scene6Circle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '8']")));

        actions.clickAndHold(scene6Circle1).build().perform();
        actions.moveToElement(scene6Circle2).build().perform();
        actions.release().build().perform();

        WebElement scene7Circle1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '40']")));
        WebElement scene7Circle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[r = '8']")));

        int x = scene7Circle1.getSize().width / 2;
        int y = scene7Circle2.getSize().height / 2;

        actions.clickAndHold(scene7Circle1).build().perform();
        actions.moveToElement(scene7Circle2, x, y).build().perform();
        actions.pause(3).release().build().perform();

        WebElement textarea = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='postcard-back-content']/textarea")));
        Thread.sleep(5000);
        actions.moveToElement(textarea).click().sendKeys("Задание выполнено").build().perform();
    }
}
















