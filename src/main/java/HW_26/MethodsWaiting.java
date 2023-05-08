package HW_26;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.function.Function;

public class MethodsWaiting {
    private final WebDriver driver;
    private static final long EXPLICITY_WAIT = 20L;
    public MethodsWaiting(WebDriver driver) {
        this.driver = driver;
    }

    private FluentWait<WebDriver> fluentWait(Long duration) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }
    private void waitForFunction(Function function, Long timeOutInSeconds) {
        FluentWait<WebDriver> wait = fluentWait(timeOutInSeconds);
        wait.until(function);
    }


    public void waitForPresenceOfElementLocated(By by) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by), EXPLICITY_WAIT);
    }

    public void waitForPresenceOfElementLocated(WebElement element) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated((By) element), EXPLICITY_WAIT);
    }

    public WebElement waitForPresenceOfElementLocatedReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForPresenceOfElementLocatedReturn(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated((By) element));
    }


    public void waitForTextToBePresentInElementValue(WebElement element, String text) {
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(element, text), EXPLICITY_WAIT);
    }

    public void waitForTextToBePresentInElementValue(By by, String text) {
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(driver.findElement(by), text), EXPLICITY_WAIT);
    }

    public Boolean waitForTextToBePresentInElementValueReturn(WebElement element, String text) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public Boolean waitForTextToBePresentInElementValueReturn(By by, String text) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(by), text));
    }


    public Boolean waitForInvisibilityOfElement(WebElement element) {
        waitForFunction(ExpectedConditions.invisibilityOf(element), EXPLICITY_WAIT);
        return null;
    }

    public Boolean waitForInvisibilityOfElementReturnElement(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.invisibilityOf(element));
    }

    public Boolean waitForInvisibilityOfElementReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public void waitForTitleContainsByElement(String expectedTitle) {
        waitForFunction(ExpectedConditions.titleContains(expectedTitle), EXPLICITY_WAIT);
    }

    public void waitForTitleContainsByLocator(By by, String expectedTitle) {
        waitForFunction(ExpectedConditions.titleContains(expectedTitle), EXPLICITY_WAIT);
    }

    public Boolean waitForTitleContainsReturn(String expectedTitle) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.titleContains(expectedTitle));
    }

    public Boolean waitForTitleContainsReturn(By by, String expectedTitle) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.titleContains(expectedTitle));
    }


    public void waitForTitleIs(String expectedTitle) {
        waitForFunction(ExpectedConditions.titleIs(expectedTitle), EXPLICITY_WAIT);
    }

    public void waitForTitleIs(By by, String expectedTitle) {
        WebElement element = driver.findElement(by);
        waitForFunction(ExpectedConditions.titleIs(expectedTitle), EXPLICITY_WAIT);
    }

    public Boolean waitForTitleIsReturn(String expectedTitle) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.titleIs(expectedTitle));
    }

    public Boolean waitForTitleIsReturn(By by, String expectedTitle) {
        WebElement element = driver.findElement(by);
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.titleIs(expectedTitle));
    }


    public void waitForElementToBeClickable(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeClickable(element), EXPLICITY_WAIT);
    }

    public void waitForElementToBeClickable(By by) {
        waitForFunction(ExpectedConditions.elementToBeClickable(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public WebElement waitForElementToBeClickableAndReturn(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickableAndReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }

    public void waitForElementToBeClickableAndDoAction(WebElement element) {
        fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForElementToBeClickableAndDoAction(By by) {
        fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(driver.findElement(by))).click();
    }


    public void waitForElementToBeSelected(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeSelected(element), EXPLICITY_WAIT);
    }

    public void waitForElementToBeSelected(By by) {
        waitForFunction(ExpectedConditions.elementToBeSelected(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public void waitForElementToBeSelectedAndReturn(WebElement element) {
        fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitForElementToBeSelectedAndReturn(By by) {
        fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeSelected(driver.findElement(by)));
    }

    public void waitForElementSelectionStateToBe(WebElement element, boolean selected) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element, selected), EXPLICITY_WAIT);
    }

    public void waitForElementSelectionStateToBe(By by, boolean selected) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(driver.findElement(by), selected), EXPLICITY_WAIT);
    }

    public Boolean waitForElementSelectionStateToBeReturn(WebElement element, boolean selected) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }

    public Boolean waitForElementSelectionStateToBeReturn(By by, boolean selected) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementSelectionStateToBe(driver.findElement(by), selected));
    }


    public void waitForVisibilityOfElementLocated(By by) {
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(by), EXPLICITY_WAIT);
    }

    public WebElement waitForVisibilityOfElementLocatedReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public void waitForFrameToBeAvailableAndSwitchToIt(WebElement frameElement) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement), EXPLICITY_WAIT);
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(By by) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by), EXPLICITY_WAIT);
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(String frameNameOrId) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId), EXPLICITY_WAIT);
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(int frameIndex) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex), EXPLICITY_WAIT);
    }

    public void waitForFrameToBeAvailableAndSwitchToItFluent(WebElement frameElement) {
        fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    public void waitForFrameToBeAvailableAndSwitchToItFluent(By by) {
        fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public void waitForFrameToBeAvailableAndSwitchToItFluent(String frameNameOrId) {
        fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
    }

    public void waitForFrameToBeAvailableAndSwitchToItFluent(int frameIndex) {
        fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }

    public WebElement waitForFrameToBeAvailableAndSwitchToItReturn(WebElement frameElement) {
        return (WebElement) fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    public WebElement waitForFrameToBeAvailableAndSwitchToItReturn(By by) {
        return (WebElement) fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public WebElement waitForFrameToBeAvailableAndSwitchToItReturn(String frameNameOrId) {
        return (WebElement) fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
    }

    public WebElement waitForFrameToBeAvailableAndSwitchToItReturn(int frameIndex) {
        return (WebElement) fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }



    public void waitForAlertPresent() {
        waitForFunction(ExpectedConditions.alertIsPresent(), EXPLICITY_WAIT);
    }

    public Alert waitForAlertReturn() {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.alertIsPresent());
    }
}


















