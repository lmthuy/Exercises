package BaiTap1;

/*import projectmaven.utils.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex1_2AddCategory extends BaseTest {
    @Test(priority = 1, description = "Login Ecommerce Page")
    public void Login() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://ecommerce.anhtester.com/users/login");

        WebUI.clickElement(driver, By.xpath("/html/body/div[2]/div[2]/div/button"));
        String expectedTitle = "AT eCommerce | Automation Testing eCommerce";
        String actualTitle = driver.getTitle();
        System.out.println("*** Checking For The Title ***");
        Assert.assertEquals(actualTitle, expectedTitle);
        WebUI.setText(driver, By.xpath("//input[@id='email']"), "thuy.le030799@gmail.com");
        WebUI.setText(driver, By.xpath("//input[@id='password']"), "123456");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

    }

    @Test(priority = 2, description = "Add New Category")
    public void AddCategory() throws InterruptedException {
        //Chọn menu Category
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Products']"));
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Category']"));
        WebUI.clickElement(driver,By.xpath("//span[normalize-space()='Add New category']"));
        
        //Thêm nội dung Category
        WebUI.setText(driver,By.xpath("//input[@id='name']"), "Laptop Gaming" );
        WebUI.clickElement(driver, By.xpath("//button[@title='No Parent']"));
        WebUI.setText(driver, By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"),"Computer & Accessories");
        WebUI.clickElement(driver, By.xpath("//ul[@role='presentation']//span[normalize-space()='Computer & Accessories']"));
        WebUI.setText(driver, By.xpath("//input[@id='order_level']"),"1");
        WebUI.clickElement(driver, By.xpath("//div[contains(text(),'Physical')]"));
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Digital']/parent::a[@role='option']"));
       

        WebElement Title_Banner = driver.findElement(By.xpath("(//label[@for='signinSrEmail'])[1]"));

        driver.findElement(By.xpath("(//div[@data-toggle='aizuploader'])[1]")).click();

        WebUI.clickElement(driver, By.xpath("(//span[@class='text-truncate title'][normalize-space()='pic'])[1]"));
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Add Files']"));
        WebUI.clickElement(driver, By.xpath("(//div[@data-toggle='aizuploader'])[2]"));
        WebUI.clickElement(driver, By.xpath("//div[@title='Nitro_Wallpaper_5000x2813.jpg']//div[@class='card-body']"));
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Add Files']"));
        WebUI.setText(driver, By.xpath("//input[@placeholder='Meta Title']"), "Testing");
        WebUI.setText(driver, By.xpath("//textarea[@name='meta_description']"), "Reign over the game world with the combined power of an AMD Ryzen™ 6000 Series processor1 and up to NVIDIA® GeForce RTX™ 3070 Ti graphics");
        WebUI.clickElement(driver, By.xpath("//div[contains(text(),'Nothing selected')]"));
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Size']/parent::a[@role='option']"));
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Save']"));

        WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
        Thread.sleep(2000);
        Assert.assertEquals(alert.getText(), "Category has been inserted successfully", "Checking done");
    }


    @Test(priority = 3, description = "Check Category")
    public void CheckCategory() throws InterruptedException {

        WebElement SearchCategory = driver.findElement(By.xpath("//input[@id='search']"));
        SearchCategory.sendKeys("Laptop Gaming");
        Thread.sleep(2000);
        SearchCategory.sendKeys(Keys.ENTER);

        WebUI.elementToBeClickable(driver, By.xpath("//td[normalize-space()='Laptop Gaming']"));
        String titleCategory = driver.findElement(By.xpath("//td[normalize-space()='Laptop Gaming']")).getText();
        Assert.assertEquals(titleCategory, "Laptop Gaming", "Sai tên Category");


    }
}





        /*WebElement text = driver.findElement(By.xpath("//td[normalize-space()='Laptop Gaming']"));
        Thread.sleep(2000);
        System.out.println(text.getText());
       
        if (text.getText().equals("Laptop Gaming")) {
            System.out.println("true");
        } else {
            System.out.println("false");


            driver.get("https://ecommerce.anhtester.com/admin/categories?search=");
        Thread.sleep(2000);
        WebElement SearchCategory = driver.findElement(By.xpath("//input[@id='search']"));
        SearchCategory.sendKeys("Laptop Gaming");
        Thread.sleep(2000);
        SearchCategory.sendKeys(Keys.ENTER);



        WebElement actualText = driver.findElement(By.xpath("//td[normalize-space()='Laptop Gaming']"));
        actualText.getText();
        Thread.sleep(7000);
        System.out.println("*** Checking For The Category ***");

        Assert.assertEquals(actualText.getText(), "Laptop Gaming", "Sai Category");
       */





