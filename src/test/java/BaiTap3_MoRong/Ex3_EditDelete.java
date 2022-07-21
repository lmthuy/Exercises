package BaiTap3_MoRong;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex3_EditDelete extends BaseTest {
    @Test(priority = 1, description = "Login Ecommerce Page")
    public void Login() throws InterruptedException {
        driver.get("https://ecommerce.anhtester.com/users/login");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("thuy.le030799@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Edit & Delete Category")
    public void CheckCategory() throws InterruptedException {
        driver.get("https://ecommerce.anhtester.com/admin/categories?search=");
        Thread.sleep(2000);
        WebElement SearchCategory = driver.findElement(By.xpath("//input[@id='search']"));
        SearchCategory.sendKeys("Laptop Gaming");
        Thread.sleep(2000);
        SearchCategory.sendKeys(Keys.ENTER);



        driver.findElement(By.xpath("(//a[contains(@title,'Edit')])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Acer Nitro 5");


        driver.findElement(By.xpath("(//div[@data-toggle='aizuploader'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@title='acer nitro 5.jpg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(1000);

        Thread.sleep(1000);
        WebElement alert = driver.findElement(By.xpath("//span[@data-notify='message']"));
        Assert.assertEquals(alert.getText(), "Category has been updated successfully", "Checking done");


        driver.get("https://ecommerce.anhtester.com/admin/categories?search=");
        Thread.sleep(2000);
        WebElement Search = driver.findElement(By.xpath("//input[@id='search']"));
        Search.sendKeys("Acer Nitro 5");
        Thread.sleep(1000);
        Search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement actualText = driver.findElement(By.xpath("//td[normalize-space()='Acer Nitro 5']"));
        actualText.getText();
        Thread.sleep(10000);
        System.out.println("*** Checking For The Category ***");
        Assert.assertEquals(actualText.getText(), "Acer Nitro 5", "Sai Category");
        Thread.sleep(3000);


        WebElement SearchLaptop = driver.findElement(By.xpath("//input[@id='search']"));
        SearchLaptop.clear();
        Thread.sleep(500);
        SearchLaptop.sendKeys("Laptop Gaming");
        Thread.sleep(2000);
        SearchLaptop.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[contains(@title,'Delete')])[1]")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//a[@id='delete-link']")).click();
        Thread.sleep(2000);
        WebElement Search_2 = driver.findElement(By.xpath("//input[@id='search']"));
        Search_2.sendKeys("Laptop Gaming");
        Thread.sleep(2000);
        Search_2.sendKeys(Keys.ENTER);
        WebElement actualtext = driver.findElement(By.xpath("//td[normalize-space()='Nothing found']"));
        actualtext.getText();
        Thread.sleep(10000);
        System.out.println("*** Checking For The Category ***");
        Assert.assertEquals(actualtext.getText(), "Nothing found", "Chưa xóa Category");


    }
}

