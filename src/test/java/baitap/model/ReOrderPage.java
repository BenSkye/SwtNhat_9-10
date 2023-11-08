package baitap.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReOrderPage {
    WebDriver driver;
    By accountLogin = By.xpath("//span[@class='label'][normalize-space()='Account']");
    By loginLink = By.linkText("Log In");
    By emailBox = By.id("email");
    By passwordBox = By.id("pass");
    By loginBtn = By.id("send2");
    By reorderBtn = By.className("link-reorder");
    By countryDropdown = By.id("country");
    By regionInput = By.id("region");
    By zipInput = By.id("postcode");
    By estimate = By.xpath("//span[contains(text(),'Estimate')]");
    By proceedToCheckoutBtn = By
            .xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']");
    By continueBtn1 = By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]");
    By continueBtn2 = By.xpath("//button[@onclick='shippingMethod.save()']");
    By checkMoneyOrder = By.xpath("//label[@for='p_method_checkmo']");
    By continueBtn3 = By.xpath("//button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]");
    By placeOrder = By.xpath("//span[contains(text(),'Place Order')]");
    By quantitySelector = By.xpath("//input[@title='Qty']");
    By submitQuantityBtn = By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]");
    By selectShippingCostButton = By.id("s_method_flatrate_flatrate");
    By updateButton = By.xpath("//span[contains(text(),'Update Total')]");
    By subTotal = By.cssSelector(
            "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1)");
    By shippingCost = By.cssSelector(
            "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)");
    By totalCost = By.cssSelector("strong span[class='price']");
    By searchButton = By.xpath("//button[@title='Search']");
    By searchBox = By.id("search");
    By addToCartButton = By.xpath("//button[@title='Add to Cart']");
    By cartButton = By.xpath("//a[@class='skip-link skip-cart']");
    By couponCodeInput = By.id("coupon_code");
    By applyCouponButton = By.xpath("//button[@title='Apply']");
    By discountAmount = By.cssSelector("td.discount span.price");

    // ----------------------------------------------

    public ReOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccount() {
        driver.findElement(accountLogin).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void inputEmailAndPassword(String email, String password) {
        driver.findElement(emailBox).sendKeys(email);
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void clickLoginSubmit() {
        driver.findElement(loginBtn).click();
    }

    public void clickReorderBtn() {
        driver.findElement(reorderBtn).click();
    }

    public void inputEstimate(String country, String state, int zip) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(regionInput).sendKeys(state);
        driver.findElement(zipInput).sendKeys(String.valueOf(zip));
    }

    public void clickEstimate() {
        driver.findElement(estimate).click();
    }

    public void clickProceedBtn() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    public void clickContinueBtn1() {
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

    // public void clickShippingCostButton() {
    // driver.findElement(selectShippingCostButton).click();
    // }

    public WebElement quantity() {
        return driver.findElement(quantitySelector);
    }

    public void inputQuantity(int num) {
        quantity().clear();
        quantity().sendKeys(String.valueOf(num));
    }

    public void updateQuantity() {
        driver.findElement(submitQuantityBtn).click();
    }

    public boolean addShippingCost() {
        String subtotalString = driver.findElement(subTotal).getText().replace(",", "").replace("$", "");
        String totalString = driver.findElement(totalCost).getText().replace(",", "").replace("$", "");
        double subtotal = Double.parseDouble(subtotalString);
        double total = Double.parseDouble(totalString);
        return (total == subtotal);
    }

    public void searchProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void clickCart() {
        driver.findElement(cartButton).click();
    }

    public void applyCouponCode(String couponCode) {
        driver.findElement(couponCodeInput).sendKeys(couponCode);
        driver.findElement(applyCouponButton).click();
    }

    public String getDiscountAmount() {
        WebElement discountElement = driver.findElement(discountAmount);
        return discountElement.getText().trim();
    }

    public void inputUsername(String username) {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);
    }
}