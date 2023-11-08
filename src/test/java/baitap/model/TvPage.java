package baitap.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TvPage {
    private WebDriver driver;

    private By tvLink = By.linkText("TV");
    private By sortByDropdown = By.cssSelector("select[title='Sort By']");
    private By productNames = By.className("item");

    public TvPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTvLink() {
        driver.findElement(tvLink).click();
    }

    public void selectSortBy(String option) {
        new Select(driver.findElement(sortByDropdown)).selectByVisibleText(option);
    }

    public List<String> getProductNames() {
        List<WebElement> products = driver.findElements(productNames);
        List<String> names = new ArrayList<>();
        for (WebElement product : products) {
            names.add(product.getText());
        }
        return names;
    }
}

