package homeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPage extends BaseView {
    @FindBy(xpath = "//a[contains(@href, 'compose')]")
    public WebElement composeButton;

    @Step("Клик на кнопку \"Написать письмо\"")
    public InboxPage clickCreateMail() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(composeButton));
        composeButton.click();
        return this;
    }

    public InboxPage(WebDriver driver) {
        super(driver);
    }
}
