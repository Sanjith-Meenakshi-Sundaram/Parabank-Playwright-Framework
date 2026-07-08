package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import utils.DriverManager;

public class TransferFundsPage extends BasePage {

    private Page page;

    private Locator amount;
    private Locator fromAccount;
    private Locator toAccount;
    private Locator transferBtn;
    private Locator successMsg;

    public TransferFundsPage() {

        page = DriverManager.getPage();

        amount = page.locator("#amount");
        fromAccount = page.locator("#fromAccountId");
        toAccount = page.locator("#toAccountId");

        transferBtn = page.locator("input[value='Transfer']");

        successMsg =
                page.locator("h1:has-text('Transfer Complete')");
    }

    public boolean transferFunds() {

        enterText(amount, "100");

        fromAccount.selectOption(
                new SelectOption().setIndex(0));

        toAccount.selectOption(
                new SelectOption().setIndex(0));

        click(transferBtn);

        successMsg.waitFor();

        return successMsg.isVisible();
    }
}
