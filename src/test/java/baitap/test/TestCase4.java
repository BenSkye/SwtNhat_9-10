package baitap.test;

import baitap.model.ComparePage;
import baitap.model.MobilePage;
import driver.driverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase4 {
    @Test
    public void testCompare() throws InterruptedException {
            WebDriver driver = driverFactory.getChromeDriver();
            driver.get("http://live.techpanda.org/");

            ComparePage comparePage = new ComparePage(driver);
        comparePage.clickMobileMenu();
        comparePage.addComparedProduct();
        comparePage.clickCompare();

            for(String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
        comparePage.checkHeader("COMPARE PRODUCTS");
        comparePage.checkComparedProduct();
        comparePage.clickClosetBtn();
            driver.quit();
        }
}

