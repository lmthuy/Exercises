package BaiTap4;
/*

import projectmaven.utils.WebUI;
import common.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Ex4_AddProduct extends BaseTest {
    @Test(priority = 1, description = "Login Ecommerce Page")
    public static void Login() throws InterruptedException {
        driver.get("https://ecommerce.anhtester.com/users/login");
        Thread.sleep(1500);

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/button")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("thuy.le030799@gmail.com");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);

    }

    @Test(priority = 2, description = "Add New Product")
    public void AddProduct() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Products']"));

        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Add New Product']"));

        //Feature and Deal
        WebUI.clickElement(driver, By.xpath("(//span[position()=1])[82]"));
        WebUI.clickElement(driver, By.xpath("(//span[position()=1])[83]"));
        WebUI.clickElement(driver, By.xpath("//button[@title='Choose Flash Title']"));
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Flash Deal']"));
        WebUI.clearInfor(driver, By.xpath("//input[@name='flash_discount']"));
        WebUI.setText(driver, By.xpath("//input[@name='flash_discount']"), "10");
        WebUI.clickElement(driver, By.xpath("//button[@title='Choose Discount Type']"));
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Percent']"));

        //Product Information
        WebUI.setText(driver, By.xpath("//input[@placeholder='Product Name']"), "Acer Nitro 5");
        WebUI.clickElement(driver, By.xpath("//button[@title='Computer & Accessories']"));
        WebElement Category = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"));
        Category.sendKeys("Laptop Gaming");
        Category.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        WebUI.clickElement(driver, By.xpath("//div[contains(text(),'Select Brand')]"));
        WebElement Brand = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"));
        Brand.sendKeys("Microsoft");
        Brand.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        WebUI.setText(driver, By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']"), "1");
        WebUI.setText(driver, By.xpath("//span[@role='textbox']"), "Nitro 5");

        //Product Images
        WebUI.clickElement(driver, By.xpath("//div[@data-multiple='true']//div[@class='form-control file-amount'][normalize-space()='Choose File']"));
        WebUI.clickElement(driver, By.xpath("//div[@title='acer nitro 5.jpg']"));
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Add Files']"));
        WebUI.clickElement(driver, By.xpath("//body/div[@class='aiz-main-wrapper']/div[@class='aiz-content-wrapper']/div[@class='aiz-main-content']/div[@class='px-15px px-lg-25px']/div/form[@id='choice_form']/div[@class='row gutters-5']/div[@class='col-lg-8']/div[@class='card']/div[@class='card-body']/div[2]/div[1]/div[1]/div[2]"));
        WebUI.clickElement(driver, By.xpath("//div[@class='aiz-file-box']//div[@title='feature.jpg']"));
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Add Files']"));

        //Product Videos
        WebUI.setText(driver, By.xpath("//input[@placeholder='Video Link']"), "https://www.youtube.com/watch?v=vwYbI8c2Rsc");

        //Product Variation
        WebElement color = driver.findElement(By.xpath("//div[@class='col-md-1']//span"));
        Actions action = new Actions(driver);
        action.click(color).build().perform();
        Thread.sleep(1000);
        WebUI.clickElement(driver, By.xpath("(//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected'])[1]"));
        WebUI.clickElement(driver, By.xpath("//span[@class='text']//span//span[contains(text(),'DarkGreen')]"));
        WebUI.clickElement(driver, By.xpath("//span[@class='text']//span//span[contains(text(),'DarkSlateBlue')]"));
        WebElement color1 = driver.findElement(By.xpath("//span[contains(text(),'DarkGreen')]"));
        WebElement color2 = driver.findElement(By.xpath("//span[contains(text(),'DarkSlateBlue')]"));
        System.out.println("*** Checking Color ***");
        Assert.assertEquals(color1.getText(), "DarkGreen", "False Selected Color");
        Assert.assertEquals(color2.getText(), "DarkSlateBlue", "False Selected Color");

        //Product price + stock
        WebUI.clearInfor(driver, By.xpath("//input[@placeholder='Unit price']"));
        WebUI.setText(driver, By.xpath("//input[@placeholder='Unit price']"), "250");
        WebUI.clickElement(driver, By.xpath("//input[@placeholder='Select Date']"));
        WebUI.clickElement(driver, By.xpath("//div[@class='drp-calendar left']//div[@class='calendar-table']//td[.='21']"));
        WebUI.clickElement(driver, By.xpath("//select[@class='hourselect']//option[@value='8'][normalize-space()='8']"));
        WebUI.clickElement(driver, By.xpath("//div[@class='drp-calendar left']//div[@class='calendar-table']//td[.='31']"));
        WebUI.clickElement(driver, By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']"));
        WebUI.clearInfor(driver, By.xpath("//input[@placeholder='Discount']"));
        WebUI.setText(driver, By.xpath("//input[@placeholder='Discount']"), "25");
        WebUI.clickElement(driver, By.xpath("//div[@class='col-md-3']//button[@title='Flat']"));
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Percent']"));
        WebUI.clearInfor(driver, By.xpath("//input[@name='price_DarkGreen']"));
        WebUI.setText(driver, By.xpath("//input[@name='price_DarkGreen']"), "250");
        WebUI.setText(driver, By.xpath("//input[@name='sku_DarkGreen']"), "ABC456");
        WebUI.clearInfor(driver, By.xpath("//input[@name='qty_DarkGreen']"));
        WebUI.setText(driver, By.xpath("//input[@name='qty_DarkGreen']"), "5");
        WebUI.clearInfor(driver, By.xpath("//input[@name='price_DarkSlateBlue']"));
        WebUI.setText(driver, By.xpath("//input[@name='price_DarkSlateBlue']"), "300");
        WebUI.setText(driver, By.xpath("//input[@name='sku_DarkSlateBlue']"), "ABC456");
        WebUI.clearInfor(driver, By.xpath("//input[@name='qty_DarkSlateBlue']"));
        WebUI.setText(driver, By.xpath("//input[@name='qty_DarkSlateBlue']"), "3");

        //Product Description
        WebUI.clickElement(driver, By.xpath("//button[@aria-label='Link (CTRL+K)']"));
        WebUI.setText(driver, By.xpath("//label[normalize-space()='Text to display']/following-sibling::input"), "Testing");
        WebUI.setText(driver, By.xpath("//label[normalize-space()='To what URL should this link go?']/following-sibling::input"), "https://anhtester.com");
        WebUI.clickElement(driver, By.xpath("//input[@aria-label='Open in new window']"));
        WebUI.clickElement(driver, By.xpath("//input[@value='Insert Link']"));
        WebElement enter = driver.findElement(By.xpath("//div[@role='textbox']"));
        enter.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        WebElement text = driver.findElement(By.xpath("//div[@role='textbox']"));
        text.sendKeys("Hi.Enjoy it.Thanks.");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL).sendKeys("b").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(2000);

        //PDF Specification
        WebUI.clickElement(driver, By.xpath("//div[@data-type='document']//div[@class='form-control file-amount'][normalize-space()='Choose File']"));
        WebUI.clickElement(driver, By.xpath("//div[@title='Description.pdf']"));
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Add Files']"));

        //SEO Meta Tags
        WebUI.setText(driver, By.xpath("//input[@placeholder='Meta Title']"),"Automation Testing");
        WebUI.setText(driver, By.xpath("//textarea[@name='meta_description']"), " Nice design; support USB-C; decent hardware; nice performance");

        //Estimate Shipping Time
        WebUI.setText(driver, By.xpath("//input[@placeholder='Shipping Days']"),"4");
        WebUI.clearInfor(driver, By.xpath("//input[@placeholder='Tax']"));
        WebUI.setText(driver, By.xpath("//input[@placeholder='Tax']"), "3");
        WebUI.clickElement(driver, By.xpath("(//div[@class='form-group col-md-6'])[2]"));
        WebUI.clickElement(driver, By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"));

        //SAVE
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Save & Publish']"));
        WebElement addProduct = driver.findElement(By.xpath("//span[@data-notify='message']"));
        System.out.println(addProduct.getText());
        Assert.assertEquals(addProduct.getText(), "Product has been inserted successfully", "Add Procduct không thành công");

        //Check New Product


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//input[@id='search']")));
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Acer Nitro 5");

        WebUI.elementToBeClickable(driver, By.xpath("//span[@class='text-muted text-truncate-2']"));
        String titleProduct = driver.findElement(By.xpath("//span[@class='text-muted text-truncate-2']")).getText();
        Assert.assertEquals(titleProduct, "Acer Nitro 5", "Sai tên Prodcut");


    }
}

/*
 WebElement NewProduct = driver.findElement(By.xpath("//input[@id='search']"));
        NewProduct.sendKeys("Acer Nitro 5");
        Thread.sleep(500);
        NewProduct.sendKeys(Keys.ENTER);
        Thread.sleep(500);

        WebElement checkNewProduct = driver.findElement(By.xpath("//span[contains(normalize-space(),'Acer Nitro 5')]"));
        checkNewProduct.getText();
        Thread.sleep(5000);
        Assert.assertEquals(checkNewProduct.getText(), "Acer Nitro 5", "New Product chưa được add");
 */