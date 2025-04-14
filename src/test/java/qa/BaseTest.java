package qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.time.Duration;
import java.util.Properties;
import java.net.URI;
import org.testng.annotations.Parameters;

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
    // Java built-in logging
    java.util.logging.Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());
    logger.log(java.util.logging.Level.SEVERE, "Operation failed", e);
    throw e;
}


    }

    @AfterTest
    public void afterTest() {
            if (driver != null) {
                driver.quit();
            }
    System.out.println("Test Completed");
        }

    }


