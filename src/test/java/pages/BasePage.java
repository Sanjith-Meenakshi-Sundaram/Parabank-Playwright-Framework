package pages;

import com.microsoft.playwright.Locator;
import utils.FrameworkException;

public class BasePage {

    protected void enterText(Locator locator, String value) {
        try {
            locator.fill(value);
        } catch (Exception e) {
            throw new FrameworkException(
                    "❌ Failed to enter text: " + e.getMessage());
        }
    }

    protected void click(Locator locator) {
        try {
            locator.click();
        } catch (Exception e) {
            throw new FrameworkException(
                    "❌ Failed to click element: " + e.getMessage());
        }
    }

    protected String getText(Locator locator) {
        try {
            return locator.textContent();
        } catch (Exception e) {
            throw new FrameworkException(
                    "❌ Failed to get text: " + e.getMessage());
        }
    }
}