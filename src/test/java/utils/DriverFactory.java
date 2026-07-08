package utils;

import java.util.Properties;

import com.microsoft.playwright.*;

public class DriverFactory {

    private static Playwright playwright;
    private static Browser browser;

    public static void initDriver() {

        Properties prop = PropertyReader.getProperties();

        String url = prop.getProperty("URL");
        String browserName = prop.getProperty("BROWSER");

        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {

        case "edge":

            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setChannel("msedge")
                            .setHeadless(false));
            break;

        case "firefox":

            browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false));
            break;

        case "webkit":

            browser = playwright.webkit().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false));
            break;

        case "chromium":

            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false));
            break;

        default:

            throw new RuntimeException(
                    "Invalid browser name: " + browserName);
        }

        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080));

        Page page = context.newPage();

        page.setDefaultTimeout(60000);
        page.setDefaultNavigationTimeout(60000);

        page.navigate(url);

        DriverManager.setPage(page);
    }

    public static void quitDriver() {

        if (DriverManager.getPage() != null) {

            DriverManager.getPage()
                    .context()
                    .browser()
                    .close();

            DriverManager.unload();
        }

        if (playwright != null) {

            playwright.close();
        }
    }
}