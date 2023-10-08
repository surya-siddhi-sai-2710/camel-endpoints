package com.example.demo.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cars;
import com.example.demo.model.CarsByModel;
import com.example.demo.model.CarsFrontEnd;

@Service("serviceForCars")
public class ServiceForCars {
	
	Scanner sc = new Scanner(System.in);
	
	@Autowired
	private CarsByModel carsByModel;
	
	@Autowired
	private CarsFrontEnd carsfrontend;
	
	public CarsByModel getModelno() {
		
		int modelno;
		System.out.println("enter model number: ");
		modelno = sc.nextInt();
		carsByModel.setModelno(modelno);
		return carsByModel;
	}
	
	public CarsFrontEnd getCarsResponse(Cars car) {
		
		carsfrontend.setMODELNO(car.getModelno());
		carsfrontend.setCNAME(car.getCname());
		
		return carsfrontend;
	}
}
