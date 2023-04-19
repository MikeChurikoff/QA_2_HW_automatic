package HW_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExByW3Schools {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");


        //#7


        //driver.findElement(By.id("navbtn_tutorials")).click();
        //driver.findElement(By.id("navbtn_references")).click();
        //driver.findElement(By.id("navbtn_exercises")).click();
        //driver.findElement(By.id("signupbtn_topnav")).click();
        //driver.findElement(By.id("myLearningFromDefault")).click();
        //driver.findElement(By.id("proFromDefault")).click();


        /*driver.findElement(By.id("nav_search_btn")).click();
        driver.findElement(By.id("gsc-i-id1")).sendKeys("input value");*/



        driver.findElement(By.id("search2")).sendKeys("Input");
        driver.findElement(By.id("learntocode_searchbtn")).click();











    }
}
