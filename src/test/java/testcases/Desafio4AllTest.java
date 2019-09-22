package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.carrinho.CarrinhoComprasPO;
import pageobjects.produto.ProdutoPO;
import pageobjects.home.HomePO;

import static org.testng.Assert.assertEquals;

public class Desafio4AllTest extends BaseTest {

    @Test(description = "Teste4All")
    public void desafioUm() {

        HomePO homePO = new HomePO();
        ProdutoPO produtoPO = new ProdutoPO();
        CarrinhoComprasPO carrinhoPO = new CarrinhoComprasPO();

        homePO.selecionarCategoria();
        homePO.selecionarOpcaoDoces();
        produtoPO.adicionarTodosDoces();
        homePO.selecionarCategoria();
        homePO.selecionarCategoriaTodos();
        homePO.acessarCarrinhoCompras();
        carrinhoPO.adicionarQuantidadeBrigadeiro();
        reportPrintInfo("Brigadeiros adicionados ao carrinho!");
        carrinhoPO.finalizarCompra();
        String statusPedido = carrinhoPO.getMensagemPedidoFinalizado();
        assertEquals(statusPedido, "Pedido realizado com sucesso!");
        reportPrintPass("Pedido finalizado com sucesso! ");

        carrinhoPO.clicarBotaoFechar();
    }

    @Test(description = "Teste4All")
    public void desafioDois() {

        HomePO homePO = new HomePO();
        ProdutoPO produtoPO = new ProdutoPO();
        CarrinhoComprasPO carrinhoPO = new CarrinhoComprasPO();

        homePO.selecionarCategoria();
        homePO.selecionarOpcaoBebidas();
        produtoPO.adicionarTodasBebidas();
        homePO.selecionarCategoria();
        homePO.selecionarCategoriaTodos();
        produtoPO.adicionarRissoleMedio();
        homePO.acessarCarrinhoCompras();
        carrinhoPO.adicionarQuantidadeRissoleMedio();
        reportPrintInfo("Rissoles adicionados ao carrinho!");
        carrinhoPO.removerQuantidadeRissoleMedio();
        reportPrintInfo("Rissoles removidos do carrinho!");
        Assert.assertEquals(carrinhoPO.precoTotalItens(), carrinhoPO.getSubtotalPreco());
        reportInfo("A subtotal do produtos selecionados é: R$ "+ carrinhoPO.precoTotalItens());
        Assert.assertEquals(carrinhoPO.precoTotalItens(), carrinhoPO.getTotalPreco());
        reportInfo("A valor total da compra é: R$ "+ carrinhoPO.precoTotalItens());
        carrinhoPO.finalizarCompra();
        String statusPedido = carrinhoPO.getMensagemPedidoFinalizado();
        assertEquals(statusPedido, "Pedido realizado com sucesso!");
        reportPrintPass("Pedido finalizado com sucesso! ");
        carrinhoPO.clicarBotaoFechar();
        reportPass("Teste conlcuido com sucesso!");
    }
}
