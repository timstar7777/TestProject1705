package testNg;

import org.example.pages.RozetkaPage;
import org.testng.annotations.Test;

import static org.example.utils.WaitUtils.waitUntilElementIsClickable;

public class RozetkaRegistrationTest extends BaseTest{
    @Test
    public void checkRegistration() {
        RozetkaPage rozetkaPage = new RozetkaPage(driver);
        rozetkaPage.open();
        waitUntilElementIsClickable(driver, rozetkaPage.getElLogInCta());
        rozetkaPage.getElLogInCta().click();

        waitUntilElementIsClickable(driver, rozetkaPage.getElSignInCta());
        rozetkaPage.getElSignInCta().click();
        rozetkaPage.setFirstName("Rostik");
        rozetkaPage.setSecondName("Rudenko");
        rozetkaPage.setUserPhone("380950438378");
        rozetkaPage.setUserEmail("timstar7777");
        rozetkaPage.setUserPassword("212121");

    }
}
