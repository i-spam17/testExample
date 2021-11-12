package homeWork5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.*;
import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;

public class CrmTest {
    final String TEST_NAME_TEXT = "testProject_007";
    final String FIELD_LASTNAME = "test Last Name_005";
    final String FIELD_FIRSTNAME = "test First Name_005";
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    static void login(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/");
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    static void loader(WebDriverWait webDriverWait) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
                "//div[@class=\"loader-mask shown\"]/div[@class=\"loader-frame well\"]")));
    }

    static void deleteWidget(WebDriver driver, WebDriverWait webDriverWait) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@title=\"Последние сообщения\"]/parent::div//a[@title=\"Delete\"]")));
        driver.findElement(By.xpath("//div[@title=\"Последние сообщения\"]/parent::div//a[@title=\"Delete\"]")).click();
        driver.findElement(By.xpath("//a[.='Да, удалить']")).click();
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 800));
        webDriverWait = new WebDriverWait(driver, 8);
        login(driver);
    }

    @Test
    void createProject() {
        Actions actions = new Actions(driver);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li/a/span[text()='Проекты']")));
        actions.moveToElement(driver.findElement(By.xpath("//div/ul/li/a/span[text()='Проекты']"))).build().perform();
        driver.findElement(By.xpath("//span[contains(text(), 'Мои про')]")).click();

        loader(webDriverWait);

        driver.findElement(By.linkText("Создать проект")).click();

        loader(webDriverWait);

        driver.findElement(By.xpath("//input[@data-name='field__name']")).sendKeys(TEST_NAME_TEXT);
        webDriverWait.until(webDriver -> webDriver.findElement(By.xpath("//span[contains(text(), 'Укажите орг')]")));

        driver.findElement(By.xpath("//span[contains(text(), 'Укажите орг')]")).click();
        webDriverWait.until(webDriver -> webDriver.findElement(By.xpath("//div[text()=1234124]")));

        driver.findElement(By.xpath("//div[text()=1234124]")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_project[businessUnit]\"]")).click();
        driver.findElement(By.xpath("//option[contains(text(), 'Research')]")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_project[curator]\"]")).click();
        driver.findElement(By.xpath(
                "//select[@name=\"crm_project[curator]\"]/option[@value=contains(text(), 'Скоробогатова')]")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_project[rp]\"]")).click();
        driver.findElement(By.xpath("//option[contains(text(), 'Ивлев')]")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_project[administrator]\"]")).click();
        driver.findElement(By.xpath("//option[@value=contains(text(), 'Ямутина')]")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_project[manager]\"]")).click();
        driver.findElement(By.xpath("//option[@value=contains(text(), 'Третьяков')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message")));
        Assertions.assertEquals("Проект сохранен", driver.findElement(By.cssSelector("div.message")).getText());
    }

    @Test
    void createPerson() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//a/span[contains(text(), 'Контрагент')]"))).perform();
        driver.findElement(By.xpath("//span[contains(text(), 'Контактные лица')]")).click();

        loader(webDriverWait);
        builder.moveToElement(driver.findElement(By.cssSelector("div.row"))).perform();
        driver.findElement(By.xpath("//a[@title=\"Создать контактное лицо\"]")).click();

        loader(webDriverWait);
        driver.findElement(By.xpath("//input[@name=\"crm_contact[lastName]\"]")).sendKeys(FIELD_LASTNAME);
        driver.findElement(By.xpath("//input[@name=\"crm_contact[firstName]\"]")).sendKeys(FIELD_FIRSTNAME);
        driver.findElement(By.xpath("//span[contains(text(), 'Укажите организац')]")).click();
        webDriverWait.until(element -> element.findElement(By.xpath("//div[contains(text(), '1234124')]")));
        driver.findElement(By.xpath("//div[contains(text(), '1234124')]")).click();
        driver.findElement(By.xpath("//input[@name=\"crm_contact[jobTitle]\"]")).sendKeys("dfghfsghfsgh111");
        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        webDriverWait.until(element -> element.findElement(By.cssSelector("div.message")));
        assertThat(driver.findElement(By.cssSelector("div.message")), hasText("Контактное лицо сохранено"));
    }

    @Test
    void dragAndDropWidget() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id=\"dashboard-column-0\"]//a[.='add a new widget']")));
        driver.findElement(By.xpath("//div[@id=\"dashboard-column-0\"]//a[.='add a new widget']")).click();
        driver.findElement(By.xpath("//strong[.='Последние сообщения']/ancestor::tbody//a[contains(text(), 'Add')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"dashboard-column-0\"]//a[@class=\"move-action\"]")));
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//div[@id=\"dashboard-column-0\"]//a[@class=\"move-action\"]")))
                .dragAndDrop(driver.findElement(By.xpath("//div[@id=\"dashboard-column-0\"]//a[@class=\"move-action\"]")),
                        driver.findElement(By.xpath("//div[@id=\"dashboard-column-1\"]")))
                .build()
                .perform();

        Assertions.assertTrue(driver.findElement(
                By.xpath("//div[@id=\"dashboard-column-1\"]//div[@title=\"Последние сообщения\"]")).isDisplayed());
        deleteWidget(driver, webDriverWait);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
