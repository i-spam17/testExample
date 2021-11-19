package homeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavBar extends InboxPage {
    @FindBy(xpath = "//div[@data-testid=\"whiteline-account\"]")
    public WebElement accountField;

    @Step("Клик на меню Аккаунта")
    public NavBar clickAccount() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(accountField));
        accountField.click();
        return this;
    }

    public NavBar(WebDriver driver) {
        super(driver);
    }
}
