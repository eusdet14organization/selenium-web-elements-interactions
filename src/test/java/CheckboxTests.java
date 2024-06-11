import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxTests extends BaseTest{

    @Test
    public void checkboxTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement sportCheckbox = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
        WebElement sportCheckboxLabel = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));

        Assertions.assertFalse(sportCheckbox.isSelected());

        sportCheckboxLabel.click();

        Thread.sleep(2000);
        Assertions.assertTrue(sportCheckbox.isSelected());
    }
}
