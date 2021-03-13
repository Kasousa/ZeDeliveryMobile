package org.zedelivery.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class ReadActions extends ClickActions{
    private static Logger logger = Logger.getLogger(WriteActions.class.getName());

    public ReadActions(AppiumDriver<?> driver) {
        super(driver);
    }

    // Metódo para ler texto da tela
    public String getText (MobileElement element) throws Exception {
        try {
            logger.info ("Lendo texto no elemento: " + element.toString());
            wait15.until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        } catch (Exception e) {
            logger.info(e.toString());
            throw new Exception("Erro ao ler texto no elemento: " + element.toString());
        }
    }
}
