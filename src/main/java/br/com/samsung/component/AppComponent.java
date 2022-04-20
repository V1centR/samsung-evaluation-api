package br.com.samsung.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {
	
	public static String ENDPOINT;
	
	@Value("${api.cellolatam.url}")
    public void setUrl(String url) {
		ENDPOINT = url;
    }

}
