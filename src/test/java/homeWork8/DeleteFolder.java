package homeWork8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteFolder {
    @Given("I context click on created folder")
    public void iContextClickOnCreatedFolder() {
        new LeftSideBar().contextClickFolder();
    }

    @And("I choose delete folder")
    public void iChooseDeleteFolder() {
        new FolderContextMenu().clickOnDeleteFolder();
    }

    @And("I click button DeleteFolder")
    public void iClickButtonDeleteFolder() {
        new AlertDeleteFolder().clickButtonDelete();
    }

    @Then("Folder is deleted")
    public void folderIsDeleted() {
        new LeftSideBar().testFolder.shouldBe(Condition.not(Condition.exist));
    }
}
