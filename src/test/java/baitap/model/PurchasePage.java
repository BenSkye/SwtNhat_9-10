package baitap.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchasePage {
    WebDriver driver;

    // Define your locators at the top of the class
    By myAccountLink = By.xpath("//span[@class='label'][normalize-space()='Account']");
    By emailInputLogin = By.name("login[username]");
    By passwordInputLogin = By.name("login[password]");
    By loginAccountLink = By.linkText("Log In");
    By loginButton = By.id("send2");

    By myWishlist = By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']");
    By addToCart = By.xpath("//button[@title='Add to Cart']");

    By countryDropdown = By.id("country");
    By regionInput = By.id("region");
    By zipInput = By.id("postcode");
    By zipInputChekout = By.id("billing:postcode");
    By estimate = By.xpath("//span[contains(text(),'Estimate')]");
    By selectShippingCostButton = By.id("s_method_flatrate_flatrate");
    By updateButton = By.xpath("//span[contains(text(),'Update Total')]");
    By proceedToChecout = By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']");

    By inputAddress = By.name("billing[street][]");
    By inputCity = By.name("billing[city]");
    By stateDropdown = By.id("billing:region_id");
    By inputPhone = By.id("billing:telephone");
    By continueBtn1 = By.xpath("//button[@onclick='billing.save()']");
    By continueBtn2 = By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]");
    By checkMoneyOrder = By.xpath("//label[@for='p_method_checkmo']");
    By continueBtn3 = By.xpath("//button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]");
    By placeOrder = By.xpath("//span[contains(text(),'Place Order')]");
    By subTotal = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1)");
    By shippingCost = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)");
    By totalCost = By.cssSelector("strong span[class='price']");
    public PurchasePage(WebDriver driver) {this.driver = driver;}

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }
    public void clickLoginAccountLink() {
        driver.findElement(loginAccountLink).click();
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void enterEmailLogin(String emailLogin) {
        driver.findElement(emailInputLogin).sendKeys(emailLogin);
    }

    public void enterPasswordLogin(String passwordLogin) {
        driver.findElement(passwordInputLogin).sendKeys(passwordLogin);
    }
    public void clickWishList() {
        driver.findElement(myWishlist).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCart).click();
    }

    public void inputEstimate(String country, String state, int zip) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(regionInput).sendKeys(state);
        driver.findElement(zipInput).sendKeys(String.valueOf(zip));
    }

    public void clickEstimate() {
        driver.findElement(estimate).click();
    }

    public void clickShippingCostButton() {
        driver.findElement(selectShippingCostButton).click();
    }
    public void clickUpdateButton() {
        driver.findElement(updateButton).click();
    }
    public void clickCheckoutButton() {
        driver.findElement(proceedToChecout).click();
    }
    public void inputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void inputCity(String city) {
        driver.findElement(inputCity).sendKeys(city);
    }
    public  void  inputZip(String zip){
        driver.findElement(zipInputChekout).sendKeys(zip);
    }

    public void inputState() {
        new Select(driver.findElement(stateDropdown)).selectByVisibleText("Ohio");
    }

    public void inputPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void clickContinueBtn1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn1));
        driver.findElement(continueBtn1).click();
    }

    public void clickContinueBtn2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn2));
        driver.findElement(continueBtn2).click();
    }

    public void clickCheckMoneyOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkMoneyOrder));
        driver.findElement(checkMoneyOrder).click();
    }

    public void clickContinueBtn3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn3));
        driver.findElement(continueBtn3).click();
    }

    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrder));
        driver.findElement(placeOrder).click();
    }

    public boolean addShippingCost(){
        driver.findElement(selectShippingCostButton).click();
        driver.findElement(updateButton).click();
        String subtotalString = driver.findElement(subTotal).getText().replace(",", "").replace("$", "");
        String shippingString = driver.findElement(shippingCost).getText().replace(",", "").replace("$", "");
        String totalString = driver.findElement(totalCost).getText().replace(",", "").replace("$", "");
        double subtotal = Double.parseDouble(subtotalString);
        double shipping = Double.parseDouble(shippingString);
        double total = Double.parseDouble(totalString);
        return (total == shipping + subtotal);
    }
}
