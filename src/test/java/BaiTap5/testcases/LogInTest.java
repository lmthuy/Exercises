package BaiTap5.testcases;

import BaiTap5.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    public LoginPage loginPage;

    @BeforeMethod
    public void logInTest() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginSuccess() {
        loginPage.logIn("thuy.le030799@gmail.com", "123456");
    }


    @Test
    public void testLoginWithEmailInvalid() {
        loginPage.logInwithEmailInvalid("thuy.le0307@icloud.com", "123456");
    }
    @Test
    public void testLoginWithPasswordInvalid(){
        loginPage.logInwithPasswordInvalid("thuy.le030799@gmail.com","147258");
    }
    @Test
    public void testForgetPassword(){
        loginPage.forgotPassword("thuy.le0307@icloud.com");
    }
}