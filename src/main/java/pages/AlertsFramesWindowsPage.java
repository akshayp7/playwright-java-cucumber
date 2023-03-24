package pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AlertsFramesWindowsPage {
    private Page page;
    private BrowserContext context;
    private final Locator NEW_TAB_BUTTON;
    private final Locator NEW_WINDOW_BUTTON;
    private final Locator PROMPT_ALERT_BUTTON;
    private final Locator PROMPT_RESULT;
    private final Locator FRAME_LOCATOR;
    private final Locator NESTED_CHILDFRAME_LOCATOR;

    public AlertsFramesWindowsPage(Page page, BrowserContext context) {
        this.page = page;
        this.context = context;
        this.NEW_TAB_BUTTON = page.getByText("New Tab");
        this.NEW_WINDOW_BUTTON = page.getByText("New Window", new Page.GetByTextOptions().setExact(true));
        this.PROMPT_ALERT_BUTTON = page.locator("#promtButton");
        this.PROMPT_RESULT = page.locator("#promptResult");
        this.FRAME_LOCATOR = page.frameLocator("#frame2").locator("#sampleHeading");
        //Nested Iframe Locator
        this.NESTED_CHILDFRAME_LOCATOR = page.frameLocator("#frame1").frameLocator("iframe").getByText("Child Iframe");
    }


    public void clickAlertFrameWinNavBar(String navbarOption) {
        this.page.getByText(navbarOption, new Page.GetByTextOptions().setExact(true)).click();
    }

    public boolean verifyNewTabURL(String newTabURL) {
        // Get page after a specific action (e.g. clicking a link)
        Page newPage = this.context.waitForPage(() -> {
            this.NEW_TAB_BUTTON.click(); // Opens a new tab
        });
        newPage.waitForLoadState();
        String newPageURL = newPage.url();
        newPage.close();
        return (newPageURL.equals(newTabURL));
    }

    public boolean verifyNewWinURL(String newWinURL) {
        // Get page after a specific action (e.g. clicking a link)
        Page newPage = this.context.waitForPage(() -> {
            this.NEW_WINDOW_BUTTON.click(); // Opens a new tab
        });
        newPage.waitForLoadState();
        String newPageURL = newPage.url();
        newPage.close();
        return (newPageURL.equals(newWinURL));
    }

    public void enterTextAndAcceptAlert(String alertText) {
        this.page.onDialog(dialog -> dialog.accept(alertText));
        this.PROMPT_ALERT_BUTTON.click();
    }

    public boolean verifyAlertText(String alertText) {
        return this.PROMPT_RESULT.textContent().contains(alertText);
    }

    public boolean verifyFrameText(String frameText) {
        return this.FRAME_LOCATOR.textContent().contains(frameText);
    }

    public boolean verifyNestedFrameChildText() {
        return this.NESTED_CHILDFRAME_LOCATOR.isVisible();
    }
}
