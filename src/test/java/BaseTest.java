import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    WebDriver driver;

    @Before
    protected void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    protected void tearDown() {
        driver.quit();
    }
}
