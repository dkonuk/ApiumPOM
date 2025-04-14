package qa.tests;

import org.testng.annotations.*;
import qa.BaseTest;
import qa.pages.LoginPage;
import qa.pages.MainPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;
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
    @Test
    public void testSuccessfulLogin() {
        loginPage.waitForVisibilityofmainpage();
        loginPage.pressmenubutton();
        loginPage.pressloginpage();
        loginPage.enterUserName("bob@example.com");
        loginPage.enterPassword("10203040");
        mainPage = loginPage.clickLoginButton();
        mainPage.waitForVisibilityofmainpage();
        mainPage.clickStoreItem();



    }
}
