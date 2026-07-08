package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.RegisterPage;
import utils.DriverManager;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CreateUserTest extends BaseTest {

    @Test
    public void createUser() {

        ExtentReports extent =
                ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("TC02 : Create Fixed User");

        try {

            DriverManager.getPage().navigate(
                    "https://parabank.parasoft.com/parabank/register.htm");

            RegisterPage registerPage =
                    new RegisterPage();

            String message =
                    registerPage.registerUser("sundaram123");

            test.info("Username Created : sundaram123");

            Assertions.assertTrue(
                    message.contains("created successfully")
                    || message.contains("Welcome"),
                    "User creation failed");

            test.pass("✅ Fixed User Created Successfully");

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