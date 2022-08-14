package BaiTap5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import projectmaven.utils.WebUI;

public class CategoryPage {

    WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    public By headerPage = By.xpath("//h5[normalize-space()='Categories']");
    private By addNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By inputName = By.xpath("//input[@id='name']");
    private By parentCategory = By.xpath("//button[@title='No Parent']");
    private By inputParentCategory = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
    private By banner = By.xpath("//div[5]//div[1]//div[1]//div[2]");
    private By picBanner = By.xpath("//div[@title='Nitro_Wallpaper_5000x2813.jpg']");
    private By buttonAddFile = By.xpath("//button[normalize-space()='Add Files']");
    private By icon = By.xpath("//label[text()='Icon ']/following-sibling::div");
    private By picIcon = By.xpath("//div[@title='acer nitro 5.jpg']");
    private By metaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By metaDescription = By.xpath("//textarea[@name='meta_description']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");
    private By buttonSearch = By.xpath("//input[@id='search']");
    private By nameCategory =  By.xpath("//tbody/tr[1]/td[2]");


    public void clickAddNewCategory() {
        WebUI.clickElement(addNewCategory);
    }

    public void inputDataCategory() {
        WebUI.setText(inputName, "Laptop Gaming");
        WebUI.clickElement(parentCategory);
        WebUI.setText(inputParentCategory, "Computer & Accessories");
        driver.findElement(inputParentCategory).sendKeys(Keys.ENTER);
        WebUI.setText(inputOrderingNumber, "1");
        WebUI.clickElement(banner);
        WebUI.clickElement(picBanner);
        WebUI.clickElement(buttonAddFile);
        WebUI.clickElement(icon);
        WebUI.clickElement(picIcon);
        WebUI.clickElement(buttonAddFile);
        WebUI.setText(metaTitle, "Testing");
        WebUI.setText(metaDescription, "Reign over the game world with the combined power of an AMD Ryzen™ 6000 Series processor1 and up to NVIDIA® GeForce RTX™ 3070 Ti graphics");
        WebUI.clickElement(buttonSave);

    }
    public void checkCategory(){
        WebUI.setText(buttonSearch,"Laptop Gaming");
        driver.findElement(buttonSearch).sendKeys(Keys.ENTER);

        Assert.assertEquals(WebUI.getElementText(nameCategory),"Laptop Gaming","Failed. Not found Category");
        WebUI.sleep(1);
    }


}
