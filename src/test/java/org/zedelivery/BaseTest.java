package org.zedelivery;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.zedelivery.dataProvider.ConfigFileReader;
import org.zedelivery.support.ThreadAppiumServer;
import org.zedelivery.support.ThreadDriver;

import java.util.logging.Logger;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/zedelivery/features",
        glue = "org.zedelivery.steps",
        plugin = {"pretty", "html:target/cucumber-report.html"}
        )
public class BaseTest {
    private static Logger logger;
    private static AppiumDriverLocalService service;
    private static Integer appiumPort = Integer.valueOf(ConfigFileReader.getInstance().getappiumPort());

    @BeforeClass
    public static void start () throws Exception {
        logger = Logger.getLogger(BaseTest.class.getName());
        logger.info(" Iniciando a execução do appium");

        service = new AppiumServiceBuilder()
                .usingPort(appiumPort)
                .build();

        logger.info("Executando appium: " + service.isRunning());
        ThreadAppiumServer.setServer(service);
    }

    @AfterClass
    public static void end (){
        logger.info(" Finalizando a execução do appium");
        ThreadDriver.getTDriver().quit();
        ThreadAppiumServer.getServer().stop();
    }

}
