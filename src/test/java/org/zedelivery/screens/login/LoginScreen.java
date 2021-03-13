package org.zedelivery.screens.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.zedelivery.screens.BaseScreen;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Pular introdução\")")
    private MobileElement btnPularIntroducao;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Entrar\")")
    private MobileElement btnEntrarNaConta;

    @AndroidFindBy(accessibility = "email")
    private MobileElement fieldEmail;

    @AndroidFindBy(accessibility = "password")
    private MobileElement fieldPassword;

    @AndroidFindBy(accessibility = "enter")
    private MobileElement btnEntrar;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Onde você quer suas bebidas?\")")
    private MobileElement txtOndeVoceQuerSuasBebidas;

    public LoginScreen(AppiumDriver<?> driver) { super(driver); }

    public void escreveEmail (String email) throws Exception { sendKeys(fieldEmail, email); }
    public void escrevePassword (String password) throws Exception { sendKeys(fieldPassword, password); }

    public void clickPularIntroducao () throws Exception { click(btnPularIntroducao); }
    public void clickEntrarNaConta () throws Exception { click(btnEntrarNaConta); }
    public void clickEntrar () throws Exception { click(btnEntrar); }

    public boolean CheckIfPularIntroducaoIsVisible () { return CheckIfIsVisible(btnPularIntroducao); }
}