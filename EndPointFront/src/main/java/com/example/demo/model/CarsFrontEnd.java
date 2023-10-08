package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class CarsFrontEnd {
	
	// parameters are in UpperCase to differentiate frontend with backend response
	private int MODELNO;
	private String CNAME;
	
	//constructor with parameters
	public CarsFrontEnd(int mODELNO, String cNAME) {
		super();
		MODELNO = mODELNO;
		CNAME = cNAME;
	}
	
	//default constructor
	public CarsFrontEnd() {
		super();
	}
	
	//getters and setters
	public int getMODELNO() {
		return MODELNO;
	}
	public void setMODELNO(int mODELNO) {
		MODELNO = mODELNO;
	}
	public String getCNAME() {
		return CNAME;
	}
	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}
	
	@Override
	public String toString() {
		return "CarsFrontEnd [MODELNO=" + MODELNO + ", CNAME=" + CNAME + "]";
	}
}