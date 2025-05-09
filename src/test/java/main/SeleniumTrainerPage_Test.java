package main;

import org.junit.jupiter.api.Test;
import pages.SeleniumTrainerPage;

public class SeleniumTrainerPage_Test extends BaseSuit {

    @Test
    public void firstTestCheckInputText() {
        SeleniumTrainerPage seleniumTrainerPage = new SeleniumTrainerPage(driver);
        seleniumTrainerPage.open();
        seleniumTrainerPage.checkInsertTextWithHeadlessLaunch("something");
    }

    @Test
    public void secondTestCheckModalWindow() {
        SeleniumTrainerPage seleniumTrainerPage = new SeleniumTrainerPage(driver);
        seleniumTrainerPage.open();
        seleniumTrainerPage.checkModalWindowWithKioskLaunch();
    }

    @Test
    public void thirdTestCheckNameEmail() {
        SeleniumTrainerPage seleniumTrainerPage = new SeleniumTrainerPage(driver);
        seleniumTrainerPage.open();
        seleniumTrainerPage.checkInsertNameAndEmailWithFullScreenLaunch("фыв", "asdf@sdfg.rt");
    }
}

