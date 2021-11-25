package homeWork8;

import io.qameta.allure.Step;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ComposeWindow {
    private SelenideElement toWhomField = $(By.xpath("//div[@data-type=\"to\"]//input[@type=\"text\"]"));

    private SelenideElement subjectField = $(By.xpath("//input[@name=\"Subject\"]"));

    private SelenideElement textBox = $(By.xpath("//div[@role=\"textbox\"]/div[1]"));

    private SelenideElement buttonSend = $(By.xpath("//span[@title=\"Отправить\"]"));

    @Step("Заполнить поле \"Кому\"")
    public ComposeWindow fillToWhom(String mail) {
        toWhomField.sendKeys(mail);
        return this;
    }

    @Step("Заполнить поле \"Тема\"")
    public ComposeWindow fillTheme(String theme) {
        subjectField.sendKeys(theme);
        return this;
    }

    @Step("Заполнить текстовое поле")
    public ComposeWindow fillTextBox(String text) {
        textBox.sendKeys(text);
        return this;
    }

    @Step("Клик на кнопку \"Отправить\"")
    public ComposeWindow clickSendMail() {
        buttonSend.click();
        return this;
    }
}
