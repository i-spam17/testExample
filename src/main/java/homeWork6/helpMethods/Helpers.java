package homeWork6.helpMethods;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Helpers {
    public static boolean isElementExist(WebElement element, String elementName) {
        try {
            element.getText().equals(elementName);
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static WebElement getElement(List<WebElement> webElementList, String nameWebElement) {
        return webElementList.stream().filter(el -> el.getText().equals(nameWebElement))
                .findFirst()
                .get();
    }
}
