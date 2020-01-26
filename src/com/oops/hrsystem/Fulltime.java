package com.oops.hrsystem;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Fulltime extends Employee{

	private DateTime start;
	private Float baseSalaryPerYear;
	private Float bonusPerYear;

	public Fulltime(int id, String firstName, String lastName, DateTime start, Float baseSalaryPerYear,
			Float bonusPerYear) {
		super(id, firstName, lastName);
		this.start = start;
		this.baseSalaryPerYear = baseSalaryPerYear;
		this.bonusPerYear = bonusPerYear;
	}
	public DateTime getStart() {
		return start;
	}
	public Float getBaseSalaryPerYear() {
		return baseSalaryPerYear;
	}
	public Float getBonusPerYear() {
		return bonusPerYear;
	}

	@Override
	public String toString() {
		return "\nFullTime\nId: "+getId()+"\nName: " + getFirstName() + getLastName() + "\nStartDate: "+getStart().toString(DateTimeFormat.mediumDate())+"\nAnnual Base Salary: "+getBaseSalaryPerYear()+ "\nPhone: " + getPhone() +"\nAddress: " + getAddress() + "\nRole:" +getRole()+"\n";		
	}
	
}
