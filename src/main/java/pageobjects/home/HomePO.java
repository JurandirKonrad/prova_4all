package pageobjects.home;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AbstractPageObject;
import utils.CommonUtils;

public class HomePO extends AbstractPageObject {

    protected WebDriverWait wait;

    @FindBy (id = "open-categories-btn")
    WebElement comboSelecioneCategoria;

    @FindBy(css = "#category-1")
    WebElement selecionaOpcaoDoces;

    @FindBy(id = "cart-btn")
    WebElement buttonAcessarCarrinho;

    @FindBy(css = "#category-0")
    WebElement selecionaOpcaoBebidas;

    @FindBy(id = "category-all")
    WebElement selecionarTodos;

    public HomePO() {
        wait = new WebDriverWait(DriverManager.getDriver(), Integer.parseInt(CommonUtils.getConfSelenium().get("timeout")));
    }

    public void selecionarCategoria(){
        comboSelecioneCategoria.click();
    }

    public void selecionarOpcaoDoces(){
        selecionaOpcaoDoces.click();
    }

    public void acessarCarrinhoCompras() {
        buttonAcessarCarrinho.click();
    }

    public void selecionarOpcaoBebidas(){
        selecionaOpcaoBebidas.click();
    }

    public void selecionarCategoriaTodos(){
        selecionarTodos.click();
    }


}
