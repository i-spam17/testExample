package ru.gb.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ValidCrmCreatePersonTest {
    final static String URL = "https://crm.geekbrains.space/user/login";
    final static String LOGIN = "Applanatest1";
    final static String PASSWORD = "Student2020!";
    final static String FIELD_FIRSTNAME = "htrievperoigjpdgf_3";
    final static String FIELD_LASTNAME = "htrievperoigjpdgf_3";
    final static String ASSERT_TEXT = "Контактное лицо сохранено";
    public static WebDriver webDriver;


    public static void main(String[] args) throws InterruptedException {
        setUp();
        logIn();
        createPerson();
        textIsValid();
        Thread.sleep(5000);
        logOut();

        webDriver.quit();
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

    public static void createPerson() throws InterruptedException {
        {
            WebElement element = webDriver.findElement(By.xpath("//a/span[contains(text(), 'Контрагент')]"));
            Actions builder = new Actions(webDriver);
            builder.moveToElement(element).perform();
        }
        webDriver.findElement(By.xpath("//span[contains(text(), 'Контактные лица')]")).click();
        {
            WebElement element = webDriver.findElement(By.cssSelector("div.row"));
            Actions builder = new Actions(webDriver);
            builder.moveToElement(element).perform();
        }
        webDriver.findElement(By.xpath("//a[@title=\"Создать контактное лицо\"]")).click();
        webDriver.findElement(By.xpath("//input[@name=\"crm_contact[lastName]\"]")).sendKeys(FIELD_LASTNAME);
        webDriver.findElement(By.xpath("//input[@name=\"crm_contact[firstName]\"]")).sendKeys(FIELD_FIRSTNAME);
        webDriver.findElement(By.xpath("//span[contains(text(), 'Укажите организац')]")).click();
        webDriver.findElement(By.xpath("//div[contains(text(), '1234124')]")).click();
        webDriver.findElement(By.xpath("//input[@name=\"crm_contact[jobTitle]\"]")).sendKeys("dfghfsghfsgh111");
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
