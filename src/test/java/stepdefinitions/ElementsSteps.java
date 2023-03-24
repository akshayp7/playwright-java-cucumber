package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ElementsPage;

public class ElementsSteps {
    ElementsPage elementsPage = new ElementsPage(DriverFactory.getPage());

    @When("^user clicks \"([^\"]*)\" navbar option in Elements page$")
    public void clickElementNavBar(String navbarOption) {
        elementsPage.clickElementNavBar(navbarOption);
    }

    @When("^user enters \"([^\"]*)\" in Full Name Edit box in Elements page$")
    public void enterFullName(String fullName) {
        elementsPage.enterFullName(fullName);
    }

    @When("^user clicks Submit in Text Box section in Elements page$")
    public void clickSubmit() {
        elementsPage.clickSubmit();
    }

    @Then("^verify submitted text is displayed in Text Box section in Elements page$")
    public void verifySubmittedText() {
        Assert.assertTrue(elementsPage.verifySubmittedText());
    }

    @When("^user clicks on Home checkbox in Check Box section in Elements page$")
    public void clickHomeCheckBox() {
        elementsPage.clickHomeCheckBox();
    }

    @Then("^verify that \"([^\"]*)\" checkbox selected text is displayed in Check Box section in Elements page$")
    public void verifyCheckboxSelectedText(String checkBoxText) {
        Assert.assertTrue(elementsPage.verifyCheckboxSelectedText(checkBoxText));
    }

    @Then("^verify that No radio button is disabled in Radio Button section in Elements page$")
    public void verifyNoRadioButtonDisabled() {
        Assert.assertTrue(elementsPage.verifyNoRadioButtonDisabled());
    }

    @Then("^verify that \"([^\"]*)\" is first column header in Web Tables section in Elements page$")
    public void verifyFirstColumnTableHeader(String headerName) {
        Assert.assertTrue(elementsPage.verifyFirstColumnTableHeader(headerName));
    }

    @When("^user edits Cierra entry in Web Tables section in Elements page$")
    public void editCierraEntry() {
        elementsPage.editCierraEntry();
    }

    @Then("^user verifies Registration Form is displayed in Web Tables section in Elements page$")
    public void verifyRegistrationForm() {
        Assert.assertTrue(elementsPage.verifyRegistrationForm());
    }

    @When("^user clicks on Close button in Registration Form in Web Tables section in Elements page$")
    public void registrationFormClose() {
        elementsPage.registrationFormClose();
    }

    @When("^user performs \"([^\"]*)\" click in Buttons section in Elements page$")
    public void performClick(String clickType) {
        elementsPage.performClick(clickType);
    }

    @Then("^user verifies \"([^\"]*)\" click success message in Buttons section in Elements page$")
    public void verifyClickSuccessMsg(String clickType) {
        Assert.assertTrue(elementsPage.verifyClickSuccessMsg(clickType));
    }

    @Then("^verify user is able to download file in Upload and Download section in Elements page$")
    public void verifyFileDownload() {
        elementsPage.verifyFileDownload();
    }

    @Then("^user uploads \"([^\"]*)\" file in Upload and Download section in Elements page$")
    public void performFileUpload(String fileName) {
        elementsPage.performFileUpload(fileName);
    }

    @Then("^verify \"([^\"]*)\" is uploaded successfully in Upload and Download section in Elements page$")
    public void verifyFileUpload(String fileName) {
        Assert.assertTrue(elementsPage.verifyFileUpload(fileName));
    }

}
