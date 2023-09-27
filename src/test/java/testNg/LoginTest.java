package testNg;

import org.example.pages.SignInPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void canLogin(){
        SignInPage signInPage = new SignInPage(driver);
        signInPage.open();
        signInPage.setEmail("blabla");
        signInPage.setPassword("");
        signInPage.getElSignInCta().click();
        signInPage.checkErrorFields();
    }
}
