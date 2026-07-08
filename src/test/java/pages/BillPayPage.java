package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import utils.DriverManager;

public class BillPayPage extends BasePage {

    private Page page;

    private Locator payeeName;
    private Locator address;
    private Locator city;
    private Locator state;
    private Locator zip;
    private Locator phone;
    private Locator account;
    private Locator confirmAccount;
    private Locator amount;
    private Locator accountDropdown;
    private Locator sendPaymentBtn;
    private Locator successMsg;

    public BillPayPage() {

        this.page = DriverManager.getPage();

        payeeName = page.locator("[name='payee.name']");
        address = page.locator("[name='payee.address.street']");
        city = page.locator("[name='payee.address.city']");
        state = page.locator("[name='payee.address.state']");
        zip = page.locator("[name='payee.address.zipCode']");
        phone = page.locator("[name='payee.phoneNumber']");
        account = page.locator("[name='payee.accountNumber']");
        confirmAccount = page.locator("[name='verifyAccount']");
        amount = page.locator("[name='amount']");
        accountDropdown = page.locator("[name='fromAccountId']");
        sendPaymentBtn = page.locator("input[value='Send Payment']");
        successMsg = page.locator("h1:has-text('Bill Payment Complete')");
    }

    public boolean performBillPayment() {

        enterText(payeeName, "Electricity Board");
        enterText(address, "Anna Nagar");
        enterText(city, "Chennai");
        enterText(state, "TN");
        enterText(zip, "600028");
        enterText(phone, "9876543210");

        enterText(account, "123456");
        enterText(confirmAccount, "123456");

        enterText(amount, "200");

        accountDropdown.selectOption(
                new SelectOption().setIndex(0));

        click(sendPaymentBtn);

        successMsg.waitFor();

        return successMsg.isVisible();
    }
}
