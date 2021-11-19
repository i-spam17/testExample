package homeWork5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;

public class MailRuTest {

    //почему когда запускаю все тесты порядок этих тестов не соответствует порядку в коде?
    final static String URL = "https://mail.ru";
    final static String LOGIN = "gb_test111";
    final static String PASSWORD = "ttRYyo1OT4o(";
    final static String E_MAIL = "gb_test111@mail.ru";
    final static String ASSERT_TEXT_MAIL = "Письмо отправлено";
    final static String ASSERT_TEXT_LOGIN = "Войти";
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1250, 800));
        webDriverWait = new WebDriverWait(driver, 8);
        driver.get(URL);
    }

    @Test
    public void logIn() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-testid=\"login-input\"]")));
        driver.findElement(By.xpath("//input[@data-testid=\"login-input\"]")).click();
        driver.findElement(By.xpath("//input[@data-testid=\"login-input\"]")).sendKeys(LOGIN);
        driver.findElement(By.xpath("//button[@data-testid=\"enter-password\"]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid=\"login-to-mail\"]")));
        driver.findElement(By.xpath("//input[@data-testid=\"password-input\"]")).click();
        driver.findElement(By.xpath("//input[@data-testid=\"password-input\"]")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[@data-testid=\"login-to-mail\"]")).click();

        webDriverWait.until(el -> el.findElement(By.xpath("//div[text()= 'gb_test111@mail.ru']")));
        assertThat(driver.findElement(By.xpath("//div[text()= 'gb_test111@mail.ru']")), hasText(E_MAIL));
    }

    @Test
    void createAndSendMail() {
        logInMailRu(driver, webDriverWait);
        webDriverWait.until(el -> el.findElement(By.xpath("//a[contains(@href, 'compose')]")));
        driver.findElement(By.xpath("//a[contains(@href, 'compose')]")).click();
        webDriverWait.until(el -> el.findElement(By.xpath("//div[@data-type=\"to\"]//input[@type=\"text\"]")));
        driver.findElement(By.xpath("//div[@data-type=\"to\"]//input[@type=\"text\"]")).sendKeys(E_MAIL);
        driver.findElement(By.xpath("//input[@name=\"Subject\"]")).sendKeys("test subject");
        driver.findElement(By.xpath("//div[@role=\"textbox\"]/div[1]")).click();
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("test");
        driver.findElement(By.xpath("//span[@title=\"Отправить\"]")).click();

        webDriverWait.until(el -> el.findElement(
                By.xpath("//div[@class=\"layer-window__container\"]//a[contains(@href, 'sent')]")));
        assertThat(driver.findElement(By.xpath("//div[@class=\"layer-window__container\"]//a[contains(@href, 'sent')]")),
                hasText(ASSERT_TEXT_MAIL));
    }

    @Test
    void logOut() {
        logInMailRu(driver, webDriverWait);
        webDriverWait.until(el -> el.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")));
        driver.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'logout')]")));
        driver.findElement(By.xpath("//a[contains(@href, 'logout')]")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-testid=\"grid-header\"]//button[text()='Войти']")));
        assertThat(driver.findElement(By.xpath("//div[@data-testid=\"grid-header\"]//button[text()='Войти']")),
                hasText(ASSERT_TEXT_LOGIN));
    }

    @Test
    void createFolder() {
        logInMailRu(driver, webDriverWait);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-qa-id=\"new-folder-btn\"]")));
        driver.findElement(By.xpath("//div[@data-qa-id=\"new-folder-btn\"]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Название\"]")));
        driver.findElement(By.xpath("//input[@placeholder=\"Название\"]")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"Название\"]")).sendKeys("Test_folder");
        driver.findElement(By.xpath("//span[.='Добавить папку']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"nav__folder\"]/div[.='Test_folder']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"nav__folder\"]/div[.='Test_folder']")).isDisplayed());
        deleteFolderMailRu(driver, webDriverWait);
    }

    @Test
    void deleteFolder() {
        createFolderMailRu(driver, webDriverWait);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class=\"nav__folder\"]/div[.='Test_folder']")));
        List<WebElement> webElementListBeforeDeleteFolder
                = driver.findElements(By.xpath("//div[@class=\"nav-folders\"]//a"));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class=\"nav__folder\"]/div[.='Test_folder']")));
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(
                By.xpath("//div[@class=\"nav__folder\"]/div[.='Test_folder']"))).build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Удалить папку']")));
        driver.findElement(By.xpath("//span[.='Удалить папку']")).click();
        driver.findElement(By.xpath("//div[@class=\"layer__submit-button\"]//span[@class=\"button2__txt\"]")).click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[@class=\"nav__folder\"]/div[.='Test_folder']")));
        List<WebElement> webElementListAfterDeleteFolder = driver.findElements(By.xpath("//div[@class=\"nav-folders\"]//a"));
//проверка того, что списки различаются:
//        System.out.println(webElementListBeforeDeleteFolder.size());
//        System.out.println(webElementListAfterDeleteFolder.size());
        assertTrue(webElementListBeforeDeleteFolder.retainAll(webElementListAfterDeleteFolder));
    }

    @Test
    void dragAndDropMailFromInboxToFolder() {
        logIn();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"llc__item llc__item_title\"]")));

        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class=\"llc__content\"]//span[@class=\"ll-sj__normal\"]"));
        WebElement mailElement = webElementList.stream()
                .filter(el -> el.getText().equals("Добро пожаловать в Почту Mail.ru"))
                .findFirst()
                .get();
        System.out.println(mailElement.getText());

        Actions actions = new Actions(driver);
        actions.clickAndHold(mailElement)
                .dragAndDrop(mailElement, driver.findElement(By.xpath("//div[@class=\"nav__folder\"]/div[.='123']")))
                .build()
                .perform();

        //drag-and-drop фактически в браузере не выполняется.. не понятно почему Ассерты работают..
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"nav__folder\"]/div[.='123']")));
        driver.findElement(By.xpath("//div[@class=\"nav__folder\"]/div[.='123']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(mailElement));
        Assertions.assertTrue(mailElement.isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void logInMailRu(WebDriver driver, WebDriverWait webDriverWait) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-testid=\"login-input\"]")));
        driver.findElement(By.xpath("//input[@data-testid=\"login-input\"]")).click();
        driver.findElement(By.xpath("//input[@data-testid=\"login-input\"]")).sendKeys(LOGIN);
        driver.findElement(By.xpath("//button[@data-testid=\"enter-password\"]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid=\"login-to-mail\"]")));
        driver.findElement(By.xpath("//input[@data-testid=\"password-input\"]")).click();
        driver.findElement(By.xpath("//input[@data-testid=\"password-input\"]")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[@data-testid=\"login-to-mail\"]")).click();
    }

    static void createFolderMailRu(WebDriver driver, WebDriverWait webDriverWait) {
        logInMailRu(driver, webDriverWait);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-qa-id=\"new-folder-btn\"]")));
        driver.findElement(By.xpath("//div[@data-qa-id=\"new-folder-btn\"]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Название\"]")));
        driver.findElement(By.xpath("//input[@placeholder=\"Название\"]")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"Название\"]")).sendKeys("Test_folder");
        driver.findElement(By.xpath("//span[.='Добавить папку']")).click();
    }

    static void deleteFolderMailRu(WebDriver driver, WebDriverWait webDriverWait) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"nav__folder\"]/div[.='Test_folder']")));
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.xpath("//div[@class=\"nav__folder\"]/div[.='Test_folder']"))).build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Удалить папку']")));
        driver.findElement(By.xpath("//span[.='Удалить папку']")).click();
        driver.findElement(By.xpath("//div[@class=\"layer__submit-button\"]//span[@class=\"button2__txt\"]")).click();
    }
}
