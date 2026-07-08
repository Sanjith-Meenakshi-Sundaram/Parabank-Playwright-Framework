package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.DriverManager;

public class RegisterPage extends BasePage {

    private Page page;

    private Locator firstName;
    private Locator lastName;
    private Locator address;
    private Locator city;
    private Locator state;
    private Locator zip;
    private Locator phone;
    private Locator ssn;
    private Locator username;
    private Locator password;
    private Locator confirmPassword;
    private Locator registerBtn;
    private Locator successMsg;

    public RegisterPage() {

        this.page = DriverManager.getPage();

        firstName = page.locator("#customer\\.firstName");
        lastName = page.locator("#customer\\.lastName");
        address = page.locator("#customer\\.address\\.street");
        city = page.locator("#customer\\.address\\.city");
        state = page.locator("#customer\\.address\\.state");
        zip = page.locator("#customer\\.address\\.zipCode");
        phone = page.locator("#customer\\.phoneNumber");
        ssn = page.locator("#customer\\.ssn");
        username = page.locator("#customer\\.username");
        password = page.locator("#customer\\.password");
        confirmPassword = page.locator("#repeatedPassword");

        registerBtn = page.locator("input[value='Register']");
        successMsg = page.locator("p.smallText");
    }

    public String registerUser(String user) {

        enterText(firstName, "Meena");
        enterText(lastName, "Sundaram");
        enterText(address, "Chennai Street");
        enterText(city, "Chennai");
        enterText(state, "TN");
        enterText(zip, "600001");
        enterText(phone, "9876543210");
        enterText(ssn, "12345");

        enterText(username, user);
        enterText(password, "pass1234");
        enterText(confirmPassword, "pass1234");

        click(registerBtn);

        successMsg.waitFor();

        return getText(successMsg);
    }
}