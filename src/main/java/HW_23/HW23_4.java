package HW_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class HW23_4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/koshki/1074/");

       /* java.util.List<WebElement> elements = driver.findElements(By.xpath("//li[@class='products-menu__item j-submenu-item']"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }*/

        java.util.List<WebElement> elements = driver.findElements(By.xpath("//li[@class='footer__menu-item ']"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        driver.quit();
    }
}
