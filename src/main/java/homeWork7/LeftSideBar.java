package homeWork7;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftSideBar extends InboxPage {
    @FindBy(xpath = "//div[@data-qa-id=\"new-folder-btn\"]")
    public WebElement newFolder;

    @Step("Клик на \"Новая папка\"")
    public LeftSideBar clickCreateNewFolder() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newFolder));
        newFolder.click();
        return this;
    }

    @FindBy(xpath = "//div[@class=\"nav__folder\"]/div[.='Test_folder']")
    public WebElement testFolder;

    @Step("Клик ПКМ на папку")
    public LeftSideBar contextClickFolder() {
        webDriverWait.until(ExpectedConditions.visibilityOf(testFolder));
        Actions actions = new Actions(driver);
        actions.contextClick(testFolder).build().perform();
        return this;
    }

    @Step("Клик на папку \"123\"")
    public LeftSideBar clickOnFolderForDragAndDrop() {
        WebElement webElement = new FieldOfListOfMails(driver).folderForDragAndDrop;
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        return this;
    }

    public LeftSideBar(WebDriver driver) {
        super(driver);
    }

}
