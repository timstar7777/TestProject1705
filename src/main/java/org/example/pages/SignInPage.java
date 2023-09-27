package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.example.core.CommonPageMethods.emailPatternMatches;
import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class SignInPage extends BasePage {
    @Getter
    private final String SIGN_IN_ACCOUNT_URL = "https://magento2-demo.magebit.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvMi1kZW1vLm1hZ2ViaXQuY29tL2N1c3RvbWVyL2FjY291bnQvY3JlYXRlLw%2C%2C/";

    @FindBy(xpath = "//input[@id='email']")
    private WebElement elEmailInput;
    @FindBy(xpath = "//div[@id='email-error']")
    private WebElement elEmailError;
    @FindBy(xpath = "//div[@class='columns']//input[@id='pass']")
    private WebElement elPasswordInput;
    @FindBy(xpath = "//div[@id='pass-error']")
    private WebElement elPasswordError;
    @FindBy(xpath = "//div[@class='page-title-wrapper']//h1[@class='page-title']//span")
    private WebElement elTitle;
    @Getter
    @FindBy(xpath = "//div[@class='columns']//button[@id='send2']")
    private WebElement elSignInCta;


    @Override
    public void open() {
        super.driver.get(SIGN_IN_ACCOUNT_URL);
        ensureOpened();

    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elTitle);
    }
    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void setEmail(String email){
        waitUntilElementIsVisible(driver, elEmailInput);
        elEmailInput.clear();
        elEmailInput.sendKeys(email);
    }
    public void setPassword(String password){
        waitUntilElementIsVisible(driver, elPasswordInput);
        elPasswordInput.clear();
        elPasswordInput.sendKeys(password);
    }
    public void isPasswordErrorDisplayed(String password){
        if (password.isEmpty()) {
            waitUntilElementIsVisible(driver, elPasswordError);
            Assert.assertEquals(elPasswordError.getText(), "This is a required field.", "expected password error message" +
                    " doesn't match actual error message");
        }
    }
    public void isEmailErrorDisplayed(String email){
        if (email.isEmpty()) {
            waitUntilElementIsVisible(driver, elEmailError);
            Assert.assertEquals(elEmailError.getText(), "This is a required field.", "expected email error message" +
                    " doesn't match actual error message");
        } else if (!emailPatternMatches(email)) {
            waitUntilElementIsVisible(driver, elEmailError);
            Assert.assertEquals(elEmailError.getText(), "Please enter a valid email address (Ex: johndoe@domain.com).", "expected email error message" +
                    " doesn't match actual error message");
        }
    }
    public void checkErrorFields() {
        isEmailErrorDisplayed(elEmailInput.getAttribute("value"));
        isPasswordErrorDisplayed(elPasswordInput.getAttribute("value"));
    }




}
