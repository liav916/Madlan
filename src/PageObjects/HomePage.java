package PageObjects;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.JavascriptExecutor;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {

    String active = "css-1p1vgp0 elkstcv0";
    String inactive = "css-tc23vv elkstcv0";
    String JsonPath = "C:\\Users\\liav\\IdeaProjects\\Madlan\\src\\Data\\israel_cities.json";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    String city = "שדרות";
    By searchField = By.cssSelector("[class='multi-search-input-wrapper css-ixz1sj ealzp4l9']");
    By arrowElement = By.cssSelector("data-auto='bulletins-pagination-2'");
    By Title = By.cssSelector("[data-auto='primary_address_text']");
    By header = By.cssSelector("[data-auto='desktop-header-wrapper']");
    By SubTitle = By.cssSelector("[data-auto='secondary_address_text']");
    By Price = By.cssSelector("[data-auto='current-price']");
    By Info = By.cssSelector("[class='css-v1qjdi ebqee3y2']");
    By postImage = By.cssSelector("[class='css-1526ib8 e1r3dysu15']");
    By postPhone = By.cssSelector("[data-auto='phone-number-button']");
    By postSeller = By.cssSelector("[data-auto='poc-name']");
    By postbackArrow = By.cssSelector("[data-auto='sub-menu-back-button'] a");
    //[data-auto='back-button-text']
    By searchElementField = By.cssSelector("[data-auto='autocomplete-textfield']");
    By test = By.cssSelector(".universal-card-body-wrapper.css-79elbk.e1sx3tzs15");

    By Ad = By.cssSelector("[data-auto='modal-popup']");
    By nextPageArrow = By.cssSelector("[class='css-qkpft0']");
    By captcha = By.cssSelector("[id='content']");


    public void clickOnSearchField() {
        waitForElement(searchField);
        WebElement searchField1 = driver.findElement(searchField);
        scrollToAndClickElement(searchField1);
    }
    public String searchForCity(String city) throws InterruptedException {
        String name = null;
        WebElement searchElement = driver.findElement(searchElementField);
        Thread.sleep(2000);
        captchaBypass();
        searchElement.sendKeys(city);
        captchaBypass();
        clickOnSearchField();
        By CityFieldDropDown = By.cssSelector("[data-auto='autocomplete-suggestion']");
        waitForElement(CityFieldDropDown);
        List<WebElement> list = driver.findElements(CityFieldDropDown);

        for (int i = 0; i < list.size(); i++) {
            name = list.get(i).getText();
            if (name.contains(city) && name.contains("עיר"))
                (list.get(i)).click();
            captchaBypass();


        }

        return name;
    }
    public void captchaBypass() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement shadowHost = driver.findElement(captcha);
        if (shadowHost.isDisplayed()) {
            Actions act = new Actions(driver);
            act.doubleClick(shadowHost).perform();
            Thread.sleep(2000);
            act.sendKeys(Keys.TAB).perform();
            Thread.sleep(5000);
            act.keyDown(Keys.ENTER).perform();
            Thread.sleep(10000);
            act.keyUp(Keys.ENTER).perform();
            Thread.sleep(5000);
            captchaBypass();
        } }catch (TimeoutException e){}catch (NoSuchElementException e ){}

}
    public void getAllPostInfo() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        waitForElement(test);
        List<WebElement> posts = driver.findElements(By.cssSelector(".universal-card-body-wrapper.css-79elbk.e1sx3tzs15 [data-auto=\"property-details\"]"));//50
        js.executeScript("window.scrollTo(0, 0);");
        for (int i=0; i<=posts.size(); i++){
            waitForElement(test);
            posts = driver.findElements(By.cssSelector(".universal-card-body-wrapper.css-79elbk.e1sx3tzs15 [data-auto=\"property-details\"]"));//50
            WebElement post =  posts.get(i);
            String post1 =  posts.get(i).getText();
            if (post1.contains("₪")){
            Thread.sleep(2000);
            post.click();
            getpostInfo();
            blockAds();
            Thread.sleep(2000);
            click(postbackArrow);}

            }clickOnNextPage();

        }
    public void blockAds(){

        try{  waitForElement(Ad);
       //  if (driver.findElement(add).isDisplayed()){
                By xButton = By.cssSelector("div [data-auto='modal-close-button']");
                click(xButton);} catch (TimeoutException e){}
    } // Done modal
    public void clickoncatgory () throws InterruptedException {//waiting for all header to load
     try{   waitForElement(header);} catch (TimeoutException e){captchaBypass();}
        //catch all header catagorys
        List<WebElement> element = driver.findElements(By.cssSelector("[class='tab-link']"));
        //catch only the catgory i want to press on
        WebElement catgory = element.get(0);
        // click on the catgory
        catgory.click();
    } //Done
   public void getpostInfo () {


       getTitle(Title);
       getSubtitle();
           getPrice();
           getparagraph();
           getPhoneAndSeller();
           getGallery();
           getBoolean();
           blockAds();

       }
    public String getTitle(By by){

        String title;
try {blockAds();
        waitForElement(by); // Make sure this method correctly waits for the element
        WebElement element = driver.findElement(by); // Assuming 'driver' is your WebDriver instance
         title = element.getText();
System.out.println(title);}catch (TimeoutException e){System.out.println("project"); title="project";
}
    return title;} //Done
   public void getSubtitle () {
       blockAds();
        waitForElement(SubTitle); // Make sure this method correctly waits for the element
        WebElement element = driver.findElement(SubTitle); // Assuming 'driver' is your WebDriver instance
        String subtitle = element.getText();
        System.out.println(subtitle);}
    public void getPrice () {
        blockAds();
        waitForElement(Price); // Make sure this method correctly waits for the element
        WebElement element = driver.findElement(Price); // Assuming 'driver' is your WebDriver instance
        String price = element.getText();
       System.out.println(price);
    }
    public void getparagraph() {
        blockAds();
     try  { waitForElement(Info); // Make sure this method correctly waits for the element
        WebElement element = driver.findElement(Info); // Assuming 'driver' is your WebDriver instance
        String info = element.getText();
        System.out.println(info);} catch (TimeoutException e) {System.out.println("no info on this post");}
    }
    public void getPhoneAndSeller() {
        blockAds();
        waitForElement(postPhone);
        WebElement phoneelement = driver.findElement(postPhone);
        String phoneNumber2 = phoneelement.getAttribute("href");

        waitForElement(postSeller);
        WebElement sellerElement = driver.findElement(postSeller);
        String sellerName = sellerElement.getText();
        System.out.println(sellerName);
        System.out.println(phoneNumber2);
    }
    public void getAssetState() {

    }
    public List<String> getGallery() {
        blockAds();
        List<String> assetImageGallery = new ArrayList<>();
    try {
        waitForElement(postImage); // Make sure this method correctly waits for the element
       click(postImage);} catch (TimeoutException e) {}
        List<WebElement> list = driver.findElements(By.cssSelector("[mode='slider']"));
        if (list.size()>0) {
            int imageAmount = list.size();
        for (int i = 0; i < imageAmount; i++) {
            By imageSelector = By.cssSelector("[class='css-wl0tt4 e1wozjxm6'] img");
            WebElement imageElement = driver.findElement(imageSelector);
            String imageLink = imageElement.getAttribute("src");
            assetImageGallery.add(imageLink);
            By ByButton = By.cssSelector("[class='css-18kkzyf e1wozjxm15']");
            WebElement nextButton = driver.findElement(ByButton);
            nextButton.click();
        }
            By closeGallery = By.cssSelector("[width='24'] [transform='rotate(45 142.524 25.308)']");
            click(closeGallery);

        System.out.println(assetImageGallery); // Print the gallery links

            return assetImageGallery;}
    else { String imageLink = "NULL";
            assetImageGallery.add(imageLink);
            System.out.println(assetImageGallery);
            return assetImageGallery;
        }
    } //Done
    public List<Map<String, Boolean>>getBoolean(){
        blockAds();
        List<WebElement> elements = driver.findElements(By.cssSelector("[class=\"css-1wpv10e e125ttrt3\"] div"));
        List<Map<String, Boolean>> assetStatus = new ArrayList<>();
        for (WebElement element : elements) {
            String classValue = element.getAttribute("class");
            String value = element.getText();
            if (classValue.contains(active))
            {
                Map<String, Boolean> elementInfo = new HashMap<>();
                elementInfo.put(elementNames(value), classValue.equals(active));
                assetStatus.add(elementInfo);
            } else if (classValue.contains(inactive)) {
                Map<String, Boolean> elementInfo = new HashMap<>();
                elementInfo.put(elementNames(value), classValue.equals(inactive));
                assetStatus.add(elementInfo);
            }

        }
        System.out.println(assetStatus);
        return assetStatus;
    } //Done
    public String elementNames( String elem) { String temp="";
        switch(elem) {
            case "אין מיזוג אויר":
            case"יש מיזוג אויר":
                temp = "assetAirConditions";
                break;
            case "יש מעלית":
            case "אין מעלית":
                temp = "assetElevator";
                break;
            case "יש חנייה":
            case "אין חנייה":
                temp="assetParkingSpot";
                break;
            case "יש מרפסת":
            case "אין מרפסת":
                temp="assetPorch";
                break;
            case "יש סורגים":
            case "אין סורגים":
                temp="assetBars";
                break;
            case "יש ממ״ד":
            case "אין ממ״ד":
                temp="assetMamed";
                break;
            case "נגיש לנכים":
            case "לא נגיש לנכים":
                temp="assetAccessForDisabled";
                break;
            case "אין דלתות פנדור":
            case "יש דלתות פנדור":
                temp="assetPandorDoors";
                break;
            case "אין מחסן":
            case "יש מחסן":
                temp="assetStorge";
                break;
            default:
                temp= "null";
                break;
        }
        return temp;
    } //Done
    public void clickOnNextPage(){
        waitForElement(nextPageArrow);
        WebElement nextPageButton = driver.findElement(nextPageArrow);
        if(nextPageButton.isEnabled()){
            nextPageButton.click();}


} // Done



    public void readCityFromJson() throws InterruptedException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        // Read and parse the JSON file containing Israel cities data
        Object obj = parser.parse(new FileReader(JsonPath));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray cities = (JSONArray) jsonObject.get("city");

        // Loop through each city in the JSON array
        for (Object cityObj : cities) {
            JSONObject city = (JSONObject) cityObj;
            JSONArray hebrewNameArray = (JSONArray) city.get("hebrew_name");
            String hebrewName = (String) hebrewNameArray.get(0);
            // Search for the city using the extracted Hebrew name
           String name =  searchForCity(hebrewName);
            if (name.contains(hebrewName) && name.contains("עיר"))
            {  getAllPostInfo();
            Thread.sleep(5000);}
            else {}
            {

    }



        }}}






