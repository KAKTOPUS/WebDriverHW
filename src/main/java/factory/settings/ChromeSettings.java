package factory.settings;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements IBrowserSettings {

    private String launchParameter = System.getProperty("launchParameter");

    public AbstractDriverOptions settings() {
        ChromeOptions chromeOptions = new ChromeOptions();

        switch (launchParameter) {
            case "headless": {
                chromeOptions.addArguments("--headless");
                return chromeOptions;
            }
            case "fullscreen": {
                chromeOptions.addArguments("--maximized");
                return chromeOptions;
            }
            case "kiosk": {
                chromeOptions.addArguments("--kiosk");
                return chromeOptions;
            }
            default: {
                return chromeOptions.addArguments("start-fullscreen");
            }
        }
    }

}
