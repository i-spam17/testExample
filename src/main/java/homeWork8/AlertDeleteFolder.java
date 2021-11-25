package homeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AlertDeleteFolder {
    private SelenideElement buttonDelete = $(By.xpath("//div[@class=\"layer__submit-button\"]//span[@class=\"button2__txt\"]"));

    @Step("Клик на кнопку \"Удалить\"")
    public AlertDeleteFolder clickButtonDelete() {
        buttonDelete.click();
        return this;
    }
}
