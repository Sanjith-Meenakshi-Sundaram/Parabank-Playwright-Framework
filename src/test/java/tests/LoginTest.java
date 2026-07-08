package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {

        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest test = extent.createTest("TC08: Login Test");

        try {

            LoginPage login = new LoginPage();

            test.info("Login started");

            login.login("sundaram123", "pass1234");

            boolean status = login.isLoginSuccessful();

            Assertions.assertTrue(status, "Login failed");

            test.pass("✅ Login successful");

        } catch (Throwable e) {

            test.fail(
                "❌ Login Test Failed : " + e.getMessage(),
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