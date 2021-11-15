package homeWork6.helpMethods;

import homeWork6.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreConditions {
    final static String LOGIN = "gb_test111";
    final static String PASSWORD = "ttRYyo1OT4o(";
    final static String FOLDER_NAME = "Test_folder";

    public static void logInMailRu(WebDriver driver, WebDriverWait webDriverWait) {
        new MainPage(driver)
                .clickLogin()
                .fillLogin(LOGIN)
                .clickButtonEnterPassword()
                .clickInputPassword()
                .fillPassword(PASSWORD)
                .clickButtonEnter();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(new LeftSideBar(driver).composeButton));
    }

    public static void createFolder(WebDriver driver, WebDriverWait webDriverWait) {
        logInMailRu(driver, webDriverWait);
        new LeftSideBar(driver)
                .clickCreateNewFolder();
        new NewFolderWindow(driver)
                .clickOnFieldName()
                .enterNameFolder(FOLDER_NAME)
                .clickButtonAddFolder();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(new LeftSideBar(driver).testFolder));
    }

    public static void deleteFolder(WebDriver driver) {
        new LeftSideBar(driver)
                .contextClickFolder();
        new FolderContextMenu(driver)
                .clickOnDeleteFolder();
        new AlertDeleteFolder(driver)
                .clickButtonDelete();
    }
}
