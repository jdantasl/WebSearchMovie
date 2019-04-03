package br.com.searchmovie.step;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import br.com.searchmovie.enums.ElementsEnums;
import br.com.searchmovie.utils.AssertMethodsUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class BuscarFilmeSteps {
		
	private ChromeDriver driver;	
	private WebDriverWait wait;	
	
    // =================================================================================================================================================================
    // Método de inicialização (setUp) do driver
    // =================================================================================================================================================================

    @Before
    public void setUp() throws Exception {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 8);
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Não foi possível configurar o @Before!", e);
        }
    }
	
    // =================================================================================================================================================================
    // Método da impressora
    // =================================================================================================================================================================

	@Dado("^que eu acesso o \"(.*?)\"$")
	public void givenMethod(String arg) throws Throwable {
		switch (arg) {
		case "Google":
			driver.get(ElementsEnums.URL_GOOGLE.getElement());			

			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
			Files.copy(scrFile, new File("./target/screenshot/imgURL_GOOGLE.png"));
			break;
		default:
			throw new Exception("Valor <" + arg + "> não encontrado!");			
		}
	}

	@Quando("^no campo de busca eu digitar \"(.*?)\"$")
	public void whenTypeText(String arg) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ElementsEnums.SEARCH_ELEMENT.getElement()))).sendKeys(arg);		

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
		Files.copy(scrFile, new File("./target/screenshot/imgSEARCH_ELEMENT.png"));
	}	
	
	@Quando("^eu clicar no botao \"(.*?)\"$")
	public void clickButton(String button) throws Throwable{
		switch(button) {
		case "Pesquisa Google":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ElementsEnums.BUTTON_ELEMENT.getElement()))).click();			
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
			Files.copy(scrFile, new File("./target/screenshot/imgBUTTON_ELEMENT.png"));
			break;
		default:
			throw new Exception("Valor <" + button + "> não encontrado!");
		}
	}

	@Entao("^eu verei mais de \"(.*?)\" resultados$")
	public void thenExpectResult(String arg) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementsEnums.VALUE_TRANSFORMERS.getElement())));
        WebElement webEl = driver.findElement(By.xpath(ElementsEnums.VALUE_TRANSFORMERS.getElement()));
        String xpathSelectorContent = webEl.getText().replaceAll("\n", " ");        
        
        if (xpathSelectorContent.substring(16, 27) != null) {
        	Assert.assertTrue(true);
        	System.out.println("Aproximadamente " + xpathSelectorContent.substring(16, 27));
        };

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
		Files.copy(scrFile, new File("./target/screenshot/imgVALUE_TRANSFORMERS.png"));
	}
	
    // =================================================================================================================================================================
    // After - Encerra geckodriver a cada cenario
    // =================================================================================================================================================================

    @After
    public void tearDown() throws Exception {
        try {
            if (driver != null) {
                driver.close();                
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Não foi possível executar o @After!", e);
        }

    }

}
