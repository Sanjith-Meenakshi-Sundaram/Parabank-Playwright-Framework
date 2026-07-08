package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.DriverManager;

public class UpdateContactInfoPage extends BasePage {

    private Page page;

    private Locator firstName;
    private Locator updateProfileBtn;
    private Locator successMsg;

    public UpdateContactInfoPage() {

        page = DriverManager.getPage();

        firstName = page.locator("#customer\\.firstName");

        updateProfileBtn =
                page.locator("input[value='Update Profile']");

        successMsg =
                page.getByText("Profile Updated");
    }

    public boolean updateContactInfo() {

        enterText(firstName, "meenakshi");

        click(updateProfileBtn);

        return page.content().contains("Profile Updated");
    }
}