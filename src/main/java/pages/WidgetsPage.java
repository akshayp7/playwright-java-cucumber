package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class WidgetsPage {
    private Page page;
    private final Locator AUTOCOMPLETE_EDITBOX;
    private final Locator BLUE_COLOUR_TEXT;
    private final Locator HOVER_BUTTON;
    private final Locator TOOL_TIP_TEXT;
    private final Locator OLD_SELECT_MENU;
    private final Locator MULTISELECT_MENU;

    public WidgetsPage(Page page) {
        this.page = page;
        this.AUTOCOMPLETE_EDITBOX = page.locator("#autoCompleteSingleInput");
        this.BLUE_COLOUR_TEXT = page.getByText("Blue", new Page.GetByTextOptions().setExact(true));
        ; //Used to select Blue colour from Autocomplete editbox
        this.HOVER_BUTTON = page.locator("#toolTipButton");
        this.TOOL_TIP_TEXT = page.getByRole(AriaRole.TOOLTIP);
        this.OLD_SELECT_MENU = page.locator("#oldSelectMenu");
        this.MULTISELECT_MENU = page.getByText("Select...");
    }

    public void clickWidgetsNavBar(String navbarOption) {
        this.page.getByText(navbarOption, new Page.GetByTextOptions().setExact(true)).click();
    }

    public void fillAutocompleteTextField(String textValue) {
        this.AUTOCOMPLETE_EDITBOX.fill(textValue);
        this.BLUE_COLOUR_TEXT.click();
    }

    public boolean verifyBlueColourSelected() {
        return this.BLUE_COLOUR_TEXT.isVisible();
    }

    public void hoverOverButton() {
        this.HOVER_BUTTON.hover();  //Hover over element
    }

    public boolean verifyTooltip(String toolTip) {
        return this.TOOL_TIP_TEXT.textContent().equals(toolTip);
    }

    public void oldStyleSelectColour(String colorName) {
        this.OLD_SELECT_MENU.selectOption(colorName);
    }
}
