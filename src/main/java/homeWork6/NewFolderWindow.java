package homeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewFolderWindow extends InboxPage {
    @FindBy(xpath = "//input[@placeholder=\"Название\"]")
    WebElement inputNameFolder;

    @FindBy(xpath = "//span[.='Добавить папку']")
    WebElement buttonAddFolder;

    @Step("Клик на поле \"Название\"")
    public NewFolderWindow clickOnFieldName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputNameFolder));
        inputNameFolder.click();
        return this;
    }

    @Step("Ввести в поле \"Название\" название папки")
    public NewFolderWindow enterNameFolder(String nameFolder) {
        inputNameFolder.sendKeys(nameFolder);
        return this;
    }

    @Step("Клик на кнопку \"Добавить папку\"")
    public NewFolderWindow clickButtonAddFolder() {
        buttonAddFolder.click();
        return this;
    }

    public NewFolderWindow(WebDriver driver) {
        super(driver);
    }
}
