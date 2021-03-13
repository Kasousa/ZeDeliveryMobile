package org.zedelivery.support;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ThreadDriver {

    private static ThreadLocal<AppiumDriver<MobileElement>> _driver = new ThreadLocal<>();

    public synchronized static void setTDriver (AppiumDriver<MobileElement> driver) { _driver.set(driver); }

    public synchronized static AppiumDriver<MobileElement> getTDriver () { return _driver.get(); }

}