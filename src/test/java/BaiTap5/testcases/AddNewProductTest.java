package BaiTap5.testcases;

import BaiTap5.pages.AddNewProductPage;
import BaiTap5.pages.DashboardPage;
import BaiTap5.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewProductTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AddNewProductPage addNewProductPage;

    @BeforeMethod
    public void setupTest() {
       loginPage = new LoginPage(driver);
       addNewProductPage = new AddNewProductPage(driver);
    }
    @Test
    public void testAddNewProduct(){
        dashboardPage = loginPage.logIn("thuy.le030799@gmail.com","123456");
        dashboardPage.openAddNewProduct();
        addNewProductPage.addProduct();
    }


}
