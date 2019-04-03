package br.com.searchmovie.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssertMethodsUtils {
	
	private ChromeDriver driver;
	private WebDriverWait wait;	
	
	public AssertMethodsUtils(final ChromeDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 8);
	}
	
    public void assertEqByCss(final String cssSelector, final String expectedText) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cssSelector)));
            WebElement webEl = driver.findElement(By.xpath(cssSelector));
            String cssSelectorContent = webEl.getText().replaceAll("\n", " ");
            Assert.assertEquals(expectedText, cssSelectorContent.substring(16, 27));
        } catch (Exception e) {            
            throw new Exception("[O elemento <" + cssSelector + "> não foi encontrado!]");
        }
    }

    public void assertEqByXpath(final String xpathSelector, final String expectedText) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelector)));
            WebElement webEl = driver.findElement(By.xpath(xpathSelector));
            String xpathSelectorContent = webEl.getText().replaceAll("\n", " ");
            Assert.assertEquals(expectedText, xpathSelectorContent.substring(16, 27));
        } catch (Exception e) {            
            throw new Exception("[O elemento <" + xpathSelector + "> não foi encontrado!]");
        }
    }
    
}
