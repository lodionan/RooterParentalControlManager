package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.Browser;
import utils.BrowserUtil;

public class WebDriverFactory {

    public static WebDriver WebDriver(Browser type) {
        WebDriver driver = null;

        try {
            switch(type) {
                case CHROME:
                    driver = BrowserUtil.setUpChrome();
                    break;
                case EDGE:
                    driver = BrowserUtil.setUpEdge();
                    break;
                case FIREFOX:
                    driver = BrowserUtil.setUpFirefox();
                    break;
            }
        } catch(WebDriverException wde) {
            try {
                throw wde.getCause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        return driver;
    }
}
