package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.CommonUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Listeners({TestListener.class, ExtentITestListenerClassAdapter.class} )
public abstract class BaseTest extends TestListener {

    protected static final String URL_BASE = CommonUtils.getDadosTeste().get("url");

    @BeforeMethod
    @Parameters("browser")
    public void preCondition(@Optional() String browser, Method method) throws Exception {

        WebDriver driver = DriverManager.criarInstancia(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(URL_BASE);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void postCondition(ITestResult iTestResult) {
        DriverManager.quit();
    }

    @AfterSuite
    public void updateReport() {
        try {

            String relatorioPath = "target/relatorio/execucao.html";
            String htmlContent = FileUtils.readFileToString(new File(relatorioPath), "utf-8");

            String pattern = "href='([^'].*)' data-featherlight";

            Pattern r = Pattern.compile(pattern);

            Matcher matcher = r.matcher(htmlContent);

            Set<String> keyList = new HashSet();

            while (matcher.find()) {
                keyList.add(matcher.group(1));
            }
            for (String data : keyList) {
                String oldString = data + "' data-featherlight='image'>";
                htmlContent = htmlContent.replace(oldString, oldString + "<img src='" + data + "' style=\"width:150px\">");
            }
            htmlContent = htmlContent.replace("<span class='label grey badge white-text text-white'>base64-img</span>", "");

            FileUtils.writeStringToFile(new File(relatorioPath), htmlContent, "utf-8");

        } catch (Exception e) {
            LOGGER.error("Erro ao atualizar miniaturas no report html", e);
        }
    }
}