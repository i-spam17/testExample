package homeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;

public class FieldOfListOfMails {
    LeftSideBar leftSideBar = new LeftSideBar();

    private SelenideElement mail =$(By.xpath(
            "//div[@class=\"dataset__items\"]//a[@class=\"llc js-tooltip-direction_letter-bottom js-letter-list-item " +
                    "llc_normal llc_last\"]/div[@class=\"llc__avatar llc__avatar_unread\"]"));
    @Step("Перенести последнее письмо в списке в папку \"123\"")
    public FieldOfListOfMails dragAndDropMailInFolder() {
        Wait().until(ExpectedConditions.elementToBeClickable(mail));
        actions()
                .click(mail)
                .moveToElement(mail)
                .clickAndHold(mail)
                .moveToElement(leftSideBar.folderForDragAndDrop)
                .perform();
        return this;
    }
}
