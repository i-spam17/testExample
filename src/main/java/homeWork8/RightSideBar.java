package homeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RightSideBar {
    private SelenideElement fieldLogOut = $(By.xpath("//a[contains(@href, 'logout')]"));

    @Step("Клик на поле \"Выйти\"")
    public RightSideBar clickFieldLogout() {
        fieldLogOut.click();
        return this;
    }
}
