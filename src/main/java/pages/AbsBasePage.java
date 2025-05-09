package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AbsBasePage {

    protected WebDriver driver = null;

    public AbsBasePage(WebDriver driver) {
        this.driver = driver;
    }

    private  String baseUrl = System.getProperty("base.url");
    public void open() {
        driver.get(baseUrl);
    }

    public void checkTextShouldBeSameAs(String text, WebElement element) {

        if (element.getText().equals("")) {
            assertThat(element.getDomProperty("value"))
                    .as("Text should be {}", text)
                    .isEqualTo(text);
        }
        else {
            assertThat(element.getText())
                    .as("Text should be {}", text)
                    .isEqualTo(text);
        }

    }


    public void insertTextIntoField(WebElement element, String text) {
        element.sendKeys(text);
    }

}
