package BaiTap5.testcases;

import BaiTap5.pages.AddNewProductPage;
import BaiTap5.pages.CategoryPage;
import BaiTap5.pages.DashboardPage;
import BaiTap5.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CategoryPage categoryPage;
    private AddNewProductPage addNewProductPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testOpenCategory(){
        dashboardPage = loginPage.logIn("thuy.le030799@gmail.com", "123456");
        dashboardPage.openCategory();
    }
    @Test
    public void testOpenAddNewProduct(){
        dashboardPage = loginPage.logIn("thuy.le030799@gmail.com","123456");
        dashboardPage.openAddNewProduct();
    }

    @Test
    public void testLogOut() {
        dashboardPage = loginPage.logIn("thuy.le030799@gmail.com", "123456");
        dashboardPage.logOut();
    }
}
