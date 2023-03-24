package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ElementsPage;
import pages.InteractionsPage;

public class InteractionsSteps {
    InteractionsPage interactionsPage = new InteractionsPage(DriverFactory.getPage());

    @When("^user clicks \"([^\"]*)\" navbar option in Interactions page$")
    public void clickElementNavBar(String navbarOption) {
        interactionsPage.clickInteractionsNavBar(navbarOption);
    }

    @When("^user performs drag and drop in Droppable section in Interactions page$")
    public void performDragAndDrop() {
        interactionsPage.performDragAndDrop();
    }

    @Then("^verify \"([^\"]*)\" text is displayed after successful drag and drop in Droppable section in Interactions page$")
    public void verifyDragAndDrop(String dropText) {
        Assert.assertTrue(interactionsPage.verifyDragAndDrop(dropText));
    }
}
