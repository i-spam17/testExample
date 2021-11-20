package homeWork7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FolderContextMenu extends LeftSideBar {
    @FindBy(xpath = "//span[.='Удалить папку']")
    public WebElement fieldDeleteFolder;

    @Step("Клик на \"Удалить папку\"")
    public FolderContextMenu clickOnDeleteFolder() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(fieldDeleteFolder));
        fieldDeleteFolder.click();
        return this;
    }

    public FolderContextMenu(WebDriver driver) {
        super(driver);
    }
}
