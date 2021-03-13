package org.zedelivery.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.zedelivery.actions.WriteActions;
import org.zedelivery.dataProvider.ConfigFileReader;

import java.time.Duration;

public class BaseScreen extends WriteActions {
    protected MobileDriver driver;
    private int timeoutElements = Integer.valueOf(ConfigFileReader.getInstance().gettimeoutElements());

    public BaseScreen(AppiumDriver<?> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(timeoutElements)), this);
    }
}
