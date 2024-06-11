import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DisplayedTests extends BaseTest{

    @Test
    public void displayedTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        WebElement helloText = driver.findElement(By.cssSelector("#finish>h4"));

        Assertions.assertFalse(helloText.isDisplayed(), "Элемент с текстом 'Hello World!' не должен отображаться" +
                " до того как нажата кнопка 'Start'");

        startButton.click();

        Thread.sleep(5000);

        Assertions.assertTrue(helloText.isDisplayed(), "Элемент с текстом 'Hello World!' должен отображаться " +
                "после того как нажата кнопка 'Start'");

        var text = helloText.getText();
        Assertions.assertEquals("Hello World!", text);

        System.out.println("Текст сообщения: " + helloText.getText());

    }
}
