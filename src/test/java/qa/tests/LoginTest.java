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
    public void testLogin() {
        loginPage.waitForVisibilityofmainpage();
        loginPage.pressmenubutton();
        loginPage.pressloginpage();
        loginPage.enterUserName("admin");
        loginPage.enterPassword("<PASSWORD>");
        mainPage = loginPage.clickLoginButton();


    }
}
