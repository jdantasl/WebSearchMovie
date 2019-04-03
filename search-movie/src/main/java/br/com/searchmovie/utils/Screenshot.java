package br.com.searchmovie.utils;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Screenshot {

    // metodo para captura de screenshot
    public static String captureScreenshot(final ChromeDriver driver, final String screenshotName) {
        try {            
        	
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            
            String dest = "./screenshots/" + screenshotName + ".png";
            File destination = new File(dest);
            
            Files.copy(source, destination);            
            return dest;
            
        }

        catch (IOException e) {
            return e.getMessage();
        }
    }

}
