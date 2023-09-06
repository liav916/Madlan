package PageObjects;
import Tests.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BasePage
{ WebDriver driver;
    WebDriver driver1;
    BaseTest BaseTest;
     String mainWindowHandle;


    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        BaseTest=new BaseTest();
        this.driver1 = driver;
    }
    public  void click(By elementLocation) {
        waitForElement(elementLocation);
        driver.findElement(elementLocation).click();
    }
    public void sendKeys(By elementLocation, String text) {

        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);
    }
    public void scrollToAndClickElement(WebElement element) {

            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();

        }

    public  void waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void Waitviseblity(By by) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException o) {
            o.printStackTrace();
        }

    }




}
