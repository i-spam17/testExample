package homeWork7.help;

import io.qameta.allure.Allure;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.ByteArrayInputStream;

public class CustomLoger implements WebDriverEventListener {
    private static Logger logger = LoggerFactory.getLogger(WebDriver.class);

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Скриншот страницы после алертом",
                new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Скриншот страницы перед алертом",
                new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        Allure.step("Хочу кликнуть на " + webElement.getText() + webElement.getTagName());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Скриншот страницы перед алертом",
                new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
