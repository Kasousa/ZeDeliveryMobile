package org.zedelivery.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class WaitActions extends SwipeActions{
    private static Logger logger = Logger.getLogger(SwipeActions.class.getName());

    public WaitActions(AppiumDriver<?> driver) {
        super(driver);
    }

    // Metódo para aguardar a visibilidade de um elemento
    public boolean waitElementBeVisible (MobileElement element){
        try {
            logger.info("Aguardando a visibilidade do elemento: " + element.toString());
            wait15.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Metódo para aguardar a invisibilidade de um elemento
    public boolean waitElementBeInvisible (MobileElement element){
        try {
            logger.info("Aguardando a invisibilidade do elemento: " + element.toString());
            wait4.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
