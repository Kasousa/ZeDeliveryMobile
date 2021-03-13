package org.zedelivery.support;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ThreadAppiumServer {

    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    public synchronized static void setServer(AppiumDriverLocalService driver) { server.set(driver); }

    public synchronized static AppiumDriverLocalService getServer() { return server.get(); }

}
