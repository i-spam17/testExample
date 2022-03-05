package homeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewFolderWindow {
    private SelenideElement inputNameFolder = $(By.xpath("//input[@placeholder=\"Название\"]"));

    private SelenideElement buttonAddFolder = $(By.xpath("//span[.='Добавить папку']"));

    @Step("Клик на поле \"Название\"")
    public NewFolderWindow clickOnFieldName() {
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
}
