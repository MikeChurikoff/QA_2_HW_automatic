package HW_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExByUhomki {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/koshki/1074/");

        //Ex#1

        //driver.findElement(By.xpath("//span[@class= 'userbar__button-text']")).click();
        //driver.findElement(By.xpath("//span[text()='Вход']")).click();
        //driver.findElement(By.cssSelector(".userbar__button-text")).click();
        //driver.findElement(By.linkText("Вход")).click();


        //Ex#2
        /*driver.findElement(By.xpath("//div[@class='footer__heading' and text()='Каталог']" +
                "/following-sibling::ul/li/a[text()='Собаки/кошки общее']")).click();*/






        //Ex#4
        driver.findElements(By.xpath("//a[text() = 'Аквариумистика']" +
                 "/following-sibling::div//span[text() = 'Аквариумы'][1]"));






    }

}








