package testNg;

import lombok.extern.log4j.Log4j2;
import org.example.pages.HomePage;
import org.example.pages.LaptopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.utils.WaitUtils.waitUntilElementIsClickable;
import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

@Log4j2
public class TestNgTest extends BaseTest {
    @Test
    public void openHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
    }

    @Test
    public void checkIsLaptopTitleCorrect() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        waitUntilElementIsVisible(driver, homePage.getElLaptopCta());
        if (homePage.getElLaptopCta().getText().equalsIgnoreCase("Ноутбуки")) {
            log.info("INFO: title correct: " + homePage.getElLaptopCta().getText());
        } else {
            log.error("Expected title doesn't match actual title: " + homePage.getElLaptopCta().getText());
        }

    }

    @Test
    public void checkIsLaptopHrefCorrect() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        waitUntilElementIsClickable(driver, homePage.getElLaptopCta());
        Assert.assertEquals(homePage.getElLaptopCta().getAttribute("href"), "https://pn.com.ua/ct/1003/", "expected href doesn't match actual of href ");
    }
    @Test
    public void checkIsElLaptopVisible() {
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.open();
        waitUntilElementIsVisible(driver, laptopPage.getElLastTitleBreadcrumb());
        Assert.assertEquals(laptopPage.getElLastTitleBreadcrumb().getText(), "Ноутбуки", "expected test doesn't match actual text");
    }
}
