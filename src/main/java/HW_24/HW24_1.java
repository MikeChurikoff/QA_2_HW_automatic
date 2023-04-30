package HW_24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW24_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        Actions actions = new Actions(driver);

        WebElement carList = driver.findElement(By.id("Carlist"));
        WebElement countryList1 = driver.findElement(By.xpath("//select[@name='FromLB'][@multiple][@size='10'][1]"));
        WebElement countryList2 = driver.findElement(By.xpath("//select[@name='ToLB'][@multiple][@size='10'][1]"));

        Select selectBrendOfCar = new Select(carList);
        Select selectCountry1 = new Select(countryList1);
        Select selectCountry2 = new Select(countryList2);

        selectBrendOfCar.selectByVisibleText("Renault");
        actions.click().build().perform();

        selectCountry1.selectByVisibleText("France");
        selectCountry1.selectByVisibleText("Germany");
        selectCountry1.selectByVisibleText("Italy");
        selectCountry1.selectByVisibleText("Spain");
        actions.click().build().perform();

        driver.findElement(By.xpath("//input[@onclick='move(this.form.FromLB,this.form.ToLB)'][@type='button']")).click();

        List<WebElement> options = selectBrendOfCar.getOptions();

        System.out.println("Автомобили доступные для выбора:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        System.out.println("Страны из первой таблицы:");
        options = selectCountry1.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        System.out.println("Страны из второй таблицы:");
        options = selectCountry2.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        driver.quit();
    }
}


