package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class RozetkaPage extends BasePage {
    private final String ROZETKA_PAGE_URL = "https://rozetka.com.ua/";
    @Getter
    @FindBy(xpath = "//input[@name='search']")
    private WebElement elSearchTab;
    @Getter
    @FindBy(xpath = "//div[@class='header-layout']//ul[@class='header-actions']//li[@class='header-actions__item header-actions__item--user']//button")
    private WebElement elLogInCta;
    @Getter
    @FindBy(xpath = "//button[@class='auth-modal__register-link button button--link ng-star-inserted']")
    private WebElement elSignInCta;
    @Getter
    @FindBy(xpath = "//input[@id='registerUserName']")
    private WebElement elRegisterUserName;
    @Getter
    @FindBy(xpath = "//input[@id='registerUserSurname']")
    private WebElement elRegisterUserSurname;
    @Getter
    @FindBy(xpath = "//input[@id='registerUserPhone']")
    private WebElement elRegisterUserPhone;
    @Getter
    @FindBy(xpath = "//input[@id='registerUserEmail']")
    private WebElement elRegisterUserEmail;
    @Getter
    @FindBy(xpath = "//input[@id='registerUserPassword']")
    private WebElement elRegisterUserPassword;

    public RozetkaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ROZETKA_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elLogInCta);
    }
    public void setFirstName(String firstName) {
    waitUntilElementIsVisible(driver, elRegisterUserName);
    elRegisterUserName.sendKeys(firstName);
    }
    public void setSecondName(String secondName) {
        waitUntilElementIsVisible(driver, elRegisterUserSurname);
        elRegisterUserSurname.sendKeys(secondName);
    }
    public void setUserPhone(String userPhone) {
        waitUntilElementIsVisible(driver, elRegisterUserPhone);
        elRegisterUserPhone.sendKeys(userPhone);
    }
    public void setUserEmail(String userEmail) {
        waitUntilElementIsVisible(driver, elRegisterUserEmail);
        elRegisterUserEmail.sendKeys(userEmail);
    }
    public void setUserPassword(String userPassword) {
        waitUntilElementIsVisible(driver, elRegisterUserPassword);
        elRegisterUserPassword.sendKeys(userPassword);
    }
}
