import org.junit.Test;
import org.openqa.selenium.By;
import java.io.File;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UploadTest extends BaseTest {

    // If uploading to a Grid node or Sauce Labs, check out driver.setFileDetector()
    // https://saucelabs.com/resources/articles/selenium-file-upload

    @Test
    public void uploadFile() throws Exception {
        String filename = "some-file.txt";
        File file = new File(filename);
        String path = file.getAbsolutePath();
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        String text = driver.findElement(By.id("uploaded-files")).getText();
        assertThat(text, is(equalTo(filename)));
    }

}