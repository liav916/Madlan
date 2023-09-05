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
    public void test01getAdvertisement ()  {
//driver.get("https://www.madlan.co.il/");
  driver.get("https://www.madlan.co.il/listings/jo0NfCcXLi9?dealType=sale&term=%D7%99%D7%A9%D7%A8%D7%90%D7%9C&tracking_event_source=list_regular_card&tracking_list_index=0&tracking_search_source=type_change");
        homePage.getAllPostInfo();
   }}