package pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ElementsPage {
    private Page page;
    private final Locator FULL_NAME_EDITBOX;
    private final Locator SUBMIT_BUTTON;
    private final Locator SUBMITTED_TEXT;
    private final Locator HOME_CHECK_BOX;
    private final Locator HOME_SELECTED_TEXT;
    private final Locator NO_RADIO_BUTTON;
    private final Locator WEB_TABLES_HEADER;
    private final Locator WEB_TABLES_EDIT_ICON;
    private final Locator REGISTRATION_FORM_HEADER;
    private final Locator REGISTRATION_FORM_CLOSE_BUTTON;
    private final Locator DOUBLE_CLICK_BUTTON;
    private final Locator DOUBLE_CLICK_TEXT;
    private final Locator RIGHT_CLICK_BUTTON;
    private final Locator RIGHT_CLICK_TEXT;
    private final Locator HOME_LINK;
    private final Locator DOWNLOAD_BUTTON;
    private final Locator UPLOAD_BUTTON;
    private final Locator UPLOADED_FILE_TEXT;

    public ElementsPage(Page page) {
        this.page = page;
        this.FULL_NAME_EDITBOX = page.getByPlaceholder("Full Name");
        this.SUBMIT_BUTTON = page.getByText("Submit");
        this.SUBMITTED_TEXT = page.getByText("Name:AutoTest", new Page.GetByTextOptions().setExact(true)); // Matches exact text
        this.HOME_CHECK_BOX = page.getByText("Home");
        this.HOME_SELECTED_TEXT = page.locator(".display-result");
        this.NO_RADIO_BUTTON = page.locator("#noRadio"); // Using CSS Selector
        this.WEB_TABLES_HEADER = page.getByRole(AriaRole.COLUMNHEADER);
        this.WEB_TABLES_EDIT_ICON = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Cierra")).getByTitle("Edit").locator("svg"); // Chaining Locators
        this.REGISTRATION_FORM_HEADER = page.getByText("Registration Form");
        this.REGISTRATION_FORM_CLOSE_BUTTON = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close"));
        this.DOUBLE_CLICK_BUTTON = page.locator("#doubleClickBtn");
        this.DOUBLE_CLICK_TEXT = page.getByText("You have done a double click");
        this.RIGHT_CLICK_BUTTON = page.locator("#rightClickBtn");
        this.RIGHT_CLICK_TEXT = page.getByText("You have done a right click");
        this.HOME_LINK = page.getByText("Home", new Page.GetByTextOptions().setExact(true));
        this.DOWNLOAD_BUTTON = page.locator("#downloadButton");
        this.UPLOAD_BUTTON = page.locator("#uploadFile");
        this.UPLOADED_FILE_TEXT = page.getByText("sampleFile.jpeg");
    }

    public void clickElementNavBar(String navbarOption) {
        this.page.getByText(navbarOption, new Page.GetByTextOptions().setExact(true)).click();
    }

    public void enterFullName(String fullName) {
        this.FULL_NAME_EDITBOX.fill(fullName);
    }

    public void clickSubmit() {
        this.SUBMIT_BUTTON.click();
    }

    public boolean verifySubmittedText() {
        return this.SUBMITTED_TEXT.isVisible();
    }

    public void clickHomeCheckBox() {
        this.HOME_CHECK_BOX.click();
    }

    public boolean verifyCheckboxSelectedText(String checkBoxText) {
        return this.HOME_SELECTED_TEXT.textContent().contains(checkBoxText);
    }

    public boolean verifyNoRadioButtonDisabled() {
        return this.NO_RADIO_BUTTON.isDisabled();
    }

    public boolean verifyFirstColumnTableHeader(String headerName) {
        String[] headerTexts = this.WEB_TABLES_HEADER.allTextContents().toArray(new String[0]);
        return headerTexts[0].equals(headerName);
    }

    public void editCierraEntry() {
        this.WEB_TABLES_EDIT_ICON.click();
    }

    public boolean verifyRegistrationForm() {
        return this.REGISTRATION_FORM_HEADER.isVisible();
    }

    public void registrationFormClose() {
        this.REGISTRATION_FORM_CLOSE_BUTTON.click();
    }

    public void performClick(String clickType) {
        switch (clickType.toLowerCase()) {
            case "double":
                this.DOUBLE_CLICK_BUTTON.dblclick();
                break;
            case "right":
                this.RIGHT_CLICK_BUTTON.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
                break;
        }
    }

    public boolean verifyClickSuccessMsg(String clickType) {
        boolean status = false;
        switch (clickType.toLowerCase()) {
            case "double":
                status = this.DOUBLE_CLICK_TEXT.isVisible();
                break;
            case "right":
                status = this.RIGHT_CLICK_TEXT.isVisible();
                break;
        }
        return status;
    }

    public void verifyFileDownload() {
        //Path for Downloads folder from root of project
        String downloadsDirectory = System.getProperty("user.dir") + "/Downloads/";
        // Wait for the download to start and perform the action that initiates download Lambda expression
        Download download = page.waitForDownload(this.DOWNLOAD_BUTTON::click);
        // Wait for the download process to complete
        Path path = download.path();
        // Save downloaded file in Downloads directory
        download.saveAs(Paths.get(downloadsDirectory + download.suggestedFilename()));
    }

    public void performFileUpload(String fileName) {
        String uploadFilePath = System.getProperty("user.dir") + "/src/main/java/utils/functional/" + fileName;
        this.UPLOAD_BUTTON.setInputFiles(Paths.get(uploadFilePath));
    }

    public boolean verifyFileUpload(String fileName) {
        return this.page.getByText(fileName).isVisible();
    }
}
