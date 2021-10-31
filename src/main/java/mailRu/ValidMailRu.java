package mailRu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ValidMailRu {
    final static String URL = "https://mail.ru";
    final static String LOGIN = "gb_test111";
    final static String PASSWORD = "ttRYyo1OT4o(";
    final static String E_MAIL = "gb_test111@mail.ru";
    final static String ASSERT_TEXT_MAIL = "Письмо отправлено";
    final static String ASSERT_TEXT_LOGIN = "Войти";
    public static WebDriver webDriver;
    public static JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException {
        setUp();
        logIn();
        checkLogIn();
        Thread.sleep(5000);
        createAndSendMail();
        checkSendMail();
        Thread.sleep(5000);
        logOut();
        checkLogOut();
        webDriver.quit();
    }

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js = (JavascriptExecutor) webDriver;
        webDriver.get(URL);
    }

    public static void logIn() {
        webDriver.findElement(By.xpath("//input[@data-testid=\"login-input\"]")).click();
        webDriver.findElement(By.xpath("//input[@data-testid=\"login-input\"]")).sendKeys(LOGIN);
        webDriver.findElement(By.xpath("//button[@data-testid=\"enter-password\"]")).click();
        webDriver.findElement(By.xpath("//input[@data-testid=\"password-input\"]")).sendKeys(PASSWORD);
        webDriver.findElement(By.xpath("//button[@data-testid=\"login-to-mail\"]")).click();
    }

    public static void createAndSendMail() throws InterruptedException {
        webDriver.findElement(By.xpath("//a[contains(@href, 'compose')]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//div[@data-type=\"to\"]//input[@type=\"text\"]")).sendKeys(E_MAIL);
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).sendKeys("test subject");
        webDriver.findElement(By.xpath("//div[@role=\"textbox\"]/div[1]")).click();
        {
            WebElement element = webDriver.findElement(By.xpath("//div[@role=\"textbox\"]"));
            js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText =" +
                    " '<div>test_data test_data test_data </div>'}", element);
        }
        webDriver.findElement(By.xpath("//span[@title=\"Отправить\"]")).click();
    }

    public static void logOut() {
        webDriver.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")).click();
        webDriver.findElement(By.xpath("//a[contains(@href, 'logout')]")).click();
    }

    public static void checkLogIn() {
        String var1 = webDriver.findElement(By.xpath("//div[text()= 'gb_test111@mail.ru']")).getText();
        if (var1.equals(E_MAIL)) {
            System.out.println("logIn successful");
        } else {
            System.out.println("logIn INVALID");
        }
    }

    public static void checkSendMail() {
        String var2 = webDriver.findElement(
                By.xpath("//div[@class=\"layer-window__container\"]//a[contains(@href, 'sent')]")).getText();
        if (var2.equals(ASSERT_TEXT_MAIL)) {
            System.out.println("e-mail send successful");
        } else {
            System.out.println("e=mail NOT send!!!");
        }
    }

    public static void checkLogOut() {
        String var3 = webDriver.findElement(
                By.xpath("//div[@data-testid=\"grid-header\"]//button[text()='Войти']")).getText();
        if (var3.equals(ASSERT_TEXT_LOGIN)) {
            System.out.println("logOut successful");
        } else {
            System.out.println("logOut INVALID");
        }
    }
}
