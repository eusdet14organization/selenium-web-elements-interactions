import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RadioButtonTests extends BaseTest {
    @Test
    public void radioButtonTest() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");
        //nuts input[value='159'][type='radio']
        //Veg input[value='157'][type='radio']

        Thread.sleep(1000);

        WebElement cookieButton = driver.findElement(By.cssSelector("#btnCookie"));
        cookieButton.click();

        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/..//input"));
        WebElement nutsRadio = driver.findElement(By.xpath("//div[text()='Nuts']/..//input"));
        WebElement nutsLabel = driver.findElement(By.xpath("//div[text()='Nuts']/..//input/../../label"));

        Assertions.assertTrue(vegetablesRadio.isSelected(), "По умолчанию выбраны овощи");
        Assertions.assertFalse(nutsRadio.isSelected(), "По умолчанию орехи не выбраны");

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,600)", "");

        nutsLabel.click();

        Assertions.assertFalse(vegetablesRadio.isSelected(), "Овощи не должны быть выбраны");
        Assertions.assertTrue(nutsRadio.isSelected(), "Орехи должны быть выбраны");
    }
}
