package baitap.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    WebDriver driver;

    // Define your locators at the top of the class
    By myAccountLink = By.linkText("MY ACCOUNT");


    By createAccountLink = By.linkText("CREATE AN ACCOUNT");
    By firstNameInputLocator = By.id("firstname");
    By lastNameInputLocator = By.id("lastname");
    By emailInputLocator = By.id("email_address");
    By passwordInputLocator = By.id("password");
    By confirmPasswordInputLocator = By.id("confirmation");
    By registerButton = By.xpath("//button[@title='Register']");

    By tvMenuLink = By.linkText("TV");
    By addToWishlistLink = By.xpath("//a[@title='LG LCD']//following::a[@class='link-wishlist']");
    By shareWishlistButton = By.name("save_and_share");
    By emailInput = By.id("email_address");
    By messageInput = By.id("message");
    By shareWishlistSubmitButton = By.xpath("//button[@title='Share Wishlist']");



    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Create methods for each action
    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void clickCreateAccountLink() {
        driver.findElement(createAccountLink).click();
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameInputLocator);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameInputLocator);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailInputLocator);
        emailElement.clear();
        emailElement.sendKeys(email);
    }


    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInputLocator);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordElement = driver.findElement(confirmPasswordInputLocator);
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickTvMenuLink() {
        driver.findElement(tvMenuLink).click();
    }

    public void clickAddToWishlistLink() {
        driver.findElement(addToWishlistLink).click();
    }

    public void clickShareWishlistButton() {
        driver.findElement(shareWishlistButton).click();
    }


    public void enterMessage(String message) {
        WebElement messageElement = driver.findElement(messageInput);
        messageElement.clear();
        messageElement.sendKeys(message);
    }

    public void clickShareWishlistSubmitButton() {
        driver.findElement(shareWishlistSubmitButton).click();
    }

}