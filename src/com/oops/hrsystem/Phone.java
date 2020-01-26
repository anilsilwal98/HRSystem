package com.oops.hrsystem;

public class Phone {
	private int id;
	private String countryCode;
	private String areaCode;
	private String number;
	
	public Phone(int id, String countryCode, String areaCode, String number) {
		this.id = id;
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public String getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return  getCountryCode()+getAreaCode()+getNumber();		
	}


}
