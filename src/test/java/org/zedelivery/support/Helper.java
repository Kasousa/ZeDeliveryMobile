package org.zedelivery.support;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    private static String baseDir = System.getProperty("user.dir") + "/evidences/";

    public static String getScenarioTag (Scenario scenario) {
        Collection<String> scenarioTags = scenario.getSourceTagNames();
        List<String> scenarioFilteredTags = scenarioTags.stream().filter(t -> t.contains("TestZe-")).collect(Collectors.toList());
        return scenarioFilteredTags.get(0).replace("@", "");
    }

    public static String getDateTimeWithPattern (String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void takeScreenshot (String name) throws Exception {
        File screenshot = ((TakesScreenshot) ThreadDriver.getTDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(baseDir + name + ".jpg"));
    }

    public static void takePageSource (String name) throws Exception {
        String pageSource = ThreadDriver.getTDriver().getPageSource();
        FileWriter fw = new FileWriter(baseDir + name + ".xml");
        fw.write(pageSource);
        fw.close();
    }
}
