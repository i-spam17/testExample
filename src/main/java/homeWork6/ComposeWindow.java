package homeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComposeWindow extends InboxPage {
    public ComposeWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-type=\"to\"]//input[@type=\"text\"]")
    public WebElement toWhomField;

    @FindBy(xpath = "//input[@name=\"Subject\"]")
    public WebElement subjectField;

    @FindBy(xpath = "//div[@role=\"textbox\"]/div[1]")
    public WebElement textBox;

    @FindBy(xpath = "//span[@title=\"Отправить\"]")
    public WebElement buttonSend;

    @Step("Заполнить поле \"Кому\"")
    public ComposeWindow fillToWhom(String mail) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(toWhomField));
        toWhomField.sendKeys(mail);
        return this;
    }

    @Step("Заполнить поле \"Тема\"")
    public ComposeWindow fillTheme(String theme) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(subjectField));
        subjectField.sendKeys(theme);
        return this;
    }

    @Step("Заполнить текстовое поле")
    public ComposeWindow fillTextBox(String text) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(textBox));
        textBox.sendKeys(text);
        return this;
    }

    @Step("Клик на кнопку \"Отправить\"")
    public ComposeWindow clickSendMail() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSend));
        buttonSend.click();
        return this;
    }
}
