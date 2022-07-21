package BaiTap1;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ex1_2AddCategory extends BaseTest {
    @Test(priority = 1, description = "Login Ecommerce Page")
    public void Login() throws InterruptedException {
        driver.get("https://ecommerce.anhtester.com/users/login");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/button")).click();
        Thread.sleep(1000);
        String expectedTitle = "AT eCommerce | Automation Testing eCommerce";
        String actualTitle = driver.getTitle();
        System.out.println("*** Checking For The Title ***");
        Assert.assertEquals(actualTitle, expectedTitle);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("thuy.le030799@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);

    }

    @Test(priority = 2, description = "Add New Category")
    public void AddCategory() throws InterruptedException {
        //Chọn menu Category

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        Thread.sleep(500);

        //Thêm nội dung Category
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Laptop Gaming");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@title='No Parent']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Computer & Accessories");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@role='presentation']//span[normalize-space()='Computer & Accessories']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("1");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[contains(text(),'Physical')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Digital']/parent::a[@role='option']")).click();
        Thread.sleep(1000);

        WebElement Title_Banner = driver.findElement(By.xpath("(//label[@for='signinSrEmail'])[1]"));
        Assert.assertEquals(Title_Banner.getText(), "Banner (200x200)");
        driver.findElement(By.xpath("(//div[@data-toggle='aizuploader'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class='text-truncate title'][normalize-space()='pic'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(500);

        WebElement Title_Icon = driver.findElement(By.xpath("(//label[@for='signinSrEmail'])[2]"));
        Assert.assertEquals(Title_Icon.getText(), "Icon (32x32)");
        driver.findElement(By.xpath("(//div[@data-toggle='aizuploader'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='Nitro_Wallpaper_5000x2813.jpg']//div[@class='card-body']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Testing");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Reign over the game world with the combined power of an AMD Ryzen™ 6000 Series processor1 and up to NVIDIA® GeForce RTX™ 3070 Ti graphics");
        Thread.sleep(1500);


        driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Size']/parent::a[@role='option']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(1000);

        Thread.sleep(1000);
        WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alert.getText(), "Category has been inserted successfully", "Checking done");


    }


    @Test(priority = 3, description = "Check Category")
    public void CheckCategory() throws InterruptedException {

        driver.get("https://ecommerce.anhtester.com/admin/categories?search=");
        Thread.sleep(2000);
        WebElement SearchCategory = driver.findElement(By.xpath("//input[@id='search']"));
        SearchCategory.sendKeys("Laptop Gaming");
        Thread.sleep(2000);
        SearchCategory.sendKeys(Keys.ENTER);
        Thread.sleep(1000);


        WebElement actualText = driver.findElement(By.xpath("//td[normalize-space()='Laptop Gaming']"));
        actualText.getText();
        Thread.sleep(7000);
        System.out.println("*** Checking For The Category ***");

       Assert.assertEquals(actualText.getText(),"Laptop Gaming","Sai Category");

    }
}





        /*WebElement text = driver.findElement(By.xpath("//td[normalize-space()='Laptop Gaming']"));
        Thread.sleep(2000);
        System.out.println(text.getText());
        Thread.sleep(1000);
        if (text.getText().equals("Laptop Gaming")) {
            System.out.println("true");
        } else {
            System.out.println("false");
       */





