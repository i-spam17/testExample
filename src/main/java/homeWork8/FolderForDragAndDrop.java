package homeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Collection;

import static com.codeborne.selenide.Selenide.$$;
import static homeWork8.MailRuTestData.*;

public class FolderForDragAndDrop {
    public Collection<SelenideElement> mailsFolderForDragAndDrop =
            $$(By.xpath("//div[@class=\"llc__content\"]//span[@class=\"ll-sj__normal\"]"));

    @Step("Письмо существует в папке")
    public boolean isMailExist() {
        return Helpers.isElementExist(Helpers.getElement(mailsFolderForDragAndDrop, NAME_OF_MAIL),NAME_OF_MAIL);
    }
}
