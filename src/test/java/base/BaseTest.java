package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import utils.DriverFactory;

public class BaseTest {

    @BeforeEach
    public void start() {
        DriverFactory.initDriver();
    }

    @AfterEach
    public void end() {
        DriverFactory.quitDriver();
    }
}