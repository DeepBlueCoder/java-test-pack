import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DropdownTest extends BaseTest {

    @Test
    public void dropdownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals("Option 1")) {
                options.get(i).click();
            }
        }
        String selectedOption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()) {
                selectedOption = options.get(i).getText();
            }
        }
        assertThat(selectedOption, is("Option 1"));
    }

    @Test
    public void dropdownTestRedux() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select selectList = new Select(driver.findElement(By.id("dropdown")));
        selectList.selectByVisibleText("Option 1");
        // You could also use select.selectByValue("1");
        assertThat(selectList.getFirstSelectedOption().getText(), is(equalTo("Option 1")));
    }

}