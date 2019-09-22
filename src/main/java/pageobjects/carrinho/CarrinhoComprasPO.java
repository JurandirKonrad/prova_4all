package pageobjects.carrinho;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.home.HomePO;

public class CarrinhoComprasPO extends HomePO {

    @FindBy(id = "add-product-4-qtd")
    WebElement buttonAdicionarBrigadeiro;

    @FindBy(id = "product-4-qtd")
    WebElement getQuantidadeBrigadeiro;

    @FindBy(id = "finish-checkout-button")
    WebElement buttonFinalizarCompra;

    @FindBy(css = "#root > div.ReactModalPortal > div > div > div > h2")
    WebElement getMensagemSucesso;

    @FindBy(css = "#root > div.ReactModalPortal > div > div > div > button")
    WebElement buttonFechar;

    @FindBy(id = "add-product-3-qtd")
    WebElement buttonAdicionarRissole;

    @FindBy(id = "remove-product-3-qtd")
    WebElement buttonRemoverRissole;

    @FindBy(id = "product-3-qtd")
    WebElement getQuantidadeRissole;

    @FindBy(id = "product-0-qtd")
    WebElement getQuantidadeCoca;

    @FindBy(id = "product-1-qtd")
    WebElement getQuantidadeFanta;

    @FindBy(id = "product-2-qtd")
    WebElement getQuantidadeAgua;

    @FindBy(id = "product-3-price")
    WebElement precoRissole;

    @FindBy(id = "product-0-price")
    WebElement precoCoca;

    @FindBy(id = "product-1-price")
    WebElement precoFanta;

    @FindBy(id = "product-2-price")
    WebElement precoAgua;

    @FindBy(id = "subtotal-price")
    WebElement valorSubtotal;

    @FindBy(id = "price-total-checkout")
    WebElement valorTotal;

    public String getQtdBrigadeiro() {
        return getQuantidadeBrigadeiro.getText();
    }

    public void adicionarQuantidadeBrigadeiro() {
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(getQtdBrigadeiro()) < 4) {
                buttonAdicionarBrigadeiro.click();
            }
        }
    }

    public void finalizarCompra(){
        buttonFinalizarCompra.click();
    }

    public String getMensagemPedidoFinalizado(){
        return getMensagemSucesso.getText();
    }

    public void clicarBotaoFechar(){
        buttonFechar.click();
    }

    public String getQuantidadeRissole() {
        return getQuantidadeRissole.getText();
    }

    public void adicionarQuantidadeRissoleMedio() {
        for (int i = 0; i < 8; i++) {
            if (Integer.parseInt(getQuantidadeRissole()) < 9) {
                buttonAdicionarRissole.click();
            }
        }
    }

    public void removerQuantidadeRissoleMedio() {
        for (int i = 0; i < 5; i++) {
            if (Integer.parseInt(getQuantidadeRissole()) > 4) {
                buttonRemoverRissole.click();
            }
        }
    }

    public double getPreco(WebElement element) {
        return Double.parseDouble(element.getText().replace("R$ ", "").replace(",", ".") );
    }

    public double getSubtotalPreco(){
        return getPreco(valorSubtotal);
    }

    public double getTotalPreco(){
        return getPreco(valorTotal);
    }

    public double precoTotalItens(){

        Double totalRissole = getPreco(precoRissole) * Integer.parseInt(getQuantidadeRissole.getText());
        Double totalCoca = getPreco(precoCoca) * Integer.parseInt(getQuantidadeCoca.getText());
        Double totalAgua = getPreco(precoAgua) * Integer.parseInt(getQuantidadeAgua.getText());
        Double totalFanta = getPreco(precoFanta) * Integer.parseInt(getQuantidadeFanta.getText());

        Double valorTotalItens = totalAgua + totalCoca + totalFanta + totalRissole;

        return valorTotalItens;
    }




}
