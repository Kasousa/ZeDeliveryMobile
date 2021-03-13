package org.zedelivery.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.logging.Logger;

public class SwipeActions extends ReadActions{

    private static Logger logger = Logger.getLogger(SwipeActions.class.getName());
    MobileDriver driver;

    public SwipeActions(AppiumDriver<?> driver) {
        super(driver);
        this.driver = driver;
    }

    // Metódo para realizar o scroll de metade da tela
    public void swipeMiddleScreen() throws Exception {
        try {
            TouchAction action = new TouchAction(driver);
            Dimension size = driver.manage().window().getSize();
            int interval = 500;

            int width = size.width / 2;
            int startPoint = size.height / 2;
            int endPoint = 10;

            action.press(PointOption.point(width, startPoint))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(interval)))
                    .moveTo(PointOption.point(width, endPoint)).release().perform();
        }
        catch (Exception e) {
            logger.info(e.toString());
            throw new Exception("Erro ao tentar realizar o swipe");
        }
    }


}
