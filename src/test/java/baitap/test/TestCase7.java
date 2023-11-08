package baitap.test;

import baitap.model.SavePDFPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


@Test
public class TestCase7 {
    @Test
    public void TestSavePDFFile(){
        WebDriver driver = driverFactory.getChromeDriver();

        driver.get("http://live.techpanda.org/");
        SavePDFPage loginPage = new SavePDFPage(driver);
        loginPage.clickMyAccountLink();
        loginPage.enterEmail("bomaythichdo@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        SavePDFPage pdfPage = new SavePDFPage(driver);
        pdfPage.clickViewOrder();
        pdfPage.clickPrintOrder();

        driver.quit();
    }
}
