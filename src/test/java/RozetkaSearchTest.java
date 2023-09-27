import org.example.core.data.DataProviderMethods;
import org.example.pages.RozetkaPage;
import org.example.pages.SearchPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import testNg.BaseTest;

import static org.example.utils.WaitUtils.waitUntilElementIsClickable;


public class RozetkaSearchTest extends BaseTest {
    @Test(dataProvider = "dataForRozetkaSearchTest", dataProviderClass = DataProviderMethods.class)
    public void checkAmountOfBrands(String userRequest, int amountOfBrands) {
        RozetkaPage homePage = new RozetkaPage(driver);
        homePage.open();
        homePage.getElSearchTab().sendKeys(userRequest, Keys.ENTER);
        SearchPage searchPage = new SearchPage(driver);
        searchPage.ensureOpened();

        Assert.assertEquals(searchPage.getSizeOfList(), amountOfBrands, "expected amount of brands doesn't match actual" );

    }
    @Test
    public void checkCatalogSelection() throws InterruptedException {
        RozetkaPage homePage = new RozetkaPage(driver);
        homePage.open();
        homePage.getElSearchTab().sendKeys("процессор", Keys.ENTER);
    }
}
