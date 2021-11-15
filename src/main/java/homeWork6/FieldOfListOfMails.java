package homeWork6;

import homeWork6.helpMethods.Helpers;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class FieldOfListOfMails extends InboxPage {
    private static final String NAME_OF_MAIL = "Добро пожаловать в Почту Mail.ru";

    @FindBy(xpath = "//div[@class=\"llc__content\"]//span[@class=\"ll-sj__normal\"]")
    List<WebElement> mails;

    @FindBy(xpath = "//div[@class=\"nav__folder\"]/div[.='123']")
    WebElement folderForDragAndDrop;

    @Step("Перенести выбранное письмо в папку")
    public FieldOfListOfMails dragAndDropMailInFolder() {
        //навреное проблема решается с помощью JS но потестить не успеваю.....(( примерный код ниже..

//        String filePath = "src/main/java/homeWork6/helpMethods/dragAndDropHelper.js";
//        StringBuffer buffer = new StringBuffer();
//
//        String line;
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        while((line = br.readLine())!=null)
//            buffer.append(line);
//
//        String javaScript = buffer.toString();
//        javaScript = javaScript + "$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});";
//        ((JavascriptExecutor)driver).executeScript(javaScript);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(Helpers.getElement(mails, NAME_OF_MAIL)));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(Helpers.getElement(mails, NAME_OF_MAIL))
                .clickAndHold(Helpers.getElement(mails, NAME_OF_MAIL))
                .dragAndDrop(Helpers.getElement(mails, NAME_OF_MAIL), folderForDragAndDrop)
                .moveToElement(folderForDragAndDrop)
                .build()
                .perform();
        return this;
    }

    public FieldOfListOfMails(WebDriver driver) {
        super(driver);
    }
}
