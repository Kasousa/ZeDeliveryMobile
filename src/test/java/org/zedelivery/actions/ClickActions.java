package org.zedelivery.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class ClickActions extends CheckActions{
    private static Logger logger = Logger.getLogger(ClickActions.class.getName());

    public ClickActions(AppiumDriver<?> driver) {
        super(driver);
    }

    // Metódo que aguarda a presença do elemento e depois realiza o clique
    public void click (MobileElement element) throws Exception {
        try {
            logger.info ("clicando no elemento " + element.toString());
            wait15.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {
             logger.info(e.toString());
             throw new Exception("Erro ao tentar clicar no elemento: " + element.toString());
        }
    }
}
