package homeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertDeleteFolder extends FolderContextMenu {
    @FindBy(xpath = "//div[@class=\"layer__submit-button\"]//span[@class=\"button2__txt\"]")
    public WebElement buttonDelete;

    @Step("Клик на кнопку \"Удалить\"")
    public AlertDeleteFolder clickButtonDelete() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonDelete));
        buttonDelete.click();
        return this;
    }

    public AlertDeleteFolder(WebDriver driver) {
        super(driver);
    }
}
