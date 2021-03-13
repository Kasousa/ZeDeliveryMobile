package org.zedelivery.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class CheckActions extends BaseActions{
    private static Logger logger = Logger.getLogger(ClickActions.class.getName());

    public CheckActions(AppiumDriver<?> driver) {
        super(driver);
    }

    // Metódo que checa se o elemento é visivel
    public boolean CheckIfIsVisible (MobileElement element) {
        try {
            logger.info ("checando visibilidade do elemento " + element.toString());
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

