package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.BillPayPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.DriverManager;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class EndToEndTest extends BaseTest {

    @Test
    public void testEndToEndFlow() {

        ExtentReports extent = ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("TC09: END TO END FLOW");

        try {

            DriverManager.getPage().navigate(
                    "https://parabank.parasoft.com/parabank/register.htm");

            RegisterPage reg = new RegisterPage();

            String username =
                    "user" + System.currentTimeMillis();

            String msg =
                    reg.registerUser(username);

            Assertions.assertTrue(
                    msg != null && !msg.isEmpty(),
                    "Registration failed");

            test.pass("✅ Registration successful");

            DashboardPage dash = new DashboardPage();

            dash.logout();

            test.pass("✅ Logged out after registration");

            DriverManager.getPage().navigate(
                    "https://parabank.parasoft.com/parabank/index.htm");

            LoginPage login = new LoginPage();

            login.login(username, "pass1234");

            Assertions.assertTrue(
                    login.isLoginSuccessful(),
                    "Login failed");

            test.pass("✅ Login successful");

            dash = new DashboardPage();

            dash.goToBillPay();

            test.pass("✅ Navigated to Bill Pay");

            BillPayPage bill = new BillPayPage();

            boolean status =
                    bill.performBillPayment();

            Assertions.assertTrue(
                    status,
                    "Bill Payment failed");

            test.pass("✅ Bill payment successful");

            dash = new DashboardPage();

            dash.logout();

            test.pass("✅ Logged out successfully");

            test.pass(
                    "✅ End-to-End flow executed successfully");

        } catch (Throwable e) {

            test.fail(
                    "❌ Test Failed : " + e.getMessage(),
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(
                                    ExtentManager.captureScreenshotBase64())
                            .build());

            throw e;

        } finally {

            extent.flush();
        }
    }
}