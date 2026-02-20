package com.rooter.scripts;

import org.testng.annotations.Test;
import com.rooter.steps.Hook;

public class ParentalControl extends Hook {

    @Test
    public void navigateToRooterURL() {
        driver.navigate().to("https://www.google.com");
    }


}
