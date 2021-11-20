package homeWork7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RightSideBar extends InboxPage {
    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    WebElement fieldLogOut;

    @Step("Клик на поле \"Выйти\"")
    public RightSideBar clickFieldLogout() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(fieldLogOut));
        fieldLogOut.click();
        return this;
    }

    public RightSideBar(WebDriver driver) {
        super(driver);
    }
}
