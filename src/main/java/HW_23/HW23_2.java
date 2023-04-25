package HW_23;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW23_2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.w3schools.com/");
        WebElement element1 = driver.findElement(By.id("navbtn_tutorials"));
        WebElement element2 = driver.findElement(By.id("navbtn_references"));
        compareWebElements(element1, element2);
        driver.quit();
    }
    public static void compareWebElements(WebElement element1, WebElement element2) {
        Point location1 = element1.getLocation();
        Point location2 = element2.getLocation();
        Dimension size1 = element1.getSize();
        Dimension size2 = element2.getSize();

        if (location1.y < location2.y) {
            System.out.println("Элемент " + element1.getText() + " расположен выше, чем элемент " + element2.getText());
        } else if (location1.y > location2.y) {
            System.out.println("Элемент " + element2.getText() + " расположен выше, чем элемент " + element1.getText());
        } else {
            System.out.println("Элементы расположены на одной высоте.");
        }

        if (location1.x < location2.x) {
            System.out.println("Элемент " + element1.getText() + " расположен левее, чем элемент " + element2.getText());
        } else if (location1.x > location2.x) {
            System.out.println("Элемент " + element2.getText() + " расположен левее, чем элемент " + element1.getText());
        } else {
            System.out.println("Элементы расположены на одном горизонте.");
        }

        int area1 = size1.width * size1.height;
        int area2 = size2.width * size2.height;

        if (area1 > area2) {
            System.out.println("Элемент " + element1.getText() + " площадью больше, чем элемент " + element2.getText());
        } else if (area1 < area2) {
            System.out.println("Элемент " + element2.getText() + " площадью больше, чем элемент " + element1.getText());
        } else {
            System.out.println("Элементы одинаковы по площади.");
        }
    }
}



