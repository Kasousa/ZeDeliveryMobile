package org.zedelivery.screens.pedidos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.zedelivery.screens.BaseScreen;

import java.time.temporal.ChronoUnit;

public class PedidosScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "address input")
    private MobileElement fieldEndereco;

    @AndroidFindBy(accessibility = "address-card-auto-complete")
    private MobileElement btnSelecionaEndereco;

    @AndroidFindBy(accessibility = "complement-input")
    private MobileElement fieldComplemento;

    @AndroidFindBy(accessibility = "home-button")
    private MobileElement btnHome;

    @AndroidFindBy(accessibility = "continue")
    private MobileElement btnContinuar;

    @WithTimeout(time = 4, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Aguarde um momento\")")
    private MobileElement txtAguardeUmMomento;

    @AndroidFindBy(accessibility = "see-products")
    private MobileElement btnVerProdutos;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Cervejas\")")
    private MobileElement txtCervejas;

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement fieldPesquisa;

    @AndroidFindBy(accessibility = "search-input")
    private MobileElement fieldPesquisaInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"R$\")")
    private MobileElement btnSelecionaProduto;

    @AndroidFindBy(accessibility = "add-6-units-button")
    private MobileElement btnAdicionaSeisProdutos;

    @AndroidFindBy(accessibility = "add-12-units-button")
    private MobileElement btnAdicionaDozeProdutos;

    @AndroidFindBy(accessibility = "add-15-units-button")
    private MobileElement btnAdicionaQuinzeProdutos;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"minus-button\")")
    private MobileElement btnMenosUm;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"plus-button\")")
    private MobileElement btnMaisUm;

    @AndroidFindBy(accessibility = "product-title")
    private MobileElement txtNomeDoProduto;

    @AndroidFindBy(accessibility = "product-price")
    private MobileElement txtValorDoProduto;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"amount-\")")
    private MobileElement txtQuantidadeDeProdutos;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"add-to-checkout\"]/android.widget.TextView[1]")
    private MobileElement txtQuantidadeDeProdutosLabel;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"add-to-checkout\"]/android.widget.TextView[2]")
    private MobileElement txtPrecoTotal;

    public PedidosScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public void escreveEndereco (String endereco) throws Exception { sendKeys(fieldEndereco, endereco); }
    public void escreveComplemento (String complemento) throws Exception { sendKeys(fieldComplemento, complemento); }
    public void escrevePesquisa (String pesquisa) throws Exception { sendKeys(fieldPesquisaInput, pesquisa); }

    public void clickSelecionaEndereco () throws Exception { click(btnSelecionaEndereco); }
    public void clickHome () throws Exception { click(btnHome); }
    public void clickContinuar () throws Exception { click(btnContinuar); }
    public void clickVerProdutos () throws Exception { click(btnVerProdutos); }
    public void clickPesquisa () throws Exception { click(fieldPesquisa); }
    public void clickSelecionaProduto () throws Exception { click(btnSelecionaProduto); }
    public void clickAdicionaSeisProdutos () throws Exception { click(btnAdicionaSeisProdutos); }
    public void clickAdicionaDozeProdutos () throws Exception { click(btnAdicionaDozeProdutos); }
    public void clickAdicionaQuinzeProdutos () throws Exception { click(btnAdicionaQuinzeProdutos); }
    public void clickMenosUm () throws Exception { click(btnMenosUm); }
    public void clickMaisUm () throws Exception { click(btnMaisUm); }

    public String getNomeDoProduto () throws Exception { return getText(txtNomeDoProduto);}
    public String getValorDoProduto () throws Exception { return getText(txtValorDoProduto); }
    public String getQuantidadeDeProdutos () throws Exception { return getText(txtQuantidadeDeProdutos); }
    public String getQuantidadeDeProdutosLabel () throws Exception { return getText(txtQuantidadeDeProdutosLabel); }
    public String getPrecoTotal () throws Exception { return getText(txtPrecoTotal); }

    public boolean waitAguardeUmMomentoBeInvisible () {return waitElementBeInvisible(txtAguardeUmMomento); }
    public boolean waitCervejasBeVisible () {return waitElementBeVisible(txtCervejas);}
}



