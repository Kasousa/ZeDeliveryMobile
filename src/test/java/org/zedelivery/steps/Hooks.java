package org.zedelivery.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.zedelivery.BaseTest;
import org.zedelivery.support.AndroidSupport;
import org.zedelivery.support.ThreadDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import static org.zedelivery.support.Helper.*;

/*
A Classe Hooks vai instanciar o Appium antes de executar o cenário
e após o cenário vai matar o processo do appium e iniciar um novo ciclo limpo
 */
public class Hooks {
    private static Logger logger = Logger.getLogger(BaseTest.class.getName());

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        logger.info("Iniciando cenário " + scenario.getName());
        AndroidSupport support = new AndroidSupport();
        support.setupAppium();
        logger.info("Session ID: " + ThreadDriver.getTDriver().getSessionId());
    }

    @After
    public void afterScenario(Scenario scenario) throws Exception {
    logger.info("Finalizando cenário " + scenario.getName());

    String result = scenario.getStatus().toString();
    String dateTime = getDateTimeWithPattern ("_yyyyMMdd_HHmmss_");
    String scenarioTag = getScenarioTag (scenario);
    String fileName = scenarioTag + "/" + scenarioTag + dateTime + result;

    takeScreenshot (fileName);
    takePageSource (fileName);

    ThreadDriver.getTDriver().quit();
    }
}
