package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumTrainerPage extends AbsBasePage {

    public SeleniumTrainerPage(WebDriver driver) {
        super(driver);
    }

    public void checkInsertTextWithHeadlessLaunch(String insertText) {

        WebElement element = driver.findElement(By.cssSelector("input#textInput"));
        insertTextIntoField(element, insertText);
        checkTextShouldBeSameAs(insertText, element);

        System.out.println("Test1 is fine");
    }

    public void checkModalWindowWithKioskLaunch() {

        WebElement element = driver.findElement(By.cssSelector("button#openModalBtn"));
        element.click();
        WebElement elementModal = driver.findElement(By.cssSelector("div.modal-content>p"));
        checkTextShouldBeSameAs("Вы открыли модальное окно. Нажмите на крестик или в любое место вне окна, чтобы закрыть его.", elementModal);

        System.out.println("Test2 is fine");
    }

    public void checkInsertNameAndEmailWithFullScreenLaunch(String name, String email) {

        WebElement elementName = driver.findElement(By.cssSelector("input#name"));
        insertTextIntoField(elementName, name);

        WebElement elementEmail = driver.findElement(By.cssSelector("input#email"));
        insertTextIntoField(elementEmail, email);

        WebElement elementSend = driver.findElement(By.cssSelector("button[type]"));
        elementSend.click();

        WebElement messageBox = driver.findElement(By.cssSelector("div.message"));
        String checkMessageBox = String.format("Форма отправлена с именем: %s и email: %s", name, email);
        checkTextShouldBeSameAs(checkMessageBox, messageBox);

        System.out.println("Test3 is fine");
    }

}
