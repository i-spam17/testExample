package homeWork8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static homeWork8.MailRuTestData.*;

public class LogIn {
    @Given("^I go to URL$")
    public void iGoToURL() {
        Selenide.open(URL);
    }

    @When("^I fill login$")
    public void iFillLogin() {
        new MainPage().clickLogin().fillLogin(LOGIN);
    }

    @And("I click button Enter password")
    public void iClickButtonEnterPassword() {
        new MainPage().clickButtonEnterPassword();
    }

    @And("^I fill password$")
    public void iFillPassword() {
        new MainPage().clickInputPassword().fillPassword(PASSWORD);
    }

    @And("I click button Enter")
    public void iClickButtonEnter() {
        new MainPage().clickButtonEnter();
    }

    @Then("^I see inbox page$")
    public void iSeeInboxPage() {
        new NavBar().accountField.shouldBe(Condition.visible);
    }
}
