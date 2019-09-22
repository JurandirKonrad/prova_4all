package pageobjects.produto;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.home.HomePO;

public class ProdutoPO extends HomePO {

    @FindBy(id = "add-product-4-btn")
    WebElement adicionarBrigadeiro;

    @FindBy(id = "add-product-5-btn")
    WebElement adicionarAlfajor;

    @FindBy(id = "add-product-0-btn")
    WebElement adicionarCoca;

    @FindBy(id = "add-product-1-btn")
    WebElement adicionarFanta;

    @FindBy(id = "add-product-2-btn")
    WebElement adicionarAgua;

    @FindBy(id = "add-product-3-btn")
    WebElement adicionarRissole;

    public void adicionarTodosDoces(){
        adicionarBrigadeiro.click();
        adicionarAlfajor.click();
    }

    public void adicionarTodasBebidas() {
        adicionarCoca.click();
        adicionarFanta.click();
        adicionarAgua.click();
    }

    public void adicionarRissoleMedio(){
        adicionarRissole.click();
    }

}
