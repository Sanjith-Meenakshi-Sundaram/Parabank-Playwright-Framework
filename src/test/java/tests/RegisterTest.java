package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.RegisterPage;
import utils.DriverManager;
import utils.ExtentManager;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.MediaEntityBuilder;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegister() {

        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest test = extent.createTest("TC1: Register User");

        try {

            DriverManager.getPage().navigate(
                "https://parabank.parasoft.com/parabank/register.htm"
            );

            RegisterPage reg = new RegisterPage();

            String username =
                    "user" + System.currentTimeMillis();

            String msg = reg.registerUser(username);

            test.info("Registration started");

            System.out.println("Actual Message: " + msg);

            Assertions.assertNotNull(msg);

            test.pass("✅ Registration flow executed successfully");

        } catch (Exception e) {

            test.fail(
                "❌ Exception: " + e.getMessage(),
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                    ExtentManager.captureScreenshotBase64()
                ).build());

            throw e;
        }

        extent.flush();
    }
}