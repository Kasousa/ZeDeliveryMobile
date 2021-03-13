package org.zedelivery.steps.login;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.zedelivery.screens.login.LoginScreen;
import org.zedelivery.support.ThreadDriver;

import java.io.FileReader;

import static org.zedelivery.support.Helper.getScenarioTag;

public class Login {
    LoginScreen loginScreen;
    JSONObject loginDados;
    String baseDir = System.getProperty("user.dir") + "/src/test/resources/massa/";

    public void initScreens() throws Exception {
        if (loginScreen == null){
            loginScreen = new LoginScreen(ThreadDriver.getTDriver());
        }
        Thread.sleep(25000);
    }

    @Before
    public void initData (Scenario scenario) throws Exception {
        String scenarioTag = getScenarioTag (scenario);

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(baseDir + "login.json");
        JSONObject obj = (JSONObject) jsonParser.parse(reader);

        loginDados = (JSONObject) obj.get(scenarioTag);
        initScreens();
    }

    public String getData (String key) {
        return loginDados.get(key).toString();
    }

    @Dado("que efetuo o login no app")
    public void queEfetuoOLoginNoApp () throws Exception {
    boolean status = loginScreen.CheckIfPularIntroducaoIsVisible ();

    if (status) loginScreen.clickPularIntroducao();
    loginScreen.clickEntrarNaConta ();

    loginScreen.escreveEmail(getData("email"));
    loginScreen.escrevePassword(getData("password"));
    loginScreen.clickEntrar();
    }
}
