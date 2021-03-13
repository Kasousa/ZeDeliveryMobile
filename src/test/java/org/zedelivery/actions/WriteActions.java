package org.zedelivery.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class WriteActions extends WaitActions{
    private static Logger logger = Logger.getLogger(WriteActions.class.getName());

    public WriteActions(AppiumDriver<?> driver) {
        super(driver);
    }

    // Metódo para enviar texto a tela
    public void sendKeys (MobileElement element, String value) throws Exception {
        try {
            logger.info ("Enviando texto: " + value + " ao elemento: " + element.toString());
            wait15.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
        } catch (Exception e) {
            logger.info(e.toString());
            throw new Exception("Erro ao tentar enviar texto: " + value + " ao elemento: " + element.toString());
        }
    }
}
