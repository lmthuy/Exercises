package BaiTap5.testcases;

import BaiTap5.pages.CategoryPage;
import BaiTap5.pages.DashboardPage;
import BaiTap5.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CategoryPage categoryPage;

    @BeforeMethod
    public void setupTest() {
        //khởi tạo đầu tiên
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testAddCategory(){
        dashboardPage = loginPage.logIn("thuy.le030799@gmail.com", "123456");
        categoryPage = dashboardPage.openCategory();
        categoryPage.clickAddNewCategory();
        categoryPage.inputDataCategory();
        categoryPage.checkCategory();
    }

}
