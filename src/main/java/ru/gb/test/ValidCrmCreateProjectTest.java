package ru.gb.test;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ValidCrmCreateProjectTest {
    final static String URL = "https://crm.geekbrains.space/user/login";
    final static String LOGIN = "Applanatest1";
    final static String PASSWORD = "Student2020!";
    final static String FIELD_PROJECT_NAME = "htrievperoigjpdgf dlfkgj9";
    final static String ASSERT_TEXT = "Проект сохранен";
    public static WebDriver webDriver;

    public static void main(String[] args) throws InterruptedException {
        setUp();
        logIn();
        createProject();
        textIsValid();
        Thread.sleep(5000);
        logOut();
        webDriver.quit();
        //check-и написал для себя)
    }

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void logIn() {
        webDriver.get(URL);
        webDriver.findElement(By.id("prependedInput")).sendKeys(LOGIN);
        webDriver.findElement(By.id("prependedInput2")).sendKeys(PASSWORD);
        webDriver.findElement(By.id("_submit")).click();
    }

    public static void createProject() throws InterruptedException {
        {
            WebElement webElement = webDriver.findElement(By.xpath("//div/ul/li/a/span[text()='Проекты']"));
            Actions actions = new Actions(webDriver);
            actions.moveToElement(webElement).build().perform();
        }

        webDriver.findElement(By.xpath("//span[contains(text(), 'Мои про')]")).click();

        {
            WebElement webElement = webDriver.findElement(By.cssSelector("div.row"));
            Actions actions = new Actions(webDriver);
            actions.moveToElement(webElement).perform();
        }

        webDriver.findElement(By.linkText("Создать проект")).click();

        webDriver.findElement(By.xpath("//input[@data-name='field__name']")).sendKeys(FIELD_PROJECT_NAME);
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//span[contains(text(), 'Укажите орг')]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//div[text()=1234124]")).click();
        webDriver.findElement(By.xpath("//select[@name=\"crm_project[businessUnit]\"]")).click();
        webDriver.findElement(By.xpath("//option[contains(text(), 'Research')]")).click();
        webDriver.findElement(By.xpath("//select[@name=\"crm_project[curator]\"]")).click();
        webDriver.findElement(
                By.xpath("//select[@name=\"crm_project[curator]\"]/option[@value=contains(text(), 'Скоробогатова')]")).click();
        webDriver.findElement(By.xpath("//select[@name=\"crm_project[rp]\"]")).click();
        webDriver.findElement(By.xpath("//option[contains(text(), 'Ивлев')]")).click();
        webDriver.findElement(By.xpath("//select[@name=\"crm_project[administrator]\"]")).click();
        webDriver.findElement(By.xpath("//option[@value=contains(text(), 'Ямутина')]")).click();
        webDriver.findElement(By.xpath("//select[@name=\"crm_project[manager]\"]")).click();
        webDriver.findElement(By.xpath("//option[@value=contains(text(), 'Третьяков')]")).click();
        webDriver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();
    }

    public static void logOut() {
        webDriver.findElement(By.xpath("//*[@id=\"user-menu\"]/a")).click();
        webDriver.findElement(By.xpath("//a[contains(text(), 'Выйти')]")).click();
    }

    public static void textIsValid() {
        String var = webDriver.findElement(By.cssSelector("div.message")).getText();
        if (var.equals(ASSERT_TEXT)) {
            System.out.println("text VALID");
        } else {
            System.out.println("text INVALID");
        }
    }

}
