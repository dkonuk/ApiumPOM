package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected final AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        if (driver != null) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            throw new IllegalStateException("Driver not initialized");
        }
    }

    // Move helper methods from BaseTest to here
    protected void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void clickElement(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    protected String getAttribute(WebElement element, String attribute) {
        waitForVisibility(element);
        return element.getDomAttribute(attribute);
    }


}

