package baitap.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baitap.model.ReOrderPage;

import driver.driverFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 {
    @Test
    public void testExportAllOrdersToCSV() {
        // 1. Initialize the WebDriver
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // 2. Navigate to the backend login page
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            // 3. Log in with provided credentials
            WebElement userIdInput =
            driver.findElement(By.xpath("//input[@id='username']"));
            userIdInput.sendKeys("user01");
            WebElement passwordInput =
            driver.findElement(By.xpath("//input[@id='login']"));
            passwordInput.sendKeys("guru99com");
            WebElement loginButton =
            driver.findElement(By.xpath("//input[@title='Login']"));

            // userIdInput.sendKeys("user01");
            // passwordInput.sendKeys("guru99com");
            loginButton.click();

            // Wait for login to complete
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement closeButton =
            driver.findElement(By.xpath("//span[normalize-space()='close']"));
            closeButton.click();

            // 4. Go to Sales -> Orders menu
            WebElement saleButton =
            driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
            saleButton.click();
            WebElement orderButton =
            driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
            orderButton.click();
            // 5.input
            WebElement orderID =
            driver.findElement(By.xpath("//input[@id='sales_order_grid_filter_real_order_id']"));
            orderID.sendKeys("100021110");
            WebElement fromDateInput = driver.findElement(By.cssSelector(
            "body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) >
            div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) >
            table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) >
            div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
            fromDateInput.clear();
            fromDateInput.sendKeys("11/06/2023");

            // Input 'To Date'
            WebElement toDateInput = driver.findElement(By.cssSelector(
            "body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) >
            div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) >
            table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) >
            div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"));
            toDateInput.clear();
            toDateInput.sendKeys("11/07/2023");

            // Trigger the date picker (if available) by clicking on the calendar icon

            WebElement searchButton =
            driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
            searchButton.click();
            // Delay for 5 seconds
            Thread.sleep(5000);
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/screenshot/screenshot_tc10.png"));

            // ReOrderPage reOrderPage = new ReOrderPage(driver);
            // reOrderPage.login("user01", "guru99com");
            // reOrderPage.closePopupWindow();
            // reOrderPage.goToOrdersMenu();
            // reOrderPage.enterOrderID("100021110");
            // reOrderPage.enterDateRange("11/06/2023", "11/07/2023");
            // reOrderPage.clickSearchButton();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            reOrderPage.takeScreenshot("src/screenshot/screenshot_tc10.png");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7. Quit the browser session
            driver.quit();
        }
    }
}
