package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.UpdateContactInfoPage;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class UpdateContactInfoTest extends BaseTest {

    @Test
    public void testUpdateContactInfo() {

        ExtentReports extent =
                ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("TC7 : Update Contact Info");

        try {

        	LoginPage login = new LoginPage();

        	login.login("sundaram123", "pass1234");

        	System.out.println("STEP 1 - Login clicked");

        	boolean loginStatus = login.isLoginSuccessful();

        	System.out.println("STEP 2 - Login Status = " + loginStatus);

        	Assertions.assertTrue(loginStatus, "Login failed");

        	System.out.println("STEP 3 - Passed Login Assertion");

        	DashboardPage dashboard = new DashboardPage();

        	dashboard.goToUpdateContactInfo();

        	System.out.println("STEP 4 - Navigated to Update Contact Info");

        	UpdateContactInfoPage contactPage =
        	        new UpdateContactInfoPage();

        	boolean status =
        	        contactPage.updateContactInfo();

        	System.out.println("STEP 5 - Update Status = " + status);

        	Assertions.assertTrue(
        	        status,
        	        "Profile update failed");

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