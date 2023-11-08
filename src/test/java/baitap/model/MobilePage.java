package baitap.model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MobilePage {
    private WebDriver driver;

    private By mobileLink = By.linkText("MOBILE");
    private By sortByDropdown = By.cssSelector("select[title='Sort By']");
    private By productNames = By.className("item");

    private By sonyXperiaPrice = By.xpath("//span[contains(text(),'$100.00')]");
    private By sonyXperiaLink = By.xpath("//img[@id='product-collection-image-1']");
    private By detailPagePrice = By.xpath("//span[@class='price']");

    private By sonyXperiaAddCart = By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]");
    private By updateButton = By.xpath("//button[@title='Update']");
    private By emptyCartLink = By.xpath("//a[@title='Empty Cart']");

    private By sonyAddToCardSelector = By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]");
    private By quanitySelector = By.xpath("//input[@title='Qty']");
    private By errorMsgSelector = By.className("error");
    private By submitQuanityBtn = By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]");
    private By emptyCardBtn = By.xpath("//span[contains(text(),'Empty Cart']");
    private By tableSelector = By.tagName("table");



    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileLink() {
        driver.findElement(mobileLink).click();
    }

    public void selectSortBy(String option) {
        new Select(driver.findElement(sortByDropdown)).selectByVisibleText(option);
    }

    public String getSonyXperiaPrice() {
        return driver.findElement(sonyXperiaPrice).getText();
    }

    public void clickSonyXperiaLink() {
        driver.findElement(sonyXperiaLink).click();
    }

    public String getDetailPagePrice() {
        return driver.findElement(detailPagePrice).getText();
    }

    public List<String> getProductNames() {
        List<WebElement> products = driver.findElements(productNames);
        List<String> names = new ArrayList<>();
        for (WebElement product : products) {
            names.add(product.getText());
        }
        return names;
    }

    public void clickSonyXperiaAddCart() {
        driver.findElement(sonyXperiaAddCart).click();
    }

    public void clickUpdateButton() {
        driver.findElement(updateButton).click();
    }

    public void clickEmptyCartLink() {
        driver.findElement(emptyCartLink).click();
    }

    public WebElement sonyAddToCard() {
        return driver.findElement(sonyAddToCardSelector);
    }

    public WebElement quantity() {
        return driver.findElement(quanitySelector);
    }

    public boolean errorMsg(String expectedMessage) {
        String error = driver.findElement(errorMsgSelector).getText();
        return error.equals(expectedMessage);
    }

    public void inputQuantity(int num) {
        quantity().clear();
        quantity().sendKeys(String.valueOf(num));
    }

    public void submitQuantity() {
        driver.findElement(submitQuanityBtn).click();
    }

    public boolean isCartEmpty() {
        try {
            WebElement table = driver.findElement(tableSelector);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
