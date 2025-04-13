package qa.tests;

import org.testng.annotations.*;
import qa.BaseTest;
import qa.pages.LoginPage;
import qa.pages.MainPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    @BeforeClass
    public void setup() {

    }
    @AfterClass
    public void afterClass() {

    }
    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage();

    }
    @AfterMethod
    public void afterMethod() {

    }
    @Test
    public void testLogin() {
        loginPage.waitForVisibilityofmainpage();


    }
}
