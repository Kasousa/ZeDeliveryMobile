package org.zedelivery.support;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.zedelivery.dataProvider.ConfigFileReader;

import java.net.URL;

public class AndroidSupport {
    private String baseDir = System.getProperty("user.dir") + "/app/";
    private static String appiumPort = ConfigFileReader.getInstance().getappiumPort();
    private static String apkName = ConfigFileReader.getInstance().getapkName();

    public void setupAppium () throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        caps.setCapability(MobileCapabilityType.APP, baseDir + apkName);
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability(MobileCapabilityType.FULL_RESET, true);

        try {
            String url = "http://localhost:" + appiumPort + "/wd/hub";
            ThreadDriver.setTDriver(new AndroidDriver<>(new URL(url), caps));
        } catch (Exception e) {
            if (e.getMessage().contains("Connection refused"))
                throw new Exception("Verifique se o appium server está rodando");
            else throw new Exception("Erro ao iniciar o driver");
        }
    }
}
