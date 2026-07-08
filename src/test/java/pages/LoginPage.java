package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.DriverManager;

public class LoginPage extends BasePage {

    private Page page;

    private Locator username;
    private Locator password;
    private Locator loginBtn;
    private Locator logoutLink;

    public LoginPage() {

        this.page = DriverManager.getPage();

        username = page.locator("[name='username']");
        password = page.locator("[name='password']");
        loginBtn = page.locator("//input[@value='Log In']");
        logoutLink = page.locator("//a[text()='Log Out']");
    }

    public void login(String user, String pass) {

        enterText(username, user);
        enterText(password, pass);
        click(loginBtn);
    }

    public boolean isLoginSuccessful() {

        System.out.println(
            page.locator("body").textContent());

        return logoutLink.isVisible();
    }
}