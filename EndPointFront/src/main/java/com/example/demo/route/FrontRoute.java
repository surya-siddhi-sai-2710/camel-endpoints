package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.example.demo.model.Cars;

@Component
public class FrontRoute extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
	
		restConfiguration().bindingMode(RestBindingMode.json);
		
		// response is generated for every 10 seconds
		from("timer:every-ten-seconds?period=10000")
		 .setHeader("Content-Type", constant("application/json"))
		 .to("direct:view-car-by-modelno");
		
//		from("rest://get:/cars:/view/all")
//		.to("direct:next")
//		.setHeader("Content-Type", constant("application/json"))
////		.unmarshal().json(JsonLibrary.Jackson, Cars.class)
//		.log("Parsed Data: ${body}");
////		.marshal().json(JsonLibrary.Jackson);
		
//		from("direct:next")
//		.to("https://localhost:8080/camel/cars/view//all")
//		.log("Received data:${body}");
		
		// viewing car by model number
		from("direct:view-car-by-modelno")
		.log("entered in view car by model number")
		.to("bean:serviceForCars?method=getModelno")
		.marshal().json(JsonLibrary.Jackson) // Converting to JSON
		.log("User given Model number of car : ${body}")
		.to("http://localhost:8080/camel/cars/viewcar")
		.unmarshal(new JacksonDataFormat(Cars.class))
		.to("bean:serviceForCars?method=getCarsResponse")
		.marshal().json(JsonLibrary.Jackson)
		.log("API getting car info : ${body}");
		
	}
}
