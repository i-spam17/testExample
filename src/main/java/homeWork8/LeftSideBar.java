package homeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LeftSideBar {
    private SelenideElement newFolder = $(By.xpath("//div[@data-qa-id=\"new-folder-btn\"]"));

    @Step("Клик на \"Новая папка\"")
    public LeftSideBar clickCreateNewFolder() {
        newFolder.click();
        return this;
    }

    public SelenideElement testFolder = $(By.xpath("//div[@class=\"nav__folder\"]/div[.='Test_folder']"));

    @Step("Клик ПКМ на папку")
    public LeftSideBar contextClickFolder() {
        testFolder.contextClick();
        return this;
    }

    public SelenideElement folderForDragAndDrop = $(By.xpath("//div[@class=\"nav__folder\"]/div[.='123']"));

    @Step("Клик на папку \"123\"")
    public LeftSideBar clickOnFolderForDragAndDrop() {
        folderForDragAndDrop.click();
        return this;
    }

    private SelenideElement composeButton = $(By.xpath("//a[contains(@href, 'compose')]"));

    @Step("Клик на кнопку \"Написать письмо\"")
    public LeftSideBar clickCreateMail() {
        composeButton.click();
        return this;
    }
}
