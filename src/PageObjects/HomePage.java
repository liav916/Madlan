package PageObjects;


import org.openqa.selenium.*;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HomePage extends BasePage {

String active = "css-1p1vgp0 elkstcv0";
String inactive = "css-tc23vv elkstcv0";
    public HomePage(WebDriver driver) {
        super(driver);
    }
    String city = "שדרות";
    By searchField = By.cssSelector("[class='multi-search-input-wrapper css-ixz1sj ealzp4l9']");
    By arrowElement = By.cssSelector("data-auto='bulletins-pagination-2'");
    By Title = By.cssSelector("[data-auto='primary_address_text']");
    By header =By.cssSelector("[data-auto='desktop-header-wrapper']");
    By SubTitle = By.cssSelector("[data-auto='secondary_address_text']");
    By Price = By.cssSelector("[data-auto='current-price']");

    By Info = By.cssSelector("[class='css-v1qjdi ebqee3y2']");
    By postImage = By.cssSelector("[class='css-1526ib8 e1r3dysu15']");
    By postPhone = By.cssSelector("[data-auto='phone-number-button']");
    By postSeller = By.cssSelector("[data-auto='poc-name']");
    By postbackArrow = By.cssSelector("[data-auto='back-button-text']");
    By searchElementField = By.cssSelector("[data-auto='autocomplete-textfield']");


    public void clickOnSearchField() {
        waitForElement(searchField);
        WebElement searchField1 = driver.findElement(searchField);
        scrollToAndClickElement(searchField1);
    }
    public void insertValue() throws InterruptedException {
        WebElement searchElement = driver.findElement(searchElementField);
        searchElement.sendKeys(city);
        By CityFieldDropDown =By.cssSelector("[data-auto='autocomplete-suggestion']");
        waitForElement(CityFieldDropDown);
        List<WebElement> list = driver.findElements(CityFieldDropDown);
        for(int i=0; i< list.size();i++){
            String name = list.get(i).getText();
            if (name.contains(city) && name.contains("עיר")){
                (list.get(i)).click();
                break;
            }
        }

    }
    public void allPostSize() throws InterruptedException {
        List<WebElement> posts = driver.findElements(By.cssSelector(".universal-card-body-wrapper.css-79elbk.e1sx3tzs15"));//50
        for (int i=0; i<=posts.size(); i++){
            WebElement post =  posts.get(i);
            scrollToAndClickElement(post);
         //   blockAds();
            click(postbackArrow);
            Thread.sleep(5000);
            posts = driver.findElements(By.cssSelector(".universal-card-body-wrapper.css-79elbk.e1sx3tzs15"));//50
            }
        }
    public void blockAds(){
        try{  By add = By.cssSelector("[data-auto='modal-popup']");
            WebElement addElement = driver.findElement(add);
            if(addElement.isDisplayed()){
                By xButton = By.cssSelector("div [data-auto='modal-close-button']");
                click(xButton);}} catch (NoSuchElementException e){}

    }

    public void clickoncatgory () {//waiting for all header to load
        waitForElement(header);
        //catch all header catagorys
        List<WebElement> element = driver.findElements(By.cssSelector("[class='tab-link']"));
        //catch only the catgory i want to press on
        WebElement catgory = element.get(0);
        // click on the catgory
        catgory.click();
    }
    public void getAllPostInfo () {

        getTitle();
        getSubtitle();
        getPrice ();
        getInfo();
        getPhoneAndSeller();
        getGallery();
        getBoolean();

    }
    public void getTitle () {

        waitForElement(Title); // Make sure this method correctly waits for the element
        WebElement element = driver.findElement(Title); // Assuming 'driver' is your WebDriver instance
        String title = element.getText();
System.out.println(title);}
    public void getSubtitle () {

        waitForElement(SubTitle); // Make sure this method correctly waits for the element
        WebElement element = driver.findElement(SubTitle); // Assuming 'driver' is your WebDriver instance
        String subtitle = element.getText();
        System.out.println(subtitle);


    }
    public void getPrice () {

        waitForElement(Price); // Make sure this method correctly waits for the element
        WebElement element = driver.findElement(Price); // Assuming 'driver' is your WebDriver instance
        String price = element.getText();
        System.out.println(price);


    }
    public void getInfo () {
        waitForElement(Info); // Make sure this method correctly waits for the element
        WebElement element = driver.findElement(Info); // Assuming 'driver' is your WebDriver instance
        String info = element.getText();
        System.out.println(info);
    }
    public void getPhoneAndSeller() {
        waitForElement(postPhone);
        WebElement phoneelement = driver.findElement(postPhone);
        String phoneNumber2 = phoneelement.getAttribute("href");

        waitForElement(postSeller);
        WebElement sellerElement = driver.findElement(postSeller);
        String sellerName = sellerElement.getText();
        System.out.println(sellerName);
        System.out.println(phoneNumber2);
    }
    public List<String> getGallery() {
        List<String> assetImageGallery = new ArrayList<>();
        waitForElement(postImage); // Make sure this method correctly waits for the element
        click(postImage);
        List<WebElement> list = driver.findElements(By.cssSelector("[mode='slider']"));

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

            return assetImageGallery;
    }
    public List<Map<String, Boolean>>getBoolean(){
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
    }
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
            case "יש ממ\"ד":
            case "אין ממ\"ד":
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
            case "ממ\"ד":
                temp="assetMamad";
                break;
            case "מחסן":
                temp="assetStorage";
                break;
            case "מזגן תדיראן":
                temp="assetAirConditioner";
                break;
            case "ריהוט":
                temp="assetFurnished";
                break;
            case "גמיש":
                temp="assetContactFlexible";
                break;
            default:
                temp= "null";
                break;
        }
        return temp;
    }
}










