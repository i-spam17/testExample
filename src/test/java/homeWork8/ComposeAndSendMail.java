package homeWork8;

import com.codeborne.selenide.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;

import static homeWork8.MailRuTestData.*;

public class ComposeAndSendMail {
    @Given("I am authorized")
    public static void iAmAuthorized() {
        Selenide.open(URL);
        Selenide.webdriver().driver().getWebDriver().manage().window().setSize(new Dimension(1400, 800));
        new MainPage().clickLogin().fillLogin(LOGIN)
                .clickButtonEnterPassword()
                .clickInputPassword().fillPassword(PASSWORD)
                .clickButtonEnter();
    }

    @Given("I click button Compose")
    public void iClickButtonCompose() {
        new LeftSideBar().clickCreateMail();
    }

    @When("I fill whom")
    public void iFillWhom() {
        new ComposeWindow().fillToWhom(E_MAIL);
    }

    @And("I fill theme")
    public void iFillTheme() {
        new ComposeWindow().fillTheme("test");
    }

    @And("I fill textbox")
    public void iFillTextbox() {
        new ComposeWindow().fillTextBox("test data sldfkjsldkjf");
    }

    @And("I click button sent")
    public void iClickButtonSent() {
        new ComposeWindow().clickSendMail();
    }

    @Then("I see success page")
    public void iSeeSuccessPage() {
        new WindowSuccessSentMail().windowSuccessSentText.shouldBe(Condition.visible);
    }
}
