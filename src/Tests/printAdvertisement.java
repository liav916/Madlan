package Tests;

import PageObjects.BasePage;
import PageObjects.HomePage;
import org.json.simple.parser.ParseException;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.IOException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class printAdvertisement extends BaseTest {


    @Test
    public void test01getAdvertisement () throws InterruptedException {
driver.get("https://www.madlan.co.il/");
homePage.clickoncatgory();
homePage.insertValue();
homePage.getAllPostInfo();}
        @Test
        public void test02getAdvertisement () throws InterruptedException, IOException, AWTException {
            driver.get("https://www.madlan.co.il/listings/gVeifNBAsCG?sort=priceEstimation-asc&tracking_event_source=homepage_persona&tracking_list_index=2&tracking_search_source=homepage_persona");
            homePage.captchaBypass();
        }
   }