package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TransferFundsPage;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class TransferFundsTest extends BaseTest {

    @Test
    public void testTransferFunds() {

        ExtentReports extent =
                ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("TC6 : Transfer Funds");

        try {

            LoginPage login = new LoginPage();

            login.login("sundaram123", "pass1234");

            Assertions.assertTrue(
                    login.isLoginSuccessful(),
                    "Login failed");

            test.pass("✅ Login Successful");

            DashboardPage dashboard =
                    new DashboardPage();

            dashboard.goToTransferFunds();

            test.pass("✅ Navigated To Transfer Funds");

            TransferFundsPage transferPage =
                    new TransferFundsPage();

            boolean status =
                    transferPage.transferFunds();

            Assertions.assertTrue(
                    status,
                    "Transfer failed");

            test.pass("✅ Transfer Completed Successfully");

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