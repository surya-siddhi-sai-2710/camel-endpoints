package com.example.demo;

import org.apache.camel.CamelContext;

import org.apache.camel.component.http.HttpComponent;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EndPointFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndPointFrontApplication.class, args);
	}
	
	@Autowired
	private CamelContext camelContext;
	
	// Configure Camel context
    @Bean
    public CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                // Add the HTTP component to the Camel context
                context.addComponent("http", new HttpComponent());
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                // Perform additional configuration if needed after Camel context starts
            }
        };
    }

}
