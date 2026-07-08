package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.DriverManager;

public class FindTransactionPage extends BasePage {

    private Page page;

    private Locator transactionId;
    private Locator findByIdBtn;
    private Locator creditColumn;

    public FindTransactionPage() {

        page = DriverManager.getPage();

        transactionId = page.locator("#transactionId");

        findByIdBtn = page.locator("#findById");

        creditColumn = page.getByText("Credit (+)");
    }

    public void findTransaction(String txnId) {

        enterText(transactionId, txnId);

        click(findByIdBtn);
    }

    public boolean isCreditColumnDisplayed() {

        try {

            creditColumn.waitFor();

            return creditColumn.isVisible();

        } catch (Exception e) {

            return false;
        }
    }
}
