package baitap.test;

import baitap.model.MobilePage;
import driver.driverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestCase3 {
    @Test
    public void testAddToCart() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        MobilePage mobilePage = new MobilePage(driver);
        mobilePage.clickMobileLink();
        mobilePage.clickSonyXperiaAddCart();
        mobilePage.inputQuantity(1000);
        mobilePage.submitQuantity();
        String expectedErrorMessage = "The requested quantity for \"Sony Xperia\" is not available";

        if (mobilePage.errorMsg(expectedErrorMessage)) {
            System.out.println("Correct error message: " + expectedErrorMessage);
        } else {
            System.out.println("Incorrect error message. Expected: " + expectedErrorMessage);
        }
        mobilePage.clickEmptyCartLink();
        if (mobilePage.isCartEmpty()) {
            System.out.println("Card is empty");
        } else {
            System.out.println("Card is not empty");
        }

        driver.quit();
    }
}
