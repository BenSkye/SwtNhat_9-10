package baitap.test;

import baitap.model.ReOrderPage;
import driver.driverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase9 {
    @Test
    public void testVerifyDiscount() {
        WebDriver driver = driverFactory.getChromeDriver();

        // Step 1: Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // a[normalize-space()='Mobile']
        // 2. Go to Mobile and add IPHONE to cart
        WebElement mobile = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
        mobile.click();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement addToCartIphone = driver
                .findElement(By.xpath("//li[3]//div[1]//div[3]//button[1]//span[1]//span[1]"));
        addToCartIphone.click();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. Enter Coupon Code
        WebElement coupon_codeText = driver.findElement(By.id("coupon_code"));
        coupon_codeText.sendKeys("GURU50");
        ;

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement applyHref = driver
                .findElement(By.xpath("//span[contains(text(),'Apply')]"));
        applyHref.click();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 4. Verify the discount generated
        WebElement SUBTOTAL = driver
                .findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[1]/td[2]/span"));

        WebElement DISCOUNT = driver
                .findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span"));

        WebElement GRANDTOTAL = driver
                .findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
        String subtotalValue = SUBTOTAL.getText();
        subtotalValue = subtotalValue.replace("$", "");
        String discountValue = DISCOUNT.getText();
        discountValue = discountValue.replace("$", "");
        discountValue = discountValue.replace("-", "");
        String grandTotalValue = GRANDTOTAL.getText();
        grandTotalValue = grandTotalValue.replace("$", "");
        double subtotal = Double.parseDouble(subtotalValue);
        double discount = Double.parseDouble(discountValue);
        double grandTotal = Double.parseDouble(grandTotalValue);
        double expectedDiscountedPrice = subtotal - (subtotal * 0.05);
        Assert.assertTrue(expectedDiscountedPrice == grandTotal);

        // Close the browser
        driver.quit();
    }
}
