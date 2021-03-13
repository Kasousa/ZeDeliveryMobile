package org.zedelivery.actions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions {
    public WebDriverWait wait15;
    public WebDriverWait wait4;

    public BaseActions(AppiumDriver<?> driver){
        wait15 = new WebDriverWait(driver, 15);
        wait4 = new WebDriverWait(driver, 4);
    }
}
