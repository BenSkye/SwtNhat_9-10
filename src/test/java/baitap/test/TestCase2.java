package baitap.test;

import baitap.model.MobilePage;
import driver.driverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestCase2 {
    @Test
    public  void TestPriceSonyXperia() {
        // Set the path to the chromedriver executable
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            driver.get("http://live.techpanda.org/");
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            WebElement sonyXperiaPriceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String listPrice = sonyXperiaPriceElement.getText();

            WebElement sonyXperiaLink = driver.findElement(By.xpath("//img[@id='product-collection-image-1']"));
            sonyXperiaLink.click();

            WebElement detailPagePriceElement = driver.findElement(By.xpath("//span[@class='price']"));
            String detailPrice = detailPagePriceElement.getText();

            if (listPrice.equals(detailPrice)) {
                System.out.println("The product price on the list and details page are equal.");
            } else {
                System.out.println("The product price on the list and details page are not equal.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

