package homeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavBar {
    public SelenideElement accountField = $(By.xpath("//div[@data-testid=\"whiteline-account\"]"));

    @Step("Клик на меню Аккаунта")
    public NavBar clickAccount() {
        accountField.click();
        return this;
    }
}
