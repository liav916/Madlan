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
driver.get("https://www.madlan.co.il/");
homePage.clickoncatgory();
homePage.insertValue();
homePage.getAllPostInfo();
   }}