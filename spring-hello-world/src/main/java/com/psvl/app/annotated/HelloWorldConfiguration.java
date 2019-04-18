package com.psvl.app.annotated;

import com.psvl.app.decoupled.HelloWorldMessageProvider;
import com.psvl.app.decoupled.MessageProvider;
import com.psvl.app.decoupled.MessageRenderer;
import com.psvl.app.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliana.cosmina on 1/28/17.
 */
@Configuration
public class HelloWorldConfiguration {

	@Bean
	public MessageProvider provider() {
		return new HelloWorldMessageProvider();
	}

	@Bean
	public MessageRenderer renderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider());

		return renderer;
	}
}
