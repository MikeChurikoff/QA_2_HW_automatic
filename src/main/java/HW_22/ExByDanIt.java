package HW_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExByDanIt {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe ");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/uk/");

        //Ex#3
        /*driver.findElements(By.xpath("//h1[text()='Якісна міжнародна IT-освіта']" +
                "/following-sibling::div/a[@class='main-banner-btn btn-gradient docs-creator']"));*/


        //Ex#5
        //driver.findElement(By.cssSelector("a[href='tel:0 800 335 695']")).click();



        //Ex#6
        //driver.findElement(By.xpath("//p[@class = 'banner-meta__name'][1]")).click();


        //Ex#8
        WebElement secondElement = driver.findElement(By.className("main-info__title"));
        WebElement firstElement = secondElement.findElement(By.xpath("following-sibling::p[@class='main-info__text']"));
        Thread.sleep(2000);
         driver.quit();


    }
}
