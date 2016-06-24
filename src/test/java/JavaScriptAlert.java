import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JavaScriptAlert extends BaseTest {

    @Test
    public void JavaScriptAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector(".example li:nth-child(2) button")).click();
        Alert popup = driver.switchTo().alert();
        popup.accept();
        String result = driver.findElement(By.id("result")).getText();
        assertThat(result, is(equalTo("You clicked: Ok")));
    }

}