package com.oops.hrfixture;
import java.util.ArrayList;

import com.oops.hrsystem.Employee;

public class EmployeeFixture {
	public static Employee createEmployee() {
		Employee emp = new Employee(1,"Anil","Silwal");
		emp.setAddress(AddressFixture.createAddress());
		emp.setPhone(PhoneFixture.createPhone());
		emp.setRole(new ArrayList<>());
		emp.addRole(RoleFixture.createRole());
		return emp;		
	}
	
	
}
