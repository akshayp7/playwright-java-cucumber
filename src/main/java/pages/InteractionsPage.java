package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class InteractionsPage {
    private Page page;
    private final Locator DRAGGABLE;
    private final Locator DROPPABLE;

    public InteractionsPage(Page page) {
        this.page = page;
        this.DRAGGABLE = page.getByRole(AriaRole.TABPANEL, new Page.GetByRoleOptions().setName("Simple")).locator("#draggable");
        this.DROPPABLE = page.getByRole(AriaRole.TABPANEL, new Page.GetByRoleOptions().setName("Simple")).locator("#droppable");
    }

    public void clickInteractionsNavBar(String navbarOption) {
        this.page.getByText(navbarOption, new Page.GetByTextOptions().setExact(true)).click();
    }

    public void performDragAndDrop() {
        this.DRAGGABLE.hover();
        this.page.mouse().down();
        this.DROPPABLE.hover();
        this.page.mouse().up();
    }

    public boolean verifyDragAndDrop(String dropText) {
        return this.DROPPABLE.textContent().contains(dropText);
    }
}
