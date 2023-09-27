package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.example.utils.WaitUtils.waitUntilElementIsClickable;
import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class SearchPage extends BasePage {
    private final String ROZETKA_SEARCH_PAGE_URL = "https://rozetka.com.ua/";
    @Getter
    @FindBy(xpath = "//rz-filter-stack[@class='ng-star-inserted']")
    private WebElement elTitle;
    @Getter
    @FindBy(xpath = "//div[@data-filter-name='producer']//a[@class='checkbox-filter__link']" )
    private List<WebElement> elsProducersList;
    @Getter
    @FindBy(xpath = "//button[@class='catalog-selection__link catalog-selection__link_type_reset']")
    private WebElement btnReset;
    @Getter
    @FindBy(xpath = "//a[@class='catalog-selection__link']")
    private List<WebElement> elsFiltersList;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ROZETKA_SEARCH_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elTitle);

    }
    public int getSizeOfList() {
        return elsProducersList.size();
    }

    public void checkCatalogSelection() throws InterruptedException {
        waitUntilElementIsVisible(driver, elsProducersList.get(0));
        for (WebElement elBrand : elsProducersList) {
            waitUntilElementIsVisible(driver, elBrand);
            elBrand.click();
            Thread.sleep(1000);
            waitUntilElementIsClickable(driver, elsFiltersList.get(0));
            boolean isAnyMatchInList = elsFiltersList.stream().anyMatch(x -> x.getText().contains(elBrand.getText()));
            Assert.assertTrue(isAnyMatchInList, "expected catalog selection is not displayed");
        }
    }

}
