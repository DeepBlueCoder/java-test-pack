import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KeyboardKeys extends BaseTest {

    @Test
    public void uploadFile() throws Exception {
        driver.get("http://the-internet.herokuapp.com/key_presses");
        // Option 1
        driver.findElement(By.id("content")).sendKeys(Keys.SPACE);
        assertThat(driver.findElement(By.id("result")).getText(), is("You entered: SPACE"));
        // Option 2
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.LEFT).build().perform();
        assertThat(driver.findElement(By.id("result")).getText(), is("You entered: LEFT"));
    }

}
