package homeWork7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseView {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 8);
        PageFactory.initElements(driver, this);
    }
}
