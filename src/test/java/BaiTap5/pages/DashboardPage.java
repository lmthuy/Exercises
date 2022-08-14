package BaiTap5.pages;

import jdk.jfr.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projectmaven.utils.WebUI;

public class DashboardPage {
    WebDriver driver;
    CategoryPage categoryPage;
    AddNewProductPage addNewProductPage;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
        addNewProductPage = new AddNewProductPage(driver);
    }

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By openCategory = By.xpath("//span[normalize-space()='Category']");

    private By headerPage = By.xpath("//h5[normalize-space()='Categories']");

    private By openButtonLogOut = By.xpath("//img[@src='https://ecommerce.anhtester.com/public/assets/img/avatar-place.png']");
    private By buttonLogOut = By.xpath("//a[@href='https://ecommerce.anhtester.com/logout']");

    private By addNewProduct = By.xpath("//span[normalize-space()='Add New Product']");


    public LoginPage logOut() {
        WebUI.clickElement(openButtonLogOut);
        WebUI.clickElement(buttonLogOut);
        return new LoginPage(driver);
    }

    public CategoryPage openCategory() {
        WebUI.clickElement(menuProducts);
        WebUI.clickElement(openCategory);
        WebUI.sleep(2);
        boolean checkPage = WebUI.checkElementExist(headerPage);
        Assert.assertTrue(checkPage, "Fail. Not found Category Page" + headerPage);
        return new CategoryPage(driver);

    }

    public AddNewProductPage openAddNewProduct() {

        WebUI.clickElement(menuProducts);
        WebUI.clickElement(addNewProduct);
        WebUI.sleep(2);
        boolean checkPage = WebUI.checkElementExist(addNewProductPage.headerPage);
        Assert.assertTrue(checkPage,"Failed. Not found Add New Product Page" +addNewProductPage.headerPage);

        return new AddNewProductPage(driver);
    }

}





