package homeWork7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FolderForDragAndDrop extends InboxPage {
    @FindBy(xpath = "//div[@class=\"llc__content\"]//span[@class=\"ll-sj__normal\"]")
    public List<WebElement> mailsFolderForDragAndDrop;

    public FolderForDragAndDrop(WebDriver driver) {
        super(driver);
    }
}
