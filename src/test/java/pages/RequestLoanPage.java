package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import utils.DriverManager;

public class RequestLoanPage extends BasePage {

    private Page page;

    private Locator amount;
    private Locator downPayment;
    private Locator fromAccount;
    private Locator applyNowBtn;
    private Locator loanStatus;

    public RequestLoanPage() {

        page = DriverManager.getPage();

        amount = page.locator("#amount");
        downPayment = page.locator("#downPayment");
        fromAccount = page.locator("#fromAccountId");
        applyNowBtn = page.locator("input[value='Apply Now']");
        loanStatus = page.locator("#loanStatus");
    }

    public String requestLoan() {

        enterText(amount, "5000");

        enterText(downPayment, "100");

        fromAccount.selectOption(
                new SelectOption().setIndex(0));

        click(applyNowBtn);

        loanStatus.waitFor();

        return getText(loanStatus);
    }
}