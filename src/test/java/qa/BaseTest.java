package qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.time.Duration;
import java.util.Properties;
import java.net.URI;

import org.testng.annotations.Parameters;
import qa.utils.TestUtils;

public class BaseTest {

        protected AppiumDriver driver;
        protected Properties props;
        InputStream inputStream;

    @Parameters({"platformName", "platformVersion", "deviceName"})
    @BeforeTest
    public void beforeTest(String platformName, String platformVersion, String deviceName) throws IOException, URISyntaxException {
        try {
            props = new Properties();
            props.load(BaseTest.class.getClassLoader().getResourceAsStream("config.properties"));

            URI uri = new URI(props.getProperty("appiumURL"));
            URL url = uri.toURL();

            UiAutomator2Options androidOptions = new UiAutomator2Options()
                    .setApp(props.getProperty("androidAppLocation"))
                    .setPlatformName(platformName)
                    .setDeviceName(deviceName)
                    .setUdid("emulator-5554")
                    .setPlatformVersion(platformVersion)
                    .setAppPackage(props.getProperty("androidAppPackage"))
                    .setAppActivity(props.getProperty("androidAppActivity"))
                    .setNewCommandTimeout(Duration.ofSeconds(600));

            driver = new AndroidDriver(url, androidOptions);
            System.out.println("Before Test Driver initialized successfully");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
    public void waitForVisibility(WebElement e) {
        if (driver == null) {
        throw new IllegalStateException("WebDriver is not initialized");
    }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf((e)));
    }
    public void clickElement(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void sendKeys(WebElement e, String text) {
        waitForVisibility(e);
        e.sendKeys(text);
    }

    public void getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        e.getDomAttribute(attribute);
    }

    @AfterTest
    public void afterTest() {
            if (driver != null) {
                driver.quit();
            }
    System.out.println("Test");
        }

    }


