package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumTrainerPage extends AbsBasePage {

    public SeleniumTrainerPage(WebDriver driver) {
        super(driver);
    }

    public void checkInsertTextWithHeadlessLaunch() {

        WebElement element = driver.findElement(By.cssSelector("input#textInput"));
        insertTextIntoField(element, "something");
        //checkTextShouldBeSameAs("something", element); //- появляется ошибка, что получаемая строка методом getText() = "";

        String expectedText = "something";
        String actualText = element.getAttribute("value");
        Assertions.assertEquals(expectedText, actualText);

        System.out.println("Test1 is fine");
    }

    public void checkModalWindowWithKioskLaunch() {

        WebElement element = driver.findElement(By.cssSelector("button#openModalBtn"));
        element.click();
        WebElement elementModal = driver.findElement(By.cssSelector("div.modal-content>p"));
        checkTextShouldBeSameAs("Вы открыли модальное окно. Нажмите на крестик или в любое место вне окна, чтобы закрыть его.", elementModal);

        System.out.println("Test2 is fine");
    }

    public void checkInsertNameAndEmailWithFullScreenLaunch() {

        WebElement elementName = driver.findElement(By.cssSelector("input#name"));
        insertTextIntoField(elementName, "фыв");
        WebElement elementEmail = driver.findElement(By.cssSelector("input#email"));
        insertTextIntoField(elementEmail, "asdf@sdfg.rt");
        WebElement elementSend = driver.findElement(By.cssSelector("button[type]"));
        elementSend.click();
        WebElement messageBox = driver.findElement(By.cssSelector("div.message"));
        checkTextShouldBeSameAs("Форма отправлена с именем: фыв и email: asdf@sdfg.rt", messageBox);

        System.out.println("Test3 is fine");
    }

}
