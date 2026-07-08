package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.RegisterPage;
import utils.DriverManager;
import utils.ExcelReader;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class DataDrivenRegisterTest extends BaseTest {

    @Test
    public void testRegisterUsingExcel() {

        String path =
                "src/test/resources/testdata/parabank.xlsx";

        ExtentReports extent =
                ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("TC10 : Data Driven Registration");

        try {

            int rows =
                    ExcelReader.getRowCount(path);

            System.out.println("Total Rows = " + rows);

            for (int i = 0; i < rows; i++) {

                DriverManager.getPage().navigate(
                        "https://parabank.parasoft.com/parabank/register.htm");

                String username =
                        ExcelReader.getData(path, i, 0);

                System.out.println(
                        "Registering User : "
                                + username);

                RegisterPage registerPage =
                        new RegisterPage();

                String message =
                        registerPage.registerUser(username);

                Assertions.assertTrue(
                        message != null
                        && !message.isEmpty(),
                        "Registration failed for "
                                + username);

                test.pass(
                        "✅ Registration successful for : "
                                + username);
            }

        } catch (Throwable e) {

            test.fail(
                    "❌ Test Failed : "
                            + e.getMessage(),
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