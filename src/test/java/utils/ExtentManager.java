package utils;

import java.util.Base64;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("extent-report.html");

            reporter.config().setReportName("Automation Report");
            reporter.config().setDocumentTitle("Playwright Execution");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }

    public static String captureScreenshotBase64() {

        byte[] screenshot =
                DriverManager.getPage().screenshot();

        return Base64.getEncoder()
                .encodeToString(screenshot);
    }
}