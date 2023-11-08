package baitap.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SavePDFPage {
    WebDriver driver;

    By myAccount= By.xpath("//a[@class='skip-link skip-account']//span[@class='icon']");
    By myAccountLink = By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']");
    By emailInput = By.xpath("//input[@id='email']");
    By passwordInput = By.xpath("//input[@id='pass']");
    By loginButton = By.xpath("//span[contains(text(),'Login')]");
    By myOrderLink = By.xpath("//a[normalize-space()='My Orders']");
    By viewOrderLink = By.xpath("//a[normalize-space()='View Order']");
    By printOrderLink = By.xpath("//a[@class='link-print']");

    public SavePDFPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccount).click();
        driver.findElement(myAccountLink).click();
    }

    public void enterEmail(String email){
        WebElement enterEmail = driver.findElement(emailInput);
        enterEmail.clear();
        enterEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement enterEmail = driver.findElement(passwordInput);
        enterEmail.clear();
        enterEmail.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickViewOrder() {
        driver.findElement(myOrderLink).click();
        driver.findElement(viewOrderLink).click();
    }

    public void clickPrintOrder() {
        driver.findElement(printOrderLink).click();
    }

}