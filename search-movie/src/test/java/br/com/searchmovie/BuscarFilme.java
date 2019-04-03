package br.com.searchmovie;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/br/com/searchmovie/BuscarFilme.feature", tags = "@BuscarFilmes")

public class BuscarFilme {
	
}
