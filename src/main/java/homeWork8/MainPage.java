package homeWork8;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage {
    public SelenideElement inputLogin = $(By.xpath("//input[@data-testid=\"login-input\"]"));

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

    private SelenideElement buttonEnterPassword = $(By.xpath("//button[@data-testid=\"enter-password\"]"));

    @Step("Клик на кнопку \"Ввести пароль\"")
    public MainPage clickButtonEnterPassword() {
        buttonEnterPassword.click();
        return this;
    }

    private SelenideElement inputPassword = $(By.xpath("//input[@data-testid=\"password-input\"]"));

    @Step("Клик на поле \"Пароль\"")
    public MainPage clickInputPassword() {
        inputPassword.click();
        return this;
    }

    @Step("Заполняем поле пароль")
    public MainPage fillPassword(String pass) {
        inputPassword.sendKeys(pass);
        return this;
    }


    private SelenideElement buttonLoginToMail = $(By.xpath("//button[@data-testid=\"login-to-mail\"]"));

    @Step("Клик на кнопку \"Ввойти\"")
    public MainPage clickButtonEnter() {
        buttonLoginToMail.click();
        return this;
    }
}
