package homeWork8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOut {
    @Given("I click button Account")
    public void iClickButtonAccount() {
        new NavBar().clickAccount();
    }

    @When("I click Exit")
    public void iClickExit() {
        new RightSideBar().clickFieldLogout();
    }

    @Then("I see Main page")
    public void iSeeMainPage() {
        new MainPage().inputLogin.shouldBe(Condition.visible);
    }
}
