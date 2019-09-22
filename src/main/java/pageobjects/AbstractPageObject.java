package pageobjects;


import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

public abstract class AbstractPageObject {

    protected WebDriverWait wait;

    protected AbstractPageObject() {
        int timeout = Integer.parseInt(CommonUtils.getConfSelenium().get("timeout"));
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), timeout), this);
    }

    public boolean waitForPageLoad() {
        // Esperando jQuery carregar
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) js.executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        };
        // Esperando Javascript carregar
        ExpectedCondition<Boolean> jsLoad = driver -> js.executeScript("return document.readyState")
                .toString().equals("complete");
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
