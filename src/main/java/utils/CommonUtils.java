package utils;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class CommonUtils {

    private CommonUtils() {}

    public static Map<String, String> getDadosTeste() {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(CommonUtils.class.getClassLoader().getResourceAsStream("configuration.yml"));

        Map<String, Object> web = (Map<String, Object>) root.get("web");
        Map<String, String> teste = (Map<String, String>) web.get("teste");
        return teste;
    }
    /**
     * Retorna o valor da propriedade contida no arquivo conf/configuration.yml
     * @return o valor da propriedade informada
     */

    public static Map<String, String> getConfSelenium() {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(CommonUtils.class.getClassLoader().getResourceAsStream("configuration.yml"));

        Map<String, Object> selenium = (Map<String, Object>) root.get("selenium");
        Map<String, String> configuracao = (Map<String, String>) selenium.get("configuracao");
        return configuracao;

    }
}
