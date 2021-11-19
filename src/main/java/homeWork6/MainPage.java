package homeWork6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-testid=\"login-input\"]")
    public WebElement inputLogin;

    @FindBy(xpath = "//button[@data-testid=\"enter-password\"]")
    public WebElement buttonEnterPassword;

    @FindBy(xpath = "//input[@data-testid=\"password-input\"]")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@data-testid=\"login-to-mail\"]")
    public WebElement buttonLoginToMail;

    @Step("Клик на поле логин")
    public MainPage clickLogin() {
        inputLogin.click();
        return this;
    }

    @Step("Заполняем поле \"Имя ящика\"")
    public MainPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Клик на кнопку \"Ввести пароль\"")
    public MainPage clickButtonEnterPassword() {
        buttonEnterPassword.click();
        return this;
    }

    @Step("Клик на поле \"Пароль\"")
    public MainPage clickInputPassword() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputPassword));
        inputPassword.click();
        return this;
    }

    @Step("Заполняем поле пароль")
    public MainPage fillPassword(String pass) {
        inputPassword.sendKeys(pass);
        return this;
    }

    @Step("Клик на кнопку \"Ввойти\"")
    public MainPage clickButtonEnter() {
        buttonLoginToMail.click();
        return this;
    }
}
