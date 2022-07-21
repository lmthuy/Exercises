package BaiTap4;


import common.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;





public class Ex4_AddProduct extends BaseTest {
   /* @Test(priority = 1, description = "Login Ecommerce Page")
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
*/
    @Test(priority = 1, description = "Add New Product")
    public void AddProduct() throws InterruptedException {

        driver.findElement(By.xpath("//span[normalize-space()='Add New Product']")).click();
        Thread.sleep(5000);

        //Feature and Deal
        driver.findElement(By.xpath("(//span[position()=1])[82]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[position()=1])[83]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Choose Flash Title']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Flash Deal']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='flash_discount']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='flash_discount']")).sendKeys("10");
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@title='Choose Discount Type']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[normalize-space()='Percent']")).click();
        Thread.sleep(1000);

        //Product Information
        driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys("Acer Nitro 5");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title='Computer & Accessories']")).click();
        Thread.sleep(2000);
        WebElement Category = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"));
        Category.sendKeys("Laptop Gaming");
        Thread.sleep(2000);
        Category.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[contains(text(),'Select Brand')]")).click();
        Thread.sleep(2000);
        WebElement Brand = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"));
        Brand.sendKeys("Microsoft");
        Thread.sleep(2000);
        Brand.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']")).sendKeys("1");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[@role='textbox']")).sendKeys("Nitro 5");
        Thread.sleep(1000);

        //Product Images
        driver.findElement(By.xpath("//div[@data-multiple='true']//div[@class='form-control file-amount'][normalize-space()='Choose File']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='acer nitro 5.jpg']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[contains(text(),'Choose File')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='aiz-file-box']//div[@title='feature.jpg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(3000);

        //Product Videos
        driver.findElement(By.xpath("//input[@placeholder='Video Link']")).sendKeys("https://www.youtube.com/watch?v=vwYbI8c2Rsc");
        Thread.sleep(2000);

        WebElement color = driver.findElement(By.xpath("//div[@class='col-md-1']//span"));
        Actions action = new Actions(driver);
        action.click(color).build().perform();
        Thread.sleep(2000);


        //Product Variation
        driver.findElement(By.xpath("(//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='text']//span//span[contains(text(),'DarkGreen')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='text']//span//span[contains(text(),'DarkSlateBlue')]")).click();
        Thread.sleep(2000);
        WebElement color1 = driver.findElement(By.xpath("//span[contains(text(),'DarkGreen')]"));
        WebElement color2 = driver.findElement(By.xpath("//span[contains(text(),'DarkSlateBlue')]"));
        color1.getText();
        Thread.sleep(2000);
        color2.getText();
        Thread.sleep(2000);
        System.out.println("*** Checking Color ***");
        Assert.assertEquals(color1.getText(), "DarkGreen", "False Selected Color");
        Assert.assertEquals(color2.getText(), "DarkSlateBlue", "False Selected Color");



        //Product price + stock
        driver.findElement(By.xpath("//input[@placeholder='Unit price']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Unit price']")).sendKeys("250");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Select Date']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='drp-calendar left']//div[@class='calendar-table']//td[.='21']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//select[@class='hourselect']//option[@value='8'][normalize-space()='8']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='drp-calendar left']//div[@class='calendar-table']//td[.='31']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Discount']")).clear();
        Thread.sleep(200);
        driver.findElement(By.xpath("//input[@placeholder='Discount']")).sendKeys("25");
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='col-md-3']//button[@title='Flat']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[normalize-space()='Percent']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='price_DarkGreen']")).clear();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//input[@name='price_DarkGreen']")).sendKeys("250");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='sku_DarkGreen']")).sendKeys("ABC256");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='qty_DarkGreen']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='qty_DarkGreen']")).sendKeys("5");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='price_DarkSlateBlue']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='price_DarkSlateBlue']")).sendKeys("300");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='sku_DarkSlateBlue']")).sendKeys("ABC256");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='qty_DarkSlateBlue']")).clear();
        Thread.sleep(100);
        driver.findElement(By.xpath("//input[@name='qty_DarkSlateBlue']")).sendKeys("3");
        Thread.sleep(500);

        //Product Description
        driver.findElement(By.xpath("//button[@aria-label='Link (CTRL+K)']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//label[normalize-space()='Text to display']/following-sibling::input")).sendKeys("Testing");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[normalize-space()='To what URL should this link go?']/following-sibling::input")).sendKeys("https://anhtester.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@aria-label='Open in new window']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Insert Link']")).click();
        Thread.sleep(500);
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
        driver.findElement(By.xpath("//div[@data-type='document']//div[@class='form-control file-amount'][normalize-space()='Choose File']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@title='Description.pdf']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

        //SEO Meta Tags
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Automation Testing");
        Thread.sleep(500);
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys(" Nice design; support USB-C; decent hardware; nice performance");
        Thread.sleep(500);

        //Estimate Shipping Time
        driver.findElement(By.xpath("//input[@placeholder='Shipping Days']")).sendKeys("4");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Tax']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Tax']")).sendKeys("3");
        Thread.sleep(500);
        driver.findElement(By.xpath("(//div[@class='form-group col-md-6'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        Thread.sleep(1000);

        //SAVE
        driver.findElement(By.xpath("//button[normalize-space()='Save & Publish']")).click();
        Thread.sleep(2000);
        WebElement addProduct = driver.findElement(By.xpath("//span[@data-notify='message']"));
        addProduct.getText();
        Thread.sleep(1500);
        Assert.assertEquals(addProduct.getText(), "Product has been inserted successfully", "Add Procduct không thành công");

        //Check New Product
        WebElement NewProduct = driver.findElement(By.xpath("//input[@id='search']"));
        NewProduct.sendKeys("Acer Nitro 5");
        Thread.sleep(500);
        NewProduct.sendKeys(Keys.ENTER);
        Thread.sleep(500);

        WebElement checkNewProduct = driver.findElement(By.xpath("//span[contains(normalize-space(),'Acer Nitro 5')]"));
        checkNewProduct.getText();
        Thread.sleep(5000);
        Assert.assertEquals(checkNewProduct.getText(), "Acer Nitro 5", "New Product chưa được add");



    }
}




