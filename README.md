# prova_4all

Projeto de Automação de Testes para Front-End

## Libs, Frameworks
- Framework de testes para front-end Selenium: https://www.seleniumhq.org/
- Framework de relatório Extent-Report: http://extentreports.com/
- Framework de execução de Testes TestNG: https://testng.org/doc/index.html

### Execuçao do Projeto
Este projeto utiliza linguagem Java8 e gerenciador de depencias Maven, com isso é possível sua execuão portável em qualquer S.O contendo o projeto compilado.

### Execução em paralelo
Deve se executar via suite de testes - src\test\resources\suites

### Execução em diferentes Browsers
Execução nos browsers Chrome e Firefox, via parâmetro a ser definido pelo usuário no arquivo configuration.yml - src\main\resources

### Relatório de execução HTML Extent-Rerort
Deve-se anotar a classe de teste conforme exemplo:
```
@Listeners({TestListener.class, ExtentITestListenerClassAdapter.class} )
 public class MinhaClasseDeTest {
    //...my code... 
 }   
 ```

Para visualizar o relatório após a execução dos testes abra o arquivo: relatório/execuxao.html no browser.
Para visualizar os screenshots dos testes acessar os arquivos em: target\relatorio\img

## Requisitos
- Java 8 (JDK 1.8.0) + variavel de ambiente JAVA_HOME
- Maven + variável de ambiente M2_HOME
- Git

## IDE recomendada
- IntelliJ IDEA
