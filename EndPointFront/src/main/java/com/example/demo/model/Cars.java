package com.example.demo.model;

public class Cars {
	
//	@JsonProperty("modelno")
	private int modelno;
	
//	@JsonProperty("cname")
	private String cname;
	
	public Cars() {
		// default constructor
	}
		
	//parameterized constructor
	public Cars(int modelno, String cname) {
		super();
		this.modelno = modelno;
		this.cname = cname;
	}

	//getters and setters
	public int getModelno() {
		return modelno;
	}

	public void setModelno(int modelno) {
		this.modelno = modelno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Cars [modelno=" + modelno + ", cname=" + cname + "]";
	}
	
	
}
