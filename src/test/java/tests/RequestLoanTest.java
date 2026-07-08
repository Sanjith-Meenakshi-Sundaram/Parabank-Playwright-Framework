package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RequestLoanPage;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class RequestLoanTest extends BaseTest {

    @Test
    public void testRequestLoan() {

        ExtentReports extent =
                ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("TC5 : Request Loan");

        try {

            LoginPage login = new LoginPage();

            login.login("sundaram123", "pass1234");

            Assertions.assertTrue(
                    login.isLoginSuccessful(),
                    "Login failed");

            test.pass("✅ Login Successful");

            DashboardPage dashboard =
                    new DashboardPage();

            dashboard.goToRequestLoan();

            test.pass("✅ Navigated to Request Loan");

            RequestLoanPage loanPage =
                    new RequestLoanPage();

            String status =
                    loanPage.requestLoan();

            test.info("Loan Status : " + status);

            Assertions.assertTrue(
                    status.contains("Approved")
                    || status.contains("Denied"),
                    "Loan request not processed");

            test.pass("✅ Loan Request Processed Successfully");

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