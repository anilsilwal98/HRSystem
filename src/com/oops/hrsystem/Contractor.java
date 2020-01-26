package com.oops.hrsystem;


 import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
 

public class Contractor extends Employee {
	private DateTime  start;
	private DateTime  end;
	private Float hourlyRate;
	
	public Contractor(int id, String firstName, String lastName, DateTime start, DateTime end, Float hourlyRate) {
		super(id, firstName, lastName);
		this.start = start;
		this.end = end;
		this.hourlyRate = hourlyRate;
	}
	
	public DateTime getStart() {
		return start;
	}
	public DateTime getEnd() {
		return end;
	}
	public Float getHourlyRate() {
		return hourlyRate;
	}

	@Override
	public String toString() {
		return "\nContractor\nId: "+getId()+"\nName: " + getFirstName() + getLastName() +"\nStartDate: "+getStart().toString(DateTimeFormat.mediumDate())+"\nEndDate: "+getEnd().toString(DateTimeFormat.mediumDate())+"\nHourlyRate: "+getHourlyRate()+ "\nPhone: " + getPhone() +"\nAddress: " + getAddress() + "\nRole:" +getRole()+"\n";		
	}


}
