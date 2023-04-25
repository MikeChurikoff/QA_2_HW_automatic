package HW_23;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW23_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe ");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //Почему то в этом варианте сначала открывается пустая страница data:,
        //Так и не понял как это убрать(


          /* List<String> urls = Arrays.asList(
                    "https://uhomki.com.ua/ru/koshki/1074/",
                    "https://zoo.kiev.ua/",
                    "https://www.w3schools.com/",
                    "https://taxi838.ua/ru/dnepr/",
                    "https://klopotenko.com/");

            for (String url : urls) {
                driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
                driver.get(url);
            }
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                String title = driver.getTitle();
                String url = driver.getCurrentUrl();
                System.out.println(title + ": " + url);
                if (title.toLowerCase().contains("зоопарк")) {
                    driver.close();
                }
            }
            */


        driver.get("https://uhomki.com.ua/ru/koshki/1074/");
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.get("https://zoo.kiev.ua/");
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.get("https://www.w3schools.com/");
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.get("https://taxi838.ua/ru/dnepr/");
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.get("https://klopotenko.com/");

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            String url = driver.getCurrentUrl();
            System.out.println(title + ": " + url);
        }

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            if (title.toLowerCase().contains("зоопарк")) {
                driver.close();
            }
        }
        Thread.sleep(5000);
        driver.quit();
    }
}

















