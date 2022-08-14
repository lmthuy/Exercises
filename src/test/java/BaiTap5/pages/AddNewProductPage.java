package BaiTap5.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import projectmaven.utils.WebUI;

public class AddNewProductPage {
    WebDriver driver;

    public AddNewProductPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    public By headerPage = By.xpath("//h5[normalize-space()='Add New Product']");
    //Feature and Deal
    private By addToFlash = By.xpath("//button[@title='Choose Flash Title']");
    private By chooseFlashTitle = By.xpath("//span[normalize-space()='Flash Deal']");
    private By discount = By.xpath("//input[@name='flash_discount']");
    private By discountType = By.xpath("//button[@title='Choose Discount Type']");
    private By chooseDiscountType = By.xpath("//span[normalize-space()='Percent']");
    //Product Information
    private By productName = By.xpath("//input[@placeholder='Product Name']");
    private By category = By.xpath("//button[@title='Computer & Accessories']");
    private By selectCategory = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By band = By.xpath("//div[contains(text(),'Select Brand')]");
    private By selectBand = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By inputUnit = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    private By inputTags = By.xpath("//span[@role='textbox']");
    //Product Images
    private By galleryImage = By.xpath("//div[@data-multiple='true']//div[@class='form-control file-amount'][normalize-space()='Choose File']");
    private By selectGalleryImage = By.xpath("//div[@title='acer nitro 5.jpg']");
    private By buttonAddFile = By.xpath("//button[normalize-space()='Add Files']");
    private By thumbnailImage = By.xpath("//body/div[@class='aiz-main-wrapper']/div[@class='aiz-content-wrapper']/div[@class='aiz-main-content']/div[@class='px-15px px-lg-25px']/div/form[@id='choice_form']/div[@class='row gutters-5']/div[@class='col-lg-8']/div[@class='card']/div[@class='card-body']/div[2]/div[1]/div[1]/div[2]");
    private By selectThumnailImage = By.xpath("//div[@class='aiz-file-box']//div[@title='feature.jpg']");
    //Product Videos
    private By inputProductVideo = By.xpath("//input[@placeholder='Video Link']");
    //Product Variation
    private By colors = By.xpath("(//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected'])[1]");
    private By selectColor1 = By.xpath("//span[@class='text']//span//span[contains(text(),'DarkGreen')]");
    private By selectColor2 = By.xpath("//span[@class='text']//span//span[contains(text(),'DarkSlateBlue')]");
    //ProductPricesAndStock
    private By inputUnitPrice = By.xpath("//input[@placeholder='Unit price']");
    private By inputDiscount = By.xpath("//input[@placeholder='Discount']");
    //Product Description
    private By inputDescription = By.xpath("//div[@role='textbox']");
    //PDF Specification
    private By pdfSpec = By.xpath("//div[@data-type='document']//div[@class='form-control file-amount'][normalize-space()='Choose File']");
    private By selectPDF = By.xpath("//div[@title='Description.pdf']");
    private By addFiles = By.xpath("//button[normalize-space()='Add Files']");
    //Estimate Shipping Time
    private By shippingDays = By.xpath("//input[@placeholder='Shipping Days']");
    private By vatAndTax = By.xpath("//input[@placeholder='Tax']");
    //Save Product
    private By buttonSave = By.xpath("//button[normalize-space()='Save & Publish']");
    //Title Product
    private By searchProduct = By.xpath("//input[@id='search']");
    private By titleProduct = By.xpath("//span[@class='text-muted text-truncate-2']");


    public void inputFeatureandDeal() {
        WebUI.sleep(3);
        driver.findElement(By.xpath("(//span[position()=1])[82]")).click();
        driver.findElement(By.xpath("(//span[position()=1])[83]")).click();
        WebUI.clickElement(addToFlash);
        WebUI.clickElement(chooseFlashTitle);
        WebUI.clearInfor(discount);
        WebUI.setText(discount, "5");
        WebUI.clickElement(discountType);
        WebUI.clickElement(chooseDiscountType);
    }

    public void inputProductInfor() {
        //Product Information
        WebUI.setText(productName, "Acer Nitro 5");
        WebUI.clickElement(category);
        WebUI.clickElement(selectCategory);
        driver.findElement(selectCategory).sendKeys("Laptop Gaming");
        driver.findElement(selectCategory).sendKeys(Keys.ENTER);
        WebUI.clickElement(band);
        driver.findElement(selectBand).sendKeys("Microsoft");
        driver.findElement(selectBand).sendKeys(Keys.ENTER);
        WebUI.setText(inputUnit, "1");
        WebUI.setText(inputTags, "Nitro 5");
    }

    public void inputProductImages() {
        //Product Images
        WebUI.clickElement(galleryImage);
        WebUI.clickElement(selectGalleryImage);
        WebUI.clickElement(buttonAddFile);
        WebUI.clickElement(thumbnailImage);
        WebUI.clickElement(selectThumnailImage);
        WebUI.clickElement(buttonAddFile);
    }

    public void inputProductVideo() {
        WebUI.setText(inputProductVideo, "https://www.youtube.com/watch?v=vwYbI8c2Rsc");
    }

    public void inputProductVariation() {
        driver.findElement(By.xpath("//div[@class='col-md-1']//span")).click();
        WebUI.clickElement(colors);
        WebUI.clickElement(selectColor1);
        WebUI.clickElement(selectColor2);
        boolean checkColor1 = WebUI.checkElementExist(By.xpath("//span[contains(text(),'DarkGreen')]"));
        boolean checkColor2 = WebUI.checkElementExist(By.xpath("//span[contains(text(),'DarkSlateBlue')]"));
        System.out.println("*** Checking Color ***");
        Assert.assertTrue(checkColor1, "Fail. Not found color");
        Assert.assertTrue(checkColor2, "Not found color");
    }

    public void inputProductPricesAndStock() {
        WebUI.clearInfor(inputUnitPrice);
        WebUI.setText(inputUnitPrice, "250");

        driver.findElement(By.xpath("//input[@placeholder='Select Date']")).click();
        driver.findElement(By.xpath("//div[@class='drp-calendar left']//div[@class='calendar-table']//td[.='22']")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//div[@class='drp-calendar left']//div[@class='calendar-table']//td[.='30']")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//select[@class='hourselect']//option[@value='8'][normalize-space()='8']")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']")).click();

        WebUI.clearInfor(inputDiscount);
        WebUI.setText(inputDiscount, "25");
        driver.findElement(By.xpath("//div[@class='col-md-3']//button[@title='Flat']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Percent']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@name='price_DarkGreen']")).clear();
        driver.findElement(By.xpath("//input[@name='price_DarkGreen']")).sendKeys("250");
        driver.findElement(By.xpath("//input[@name='sku_DarkGreen']")).sendKeys("ABC123");
        driver.findElement(By.xpath("//input[@name='qty_DarkGreen']")).clear();
        driver.findElement(By.xpath("//input[@name='qty_DarkGreen']")).sendKeys("5");
        driver.findElement(By.xpath("//input[@name='price_DarkSlateBlue']")).clear();
        driver.findElement(By.xpath("//input[@name='price_DarkSlateBlue']")).sendKeys("300");
        driver.findElement(By.xpath("//input[@name='sku_DarkSlateBlue']")).sendKeys("ABC456");
        driver.findElement(By.xpath("//input[@name='qty_DarkSlateBlue']")).clear();
        driver.findElement(By.xpath("//input[@name='qty_DarkSlateBlue']")).sendKeys("5");
    }

    public void inputProductDescription() {
        WebUI.setText(inputDescription, "Hi. Enjoy it. Thanks!");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("b").keyUp(Keys.CONTROL).build().perform();
    }

    public void inputPDFSpecification() {
        WebUI.clickElement(pdfSpec);
        WebUI.clickElement(selectPDF);
        WebUI.clickElement(addFiles);
        WebUI.sleep(2);
    }

    public void inputSEOMeta() {
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Acer Nitro 5");
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Nice design; support USB-C; decent hardware; nice performance");
    }

    public void shippingTimeAndVat() {
        WebUI.setText(shippingDays, "4");
        WebUI.clearInfor(vatAndTax);
        WebUI.setText(vatAndTax, "3");
        driver.findElement(By.xpath("(//div[@class='form-group col-md-6'])[2]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
    }

    public void saveProduct() {
        WebUI.clickElement(buttonSave);
        WebElement addProduct = driver.findElement(By.xpath("//span[@data-notify='message']"));
        Assert.assertEquals(addProduct.getText(), "Product has been inserted successfully", "Fail to add new product");
    }
    public void checkNewProdcuct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//input[@id='search']")));
        WebUI.setText(searchProduct,"Acer Nitro 5");
        driver.findElement(searchProduct).sendKeys(Keys.ENTER);
        Assert.assertEquals(WebUI.getElementText(titleProduct), "Acer Nitro 5", "Not found new product");
        WebUI.sleep(2);

    }


    public void addProduct() {
        inputFeatureandDeal();
        inputProductInfor();
        inputProductImages();
        inputProductVideo();
        inputProductVariation();
        inputProductPricesAndStock();
        inputProductDescription();
        inputPDFSpecification();
        inputSEOMeta();
        shippingTimeAndVat();
        saveProduct();
        checkNewProdcuct();

    }
}
