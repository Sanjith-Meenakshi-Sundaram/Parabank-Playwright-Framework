package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.FindTransactionPage;
import pages.LoginPage;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class FindTransactionTest extends BaseTest {

    @Test
    public void testFindTransaction() {

        ExtentReports extent =
                ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("TC4 : Find Transaction");

        try {

            LoginPage login = new LoginPage();

            login.login("sundaram123", "pass1234");

            Assertions.assertTrue(
                    login.isLoginSuccessful(),
                    "Login failed");

            test.pass("✅ Login Successful");

            DashboardPage dashboard =
                    new DashboardPage();

            dashboard.goToFindTransactions();

            test.pass("✅ Navigated To Find Transactions");

            FindTransactionPage findTxn =
                    new FindTransactionPage();

            findTxn.findTransaction("12345");

            Assertions.assertTrue(
                    findTxn.isCreditColumnDisplayed(),
                    "Credit (+) column not displayed");

            test.pass(
                    "✅ Transaction Results displayed successfully");

            test.pass(
                    "✅ Verified Credit (+) column is visible");

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