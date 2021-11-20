package homeWork7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowSuccessSentMail extends ComposeWindow {
    @FindBy(xpath = "//div[@class=\"layer-window__container\"]//a[text() ='Письмо отправлено']")
    public WebElement windowSuccessSentText;

    public WindowSuccessSentMail(WebDriver driver) {
        super(driver);
    }
}
