package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.BillPayPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class BillPayTest extends BaseTest {

    @Test
    public void testBillPay() {

        ExtentReports extent = ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("TC3: Bill Pay");

        try {

            LoginPage login = new LoginPage();

            login.login("sundaram123", "pass1234");

            test.info("Login successful");

            DashboardPage dash = new DashboardPage();

            dash.goToBillPay();

            test.info("Navigated to Bill Pay");

            BillPayPage bill = new BillPayPage();

            boolean status =
                    bill.performBillPayment();

            Assertions.assertTrue(
                    status,
                    "❌ Bill Payment failed");

            test.pass("✅ Bill Payment successful");

        } catch (Exception e) {

            test.fail(
                    "❌ Exception: " + e.getMessage(),
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(
                                    ExtentManager.captureScreenshotBase64())
                            .build());

            throw e;
        }

        extent.flush();
    }
}