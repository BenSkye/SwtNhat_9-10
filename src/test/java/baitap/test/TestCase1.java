package baitap.test;

import baitap.model.MobilePage;
import driver.driverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase1 {
@Test
public void testMobileSorting() throws InterruptedException {
    WebDriver driver = driverFactory.getChromeDriver();
    MobilePage mobilePage = new MobilePage(driver);

    try {
        driver.get("http://live.techpanda.org/");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        mobilePage.clickMobileLink();
        mobilePage.selectSortBy("Name");
        List<String> productNames = mobilePage.getProductNames();
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);

        if (productNames.equals(sortedProductNames)) {
            System.out.println("Products are sorted by name");
        } else {
            System.out.println("Products are not sorted by name");
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        driver.quit();
    }
}
}
