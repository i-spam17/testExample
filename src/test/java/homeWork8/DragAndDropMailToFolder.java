package homeWork8;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class DragAndDropMailToFolder {
    @Given("I drag and drop mail in to folder")
    public void iDragAndDropMailInToFolder() {
        new FieldOfListOfMails().dragAndDropMailInFolder();
    }

    @And("I click in DnD folder")
    public void iClickInDnDFolder() {
        new LeftSideBar().clickOnFolderForDragAndDrop();
    }

    @Then("I see moving mail")
    public void iSeeMovingMail() {
        Assertions.assertTrue(new FolderForDragAndDrop().isMailExist());
    }
}
