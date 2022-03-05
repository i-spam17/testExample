package homeWork8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WindowSuccessSentMail {
    public SelenideElement windowSuccessSentText =
            $(By.xpath("//div[@class=\"layer-window__container\"]//a[text() ='Письмо отправлено']"));

}
