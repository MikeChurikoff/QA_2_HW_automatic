package HW_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExByJetbrains {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("web-driver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jetbrains.com/idea/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='[A]ccept All']")).click();

        //Ex#9 + Ex#10
        driver.findElement(By.className("menu-second__download-button")).click();

        //driver.findElement(By.xpath("//a[contains(@href,'platform=windows')]")).click();

        driver.findElement(By.xpath("//a[contains(@href,'platform=windows')][contains(@href,'code=IIC')]")).click();

        driver.quit();

    }
}
