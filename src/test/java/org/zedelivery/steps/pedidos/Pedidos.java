package org.zedelivery.steps.pedidos;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.hamcrest.CoreMatchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.zedelivery.screens.pedidos.PedidosScreen;
import org.zedelivery.support.ThreadDriver;

import java.io.FileReader;

import static org.zedelivery.support.Helper.getScenarioTag;

public class Pedidos {
    PedidosScreen pedidosScreen;
    JSONObject pedidoDados;
    String baseDir = System.getProperty("user.dir") + "/src/test/resources/massa/";

    public void initScreens() {
        if (pedidosScreen == null){
            pedidosScreen = new PedidosScreen(ThreadDriver.getTDriver());
        }
    }

    @Before
    public void initData (Scenario scenario) throws Exception {
        String scenarioTag = getScenarioTag (scenario);

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(baseDir + "pedidos.json");
        JSONObject obj = (JSONObject) jsonParser.parse(reader);

        pedidoDados = (JSONObject) obj.get(scenarioTag);
        initScreens();
    }

    public String getData (String key) {
        return pedidoDados.get(key).toString();
    }

    @Dado("que seleciono o endereço de entrega")
    public void queSelecionoOEnderecoDeEntrega () throws Exception {
        pedidosScreen.waitAguardeUmMomentoBeInvisible ();
        pedidosScreen.escreveEndereco(getData("endereço"));
        pedidosScreen.clickSelecionaEndereco();
        pedidosScreen.escreveComplemento(getData("complemento"));
        pedidosScreen.clickHome();
        pedidosScreen.clickContinuar();
    }

    @E("seleciono um produto")
    public void selecionoUmProduto () throws Exception{
        pedidosScreen.waitAguardeUmMomentoBeInvisible ();
        pedidosScreen.clickVerProdutos();
        pedidosScreen.waitCervejasBeVisible ();
        pedidosScreen.clickPesquisa();
        pedidosScreen.escrevePesquisa(getData("produto"));
        pedidosScreen.clickSelecionaProduto();
    }

    @Quando("seleciono a quantidade")
    public void selecionoAQuantidade () throws Exception{
        pedidosScreen.clickAdicionaSeisProdutos();
        pedidosScreen.clickAdicionaDozeProdutos();
        pedidosScreen.clickAdicionaQuinzeProdutos();
        pedidosScreen.clickMaisUm();
        pedidosScreen.clickMenosUm();
        pedidosScreen.clickMenosUm();
    }

    @Então("valido o produto e a quantidade selecionada")
    public void validoOProdutoEAQuantidadeSelecionada () throws Exception {
        String nomeDoProduto = pedidosScreen.getNomeDoProduto();
        String valorDoProduto = pedidosScreen.getValorDoProduto();
        String quantidadeDeProdutos = pedidosScreen.getQuantidadeDeProdutos();
        String quantidadeDeProdutosLabel = pedidosScreen.getQuantidadeDeProdutosLabel();
        String precoTotal = pedidosScreen.getPrecoTotal();

        Assert.assertEquals("Nome do produto incorreto!", getData("produto"), nomeDoProduto);
        Assert.assertEquals("Nome do produto incorreto!", getData("valor"), valorDoProduto);
        Assert.assertEquals("Quantidade de produtos incorreta!", getData("quantidade"), quantidadeDeProdutos);
        Assert.assertThat("Quantidade de produtos incorreta!", quantidadeDeProdutosLabel, CoreMatchers.containsString(getData("quantidade")));
        Assert.assertEquals("Total Nome do produto incorreto!", getData("total"), precoTotal);
    }
}
