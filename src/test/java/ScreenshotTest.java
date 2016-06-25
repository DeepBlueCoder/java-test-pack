import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScreenshotTest extends BaseTest {

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String fileDestination = System.getProperty("user.dir") + "/";
            String fileName = "failshot_"
                              + description.getClassName()
                              + "_" + description.getMethodName()
                              + ".png";
            try {
                org.apache.commons.io.FileUtils.copyFile(
                        scrFile, new File(fileDestination + fileName));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    };

    @Test
    public void OnError() {
        driver.get("http://the-internet.herokuapp.com");
        assertThat(false, is(true));
    }

}