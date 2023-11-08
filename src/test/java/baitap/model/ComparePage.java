package baitap.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ComparePage {

        private WebDriver driver;
        private By mobileMenuSelector = By.linkText("MOBILE");
        private By addSonyCompare = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[2]/div[1]/div[3]/ul[1]/li[2]/a[1]");
        private By addIphoneCompare = By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]");
        private By compareBtn = By.cssSelector("button[title='Compare']");
        private By popupHeader = By.xpath("//h1[normalize-space()='Compare Products']");
        private By checkComparedProduct1 = By.xpath("//a[normalize-space()='Sony Xperia']");
        private By checkComparedProduct2 = By.xpath("//a[normalize-space()='IPhone']");
        private By closePopup = By.xpath("//span[contains(text(),'Close Window')]");

        //----------------------------------------------
        public ComparePage(WebDriver driver) {
            this.driver = driver;
        }

        public WebElement mobileMenu() {
            return driver.findElement(mobileMenuSelector);
        }

        //----------------------------------------------
        public void clickMobileMenu() {
            mobileMenu().click();
        }

        public void addComparedProduct() {
            driver.findElement(addSonyCompare).click();
            driver.findElement(addIphoneCompare).click();
        }

        public void clickCompare() {
            driver.findElement(compareBtn).click();
        }

        public void checkHeader(String header) {
            Assert.assertEquals(driver.findElement(popupHeader).getText(), header, "Header is not equal!");
        }

        public void checkComparedProduct() {
            Assert.assertEquals(driver.findElement(checkComparedProduct1).getText(), "SONY XPERIA");
            Assert.assertEquals(driver.findElement(checkComparedProduct2).getText(), "IPHONE");
        }

        public void clickClosetBtn() {
            driver.findElement(closePopup).click();
        }
    }

