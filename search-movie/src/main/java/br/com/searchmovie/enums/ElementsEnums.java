package br.com.searchmovie.enums;

public enum ElementsEnums {
	
	URL_GOOGLE("http://www.google.com.br/"),
	VALUE_TRANSFORMERS("//*[@id=\"resultStats\"]"),
    BUTTON_ELEMENT("#tsf > div:nth-child(2) > div > div.UUbT9 > div.aajZCb > div > center > input[type=\"submit\"]:nth-child(1)"),
    SEARCH_ELEMENT("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input");
    
    private final String _elements;
    
    private ElementsEnums(final String elements) {
    	_elements = elements;
    }
    
    public String getElement() {
    	return _elements;
    }

}
