package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Cars;
import com.example.demo.model.CarsByModel;
import com.example.demo.service.CarService;


@Component
public class CarRoute extends RouteBuilder{
		
	@Autowired
	private CarService carService;		//bean name
	
	@Override
	public void configure() throws Exception{
		
		restConfiguration().bindingMode(RestBindingMode.auto);
		
		rest("/cars")
		//route 1 to view all cars
		.get("/view/all").to("direct:view-all-cars")
		
		//route 2 to view car by model number
		.post("/viewcar")
		  .type(CarsByModel.class)
		  .consumes("application/json")
		  .to("direct:view-car")
		 
		//route 3 to add a new car
		.post("/add").type(Cars.class).consumes("application/json").to("direct:add-car");
		
		
		from("direct:view-all-cars")
		.log("enter view all cars-")
		.to("bean:carService?method=viewAllCars");
		
		from("direct:view-car")
		 .log("enter view car by model number- ")
		 .to("bean:carService?method=viewCarByModelno");
		
		from("direct:add-car").log("enter add car-").bean(carService,"addCars");
	}
}
