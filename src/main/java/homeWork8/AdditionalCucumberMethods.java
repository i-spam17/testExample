package homeWork8;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.java.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.logging.LogType;
import ru.yandex.qatools.allure.cucumberjvm.AllureReporter;

@RunWith(Cucumber.class)
public class AdditionalCucumberMethods {
    @Before
    public void before() {
        AllureReporter.applyFailureCallback(FailureCallback.class);
    }

    @After
    public void after() {
        Selenide.getWebDriverLogs(LogType.BROWSER);
        Selenide.closeWebDriver();
    }
}
