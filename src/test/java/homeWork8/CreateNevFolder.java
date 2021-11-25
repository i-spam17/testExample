package homeWork8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static homeWork8.MailRuTestData.*;

public class CreateNevFolder {
    @Given("I click on CreateFolder")
    public void iClickOnCreateFolder() {
        new LeftSideBar().clickCreateNewFolder();
    }

    @And("I enter NameFolder")
    public void iEnterNameFolder() {
        new NewFolderWindow().clickOnFieldName().enterNameFolder(FOLDER_NAME);
    }

    @And("I click button AddFolder")
    public void iClickButtonAddFolder() {
        new NewFolderWindow().clickButtonAddFolder();
    }

    @Then("I see created folder")
    public void iSeeCreatedFolder() {
        new LeftSideBar().testFolder.shouldBe(Condition.visible);
    }
}
