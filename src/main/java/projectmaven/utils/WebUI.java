package projectmaven.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WebUI {
    private static int TIMEOUT = 10;
    private static int STEP_TIME = 0;

    private static WebDriver driver;

    public WebUI(WebDriver driver) {
        WebUI.driver = driver;
    }

    public static void sleep(long second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void logConsole(Object message) {
        System.out.println(message);
    }
    public static void clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        driver.findElement(by).click();
    }
        public static Boolean checkElementExist (By by) {
            sleep(2);
            List<WebElement> listElement = driver.findElements(by);
            if (listElement.size() > 0) {
                System.out.println("checkElementExist:" + true + "-----" + by);
                return true;
            } else {
                System.out.println("checkElementExist:" + true + "-----" + by);
                return false;
            }
        }
    public static void openURL(String url) {
        driver.get(url);
        sleep(STEP_TIME);
        logConsole("Open: " + url);
    }
        public static void setText (By by, String value){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            sleep(STEP_TIME);
            driver.findElement(by).sendKeys(value);
            logConsole("Set text: " + value + " on element " + by);
        }
        public static void elementToBeClickable (By by){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            sleep(STEP_TIME);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }
        public static void clearInfor (By by){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            sleep(STEP_TIME);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            driver.findElement(by).clear();
        }
    public static String getElementText(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        String text = driver.findElement(by).getText();
        logConsole("Get text: " + text);
        return text; //Trả về một giá trị kiểu String
    }
    }

