package homeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FolderContextMenu {
    private SelenideElement fieldDeleteFolder = $(By.xpath("//span[.='Удалить папку']"));

    @Step("Клик на \"Удалить папку\"")
    public FolderContextMenu clickOnDeleteFolder() {
        fieldDeleteFolder.click();
        return this;
    }
}
