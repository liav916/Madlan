package Tests;

import PageObjects.BasePage;
import PageObjects.HomePage;
import org.json.simple.parser.ParseException;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class printAdvertisement extends BaseTest {


    @Test
    public void test01getAdvertisement () throws InterruptedException {
//driver.get("https://www.madlan.co.il/");
driver.get("https://www.madlan.co.il/for-sale/%D7%A9%D7%93%D7%A8%D7%95%D7%AA-%D7%99%D7%A9%D7%A8%D7%90%D7%9C?tracking_search_source=new_search&marketplace=residential");
homePage.getAllPostInfo();
   }}