package baitap.test;

import baitap.model.ReOrderPage;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestCase8 {
    @Test
    public void testReorderPage() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        ReOrderPage reOrderPage = new ReOrderPage(driver);
        reOrderPage.clickAccount();
        reOrderPage.clickLogin();
        reOrderPage.inputEmailAndPassword("bomaythichdo@example.com", "password123");
        reOrderPage.clickLoginSubmit();
        reOrderPage.clickReorderBtn();
        boolean check1 = reOrderPage.addShippingCost();
        reOrderPage.inputQuantity(100);
        reOrderPage.updateQuantity();
        // reOrderPage.clickShippingCostButton();
        boolean check = reOrderPage.addShippingCost();
        if (check1 != check) {
            Assert.assertEquals(check1, check);
        }
        // reOrderPage.clickShippingCostButton();
        reOrderPage.clickEstimate();
        reOrderPage.clickProceedBtn();
        reOrderPage.clickContinueBtn1();
        reOrderPage.clickContinueBtn2();
        reOrderPage.clickCheckMoneyOrder();
        reOrderPage.clickContinueBtn3();
        reOrderPage.clickPlaceOrder();
    }
}