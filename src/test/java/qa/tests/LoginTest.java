package qa.tests;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.*;
import qa.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import qa.pages.BackPackProductPage;
import qa.pages.LoginPage;
import qa.pages.MainPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;
    private BackPackProductPage BackPackProductPage;
    private AndroidDriver androidDriver;
    @BeforeClass
    public void setup() {

    }
    @AfterClass
    public void afterClass() {

    }
    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
        }



    @AfterMethod
    public void afterMethod() {
        }

        @Test(priority = 1)
    public void testUnsuccessfulLogin() {
        loginPage.waitForVisibilityofmainpage();
        loginPage.pressmenubutton();
        loginPage.pressloginpage();
        loginPage.enterUserName("bob@example.com");
        loginPage.enterPassword("<PASSWORD>");
        loginPage.clickLoginButton();
    }
    @Test(priority = 2)
    public void testSuccessfulLogin() {
        loginPage.waitForVisibilityofmainpage();
        loginPage.pressmenubutton();
        loginPage.pressloginpage();
        loginPage.clearInputFields();
        loginPage.enterUserName("bob@example.com");
        loginPage.enterPassword("10203040");
        mainPage = loginPage.clickLoginButton();
        mainPage.waitForVisibilityofmainpage();
        BackPackProductPage = mainPage.clickStoreItem();
        BackPackProductPage.chooseBlueCircle();
        BackPackProductPage.clickAddToCartButton();

    }

}
