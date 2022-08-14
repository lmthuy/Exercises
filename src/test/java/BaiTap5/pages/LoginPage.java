package BaiTap5.pages;

import org.testng.Assert;
import projectmaven.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    private DashboardPage dashboardPage;
    private WebDriverWait wait;

    //Hàm xây dựng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        dashboardPage = new DashboardPage(driver);

    }

    private By closePopup = By.xpath("/html/body/div[2]/div[2]/div/button");
    private String pageText = "AT eCommerce | Automation Testing eCommerce";
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");

    private By alertError_1 = By.xpath("//span[@data-notify='message']");
    private By getAlertError_2 = By.xpath("//div[@role='alert']");

    private By forgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");
    private By emailResetPassword = By.xpath("//input[@placeholder='Email']");
    private By buttonResetPassword = By.xpath("//button[normalize-space()='Send Password Reset Link']");




    public DashboardPage logIn(String email, String password) {
        WebUI.openURL("https://ecommerce.anhtester.com/users/login");
        WebUI.clickElement(closePopup);
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        boolean checkMenu = WebUI.checkElementExist(dashboardPage.menuDashboard);
        Assert.assertTrue(checkMenu,"Not found Dashboard");

        return new DashboardPage(driver);
    }

    public void logInwithEmailInvalid(String email, String password) {
        WebUI.openURL("https://ecommerce.anhtester.com/users/login");
        WebUI.clickElement(closePopup);
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        boolean checkAlertError = WebUI.checkElementExist(alertError_1);
        Assert.assertTrue(checkAlertError,"Failed. Error alert not display");
        WebUI.sleep(2);
    }
    public void logInwithPasswordInvalid(String email, String password) {
        WebUI.openURL("https://ecommerce.anhtester.com/users/login");
        WebUI.clickElement(closePopup);
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        boolean checkAlertError = WebUI.checkElementExist(getAlertError_2);
        Assert.assertTrue(checkAlertError,"Failed. Error alert not display");
        WebUI.sleep(2);
    }
    public void forgotPassword(String email){
        WebUI.openURL("https://ecommerce.anhtester.com/users/login");
        WebUI.clickElement(closePopup);
        WebUI.clickElement(forgotPassword);
        WebUI.setText(emailResetPassword, email);
        WebUI.clickElement(buttonResetPassword);
        boolean checkAlert = WebUI.checkElementExist(alertError_1);
        Assert.assertTrue(checkAlert,"Input wrong Email");
        WebUI.sleep(2);
    }

}

