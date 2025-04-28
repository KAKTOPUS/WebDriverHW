package factory.settings;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSettings implements IBrowserSettings {

    private String launchParameter = System.getProperty("launchParameter");

    public AbstractDriverOptions settings() {

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        switch (launchParameter) {
            case "headless": {
                firefoxOptions.addArguments("--headless");
                return firefoxOptions;
            }
            case "fullscreen": {
                firefoxOptions.addArguments("--maximized");
                return firefoxOptions;
            }
            case "kiosk": {
                firefoxOptions.addArguments("--kiosk");
                return firefoxOptions;
            }
            default: {
                return firefoxOptions.addArguments("start-fullscreen");
            }
        }

    }

}
