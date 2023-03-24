package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.WidgetsPage;

public class WidgetsSteps {
    WidgetsPage widgetsPage = new WidgetsPage(DriverFactory.getPage());

    @When("^user clicks \"([^\"]*)\" navbar option in Widgets page$")
    public void clickElementNavBar(String navbarOption) {
        widgetsPage.clickWidgetsNavBar(navbarOption);
    }

    @When("^user enters \"([^\"]*)\" in Single color name edit box in Auto Complete section in Widgets page$")
    public void fillAutocompleteTextField(String textValue) {
        widgetsPage.fillAutocompleteTextField(textValue);
    }

    @Then("^verify Blue color is selected in Single color name in Auto Complete section in Widgets page$")
    public void verifyBlueColourSelected() {
        Assert.assertTrue(widgetsPage.verifyBlueColourSelected());
    }

    @When("^user hovers over button in Tool Tips section in Widgets page$")
    public void hoverOverButton() {
        widgetsPage.hoverOverButton();
    }

    @Then("^verify \"([^\"]*)\" tooltip is displayed in Tool Tips section in Widgets page$")
    public void verifyTooltip(String toolTip) {
        Assert.assertTrue(widgetsPage.verifyTooltip(toolTip));
    }

    @When("^user selects \"([^\"]*)\" in Old Style Select Menu in Select Menu section in Widgets page$")
    public void oldStyleSelectColour(String colorName) {
        widgetsPage.oldStyleSelectColour(colorName);
    }

}
