import org.junit.Test;
import org.openqa.selenium.By;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class WorkWithBasicAuthTest extends BaseTest {

    @Test
    public void workWithBasicAuthTest() {
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        String pageMessage = driver.findElement(By.cssSelector("p")).getText();
        assertThat(pageMessage, containsString("Congratulations!"));
    }

}