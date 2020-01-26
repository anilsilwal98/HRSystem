package com.oops.hrfixture;

import java.util.ArrayList;

import org.joda.time.DateTime;
import com.oops.hrsystem.Fulltime;

public class FulltimeFixture {

	public static Fulltime createFulltimeEmployee() {
		//@doc: https://www.joda.org/joda-time/apidocs/org/joda/time/DateTime.html
		DateTime start = new DateTime("2019-03-09");
		Float baseSalaryPerYear = (float) 90000.00;
		Float bonusPerYear = (float) 30000.00;
		
		Fulltime FT = new Fulltime(2,"Anil", "Silwal", start, baseSalaryPerYear, bonusPerYear);
		FT.setAddress(AddressFixture.createAddress());
		FT.setPhone(PhoneFixture.createPhone());
		FT.setRole(new ArrayList<>());
		FT.addRole(RoleFixture.createRole());
		
		return FT;
		
	}
}
