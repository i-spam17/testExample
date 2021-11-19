package hw6;

import homeWork6.*;
import homeWork6.helpMethods.Helpers;
import homeWork6.helpMethods.PreConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectMailRuTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    final static String URL = "https://mail.ru";
    final static String LOGIN = "gb_test111";
    final static String PASSWORD = "ttRYyo1OT4o(";
    final static String E_MAIL = "gb_test111@mail.ru";
    final static String FOLDER_NAME = "Test_folder";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 1000));
        webDriverWait = new WebDriverWait(driver, 8);
        driver.get(URL);
    }

    @Test
    void logIn() {
        new MainPage(driver)
                .clickLogin()
                .fillLogin(LOGIN)
                .clickButtonEnterPassword()
                .clickInputPassword()
                .fillPassword(PASSWORD)
                .clickButtonEnter();

        webDriverWait.until(ExpectedConditions.visibilityOf(new NavBar(driver).accountField));
        Assertions.assertTrue(new NavBar(driver).accountField.isDisplayed());
    }

    @Test
    void createAndSendMail() {
        PreConditions.logInMailRu(driver, webDriverWait);

        new LeftSideBar(driver)
                .clickCreateMail();
        new ComposeWindow(driver)
                .fillToWhom(E_MAIL)
                .fillTheme("sdf")
                .fillTextBox("sdfjklkj sdkflkj")
                .clickSendMail();

        webDriverWait.until(ExpectedConditions.visibilityOf(new WindowSuccessSentMail(driver).windowSuccessSentText));
        Assertions.assertTrue(new WindowSuccessSentMail(driver).windowSuccessSentText.isDisplayed());
    }

    @Test
    void logOut() {
        PreConditions.logInMailRu(driver, webDriverWait);

        new NavBar(driver)
                .clickAccount();
        new RightSideBar(driver)
                .clickFieldLogout();

        Assertions.assertTrue(new MainPage(driver).buttonEnterPassword.isDisplayed());
    }

    @Test
    void createFolder() {
        PreConditions.logInMailRu(driver, webDriverWait);

        new LeftSideBar(driver)
                .clickCreateNewFolder();
        new NewFolderWindow(driver)
                .clickOnFieldName()
                .enterNameFolder(FOLDER_NAME)
                .clickButtonAddFolder();

        webDriverWait.until(ExpectedConditions.visibilityOf(new LeftSideBar(driver).testFolder));
        Assertions.assertTrue(new LeftSideBar(driver).testFolder.isDisplayed());

        PreConditions.deleteFolder(driver);
    }

    @Test
    void deleteFolder() throws InterruptedException {
        PreConditions.createFolder(driver, webDriverWait);

        new LeftSideBar(driver)
                .contextClickFolder();
        new FolderContextMenu(driver)
                .clickOnDeleteFolder();
        new AlertDeleteFolder(driver)
                .clickButtonDelete();

        //не смог победить проблему: как дождаться того что элемент удален...((
        //        webDriverWait.until(ExpectedConditions.invisibilityOf(new LeftSideBar(driver).testFolder));
        Thread.sleep(2000);
        Assertions.assertFalse(Helpers.isElementExist(new LeftSideBar(driver).testFolder, "Test_folder"));
    }

    @Test
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
        driver.quit();
    }
}
