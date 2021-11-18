package homeWork7;

import homeWork7.help.CustomLoger;
import homeWork7.help.Helpers;
import homeWork7.help.PreConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectAndAllureMailRuTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    final static String URL = "https://mail.ru";
    final static String LOGIN = "gb_test111";
    final static String PASSWORD = "ttRYyo1OT4o(";
    final static String E_MAIL = "gb_test111@mail.ru";
    final static String FOLDER_NAME = "Test_folder";

    @Epic("Тестирование Mail.ru")
//    @Story("Тестирование Mail.ru")
    @TmsLink("link_for_tms")
    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new EventFiringWebDriver(new ChromeDriver(options));
        driver.register(new CustomLoger());
        driver.manage().window().setSize(new Dimension(1440, 1000));
        webDriverWait = new WebDriverWait(driver, 8);
        driver.get(URL);
    }

    @Test
    @DisplayName("Тест аунтификации в аккаунте")
    void logIn() {
        new homeWork6.MainPage(driver)
                .clickLogin()
                .fillLogin(LOGIN)
                .clickButtonEnterPassword()
                .clickInputPassword()
                .fillPassword(PASSWORD)
                .clickButtonEnter();

        webDriverWait.until(ExpectedConditions.visibilityOf(new homeWork6.NavBar(driver).accountField));
        Assertions.assertTrue(new homeWork6.NavBar(driver).accountField.isDisplayed());
    }

    @Test
    @DisplayName("Тест создания и отправки писем")
    void createAndSendMail() {
        PreConditions.logInMailRu(driver, webDriverWait);

        new homeWork6.LeftSideBar(driver)
                .clickCreateMail();
        new ComposeWindow(driver)
                .fillToWhom(E_MAIL)
                .fillTheme("sdf")
                .fillTextBox("sdfjklkj sdkflkj")
                .clickSendMail();

        webDriverWait.until(ExpectedConditions.visibilityOf(new homeWork6.WindowSuccessSentMail(driver).windowSuccessSentText));
        Assertions.assertTrue(new WindowSuccessSentMail(driver).windowSuccessSentText.isDisplayed());
    }

    @Test
    @DisplayName("Тест выхода из аккаунта")
    void logOut() {
        PreConditions.logInMailRu(driver, webDriverWait);

        new NavBar(driver)
                .clickAccount();
        new RightSideBar(driver)
                .clickFieldLogout();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(new MainPage(driver).buttonEnterPassword));
        Assertions.assertTrue(new MainPage(driver).buttonEnterPassword.isDisplayed());
    }

    @Test
    @Feature("User folder")
    @DisplayName("Тест создания новой папки для писем")
    void createFolder() {
        PreConditions.logInMailRu(driver, webDriverWait);

        new homeWork6.LeftSideBar(driver)
                .clickCreateNewFolder();
        new NewFolderWindow(driver)
                .clickOnFieldName()
                .enterNameFolder(FOLDER_NAME)
                .clickButtonAddFolder();

        webDriverWait.until(ExpectedConditions.visibilityOf(new homeWork6.LeftSideBar(driver).testFolder));
        Assertions.assertTrue(new homeWork6.LeftSideBar(driver).testFolder.isDisplayed());

        PreConditions.deleteFolder(driver);
    }

    @Test
    @DisplayName("Тест удаления созданной папки для писем")
    void deleteFolder() throws InterruptedException {
        PreConditions.createFolder(driver, webDriverWait);

        new homeWork6.LeftSideBar(driver)
                .contextClickFolder();
        new FolderContextMenu(driver)
                .clickOnDeleteFolder();
        new AlertDeleteFolder(driver)
                .clickButtonDelete();

        //не смог победить проблему: как дождаться того что элемент удален...((
        //        webDriverWait.until(ExpectedConditions.invisibilityOf(new LeftSideBar(driver).testFolder));
        Thread.sleep(2000);
        Assertions.assertFalse(Helpers.isElementExist(new homeWork6.LeftSideBar(driver).testFolder, "Test_folder"));
    }

    @Test
    @Feature("dragAndDrop")
    @DisplayName("Тест перетаскивания писем в папку")
    void dragAndDropMailFromInboxToFolder() {
        PreConditions.logInMailRu(driver, webDriverWait);

        new FieldOfListOfMails(driver)
                .dragAndDropMailInFolder();
        new LeftSideBar(driver)
                .clickOnFolderForDragAndDrop();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Создать фильтр']")));
        Assertions.assertTrue(Helpers.getElement(new FolderForDragAndDrop(driver)
                .mailsFolderForDragAndDrop, "Добро пожаловать в Почту Mail.ru").isDisplayed());
    }

    @AfterEach
    void tearDown() {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry browserLog : browserLogs) {
            Allure.addAttachment("Лог в консоли браузера", browserLog.getMessage());
        }

        driver.quit();
    }
}
