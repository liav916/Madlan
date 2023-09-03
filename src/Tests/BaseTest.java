package Tests;

import PageObjects.HomePage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;



public class BaseTest {
    static HomePage homePage;
    static WebDriver driver;


    @BeforeClass
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        //    options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--disable-blink-features=AutomationControlled");//Hcaptcha pass
        driver = new ChromeDriver(options);

        resetPage();

        driver.manage().window().maximize();
    }


    public static void resetPage() {
        homePage = new HomePage(driver);
    }


    @AfterClass
    public static void close() {
        //driver.close();
        //driver.quit();
    }}




//


