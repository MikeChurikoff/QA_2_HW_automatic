package HW_23;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class HW23_3 {
    private final WebDriver driver;
    public HW23_3(WebDriver driver) {
        this.driver = driver;
    }
    public static class ElementAttributeNotFoundException extends Exception {
        public ElementAttributeNotFoundException(String message) {
            super(message);
        }
    }
    public void getElementInfo(String selector) throws ElementAttributeNotFoundException, InterruptedException {

        WebElement element = driver.findElement(By.cssSelector(selector));

        String elementId = element.getAttribute("id");
        if (elementId == null || elementId.isEmpty()) {
            throw new ElementAttributeNotFoundException("Element ID not found.");
        }
        String elementTag = element.getTagName();
        if (elementTag == null) {
            throw new ElementAttributeNotFoundException("Element tag not found.");
        }
        String elementClass = element.getAttribute("class");
        if (elementClass == null) {
            throw new ElementAttributeNotFoundException("Element class not found.");
        }
        String elementName = element.getAttribute("name");
        if (elementName == null) {
            throw new ElementAttributeNotFoundException("Element name not found.");
        }
        String elementText = element.getText();
        if (elementText == null) {
            throw new ElementAttributeNotFoundException("Element text not found.");
        }
        //Thread.sleep(1000);
        Point elementLocation = element.getLocation();
        Dimension elementSize = element.getSize();
        int centerX = elementLocation.getX() + elementSize.getWidth() / 2;
        int centerY = elementLocation.getY() + elementSize.getHeight() / 2;

        System.out.println("Element ID: " + elementId);
        System.out.println("Element tag: " + elementTag);
        System.out.println("Element class: " + elementClass);
        System.out.println("Element name: " + elementName);
        System.out.println("Element text: " + elementText);
        System.out.println("Element center coordinates: (" + centerX + ", " + centerY + ")");
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        HW23_3 info = new HW23_3(driver);

        try {
            driver.get("https://www.w3schools.com/");
            info.getElementInfo("#navbtn_tutorials");
        } catch (ElementAttributeNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}

