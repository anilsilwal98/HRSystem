package com.oops.hrfixture;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.oops.hrsystem.Contractor;

public class ContractorFixture {
	
	public static Contractor createContractorEmployee() {
		//@doc: https://www.joda.org/joda-time/apidocs/org/joda/time/DateTime.html
		DateTime start = new DateTime(2019,3,26,12,0,0);
		DateTime end = new DateTime(2020,3,26,12,0,0);
		Float hourlyRate = (float) 80.00;
		
		Contractor contract = new Contractor(1,"Anil", "Silwal", start, end, hourlyRate);
		contract.setAddress(AddressFixture.createAddress());
		contract.setPhone(PhoneFixture.createPhone());
		contract.setRole(new ArrayList<>());
		contract.addRole(RoleFixture.createRole());
		return contract;
		
	}
}
