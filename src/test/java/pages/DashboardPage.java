package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.DriverManager;

public class DashboardPage extends BasePage {

    private Page page;

    private Locator logout;
    private Locator billPay;
    private Locator findTransactions;
    private Locator requestLoan;
    private Locator transferFunds;
    private Locator updateContactInfo;


    public DashboardPage() {

        this.page = DriverManager.getPage();

        logout = page.getByText("Log Out");
        billPay = page.getByText("Bill Pay");
        findTransactions = page.getByText("Find Transactions");
        requestLoan = page.getByText("Request Loan");

        transferFunds = page.getByText("Transfer Funds");
        updateContactInfo = page.getByText("Update Contact Info");

    }

    public void goToBillPay() {

        billPay.waitFor();

        click(billPay);
    }

    public void logout() {

        click(logout);
    }
    public void goToFindTransactions() {

        findTransactions.waitFor();

        click(findTransactions);
    }
    public void goToRequestLoan() {

        requestLoan.waitFor();

        click(requestLoan);
    }
    public void goToTransferFunds() {

        transferFunds.waitFor();

        click(transferFunds);
    }
    public void goToUpdateContactInfo() {

        updateContactInfo.waitFor();

        click(updateContactInfo);
    }


}