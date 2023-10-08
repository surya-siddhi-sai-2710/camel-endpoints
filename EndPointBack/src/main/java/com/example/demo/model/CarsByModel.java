package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class CarsByModel {
	
	private int modelno;
	
	public CarsByModel() {
		//default constructor
	}
	
	// constructor with parameters
	public CarsByModel(int modelno) {
		super();
		this.modelno = modelno;
	}
	
	//getters and setters
	public int getModelno() {
		return modelno;
	}

	public void setModelno(int modelno) {
		this.modelno = modelno;
	}

	@Override
	public String toString() {
		return "CarsByModel [modelno=" + modelno + "]";
	}
}