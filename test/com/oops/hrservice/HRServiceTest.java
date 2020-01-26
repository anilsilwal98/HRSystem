package com.oops.hrservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import com.oops.hrfixture.ContractorFixture;
import com.oops.hrfixture.EmployeeFixture;
import com.oops.hrfixture.FulltimeFixture;
import com.oops.hrsystem.Employee;

class HRServiceTest {

	private HRService service;
	
	@BeforeEach
	public void setup() {
		service = new HRService();
	}	
	@Test
	public void testAddEmployeeSucessCase() {
		service.addEmployee(EmployeeFixture.createEmployee());
	}


	@Test
	public void testAddFulltimeSucessCase() {
		service.addEmployee(FulltimeFixture.createFulltimeEmployee());
	}

	@Test
	public void testAddContractorSucessCase() {
		service.addEmployee(ContractorFixture.createContractorEmployee());
	}
	
	@Test
	public void testSearchEmployeeAssertNotNullSuccessCase() {
		int id = 1;
		service.addEmployee(EmployeeFixture.createEmployee());
		assertNotNull(service.db.get(id));
	}	

	@Test
	public void testSearchEmployeeAssertEqualSuccessCase() {
		int id = 1;
		service.addEmployee(EmployeeFixture.createEmployee());
		Employee e = service.search(id);
		assertEquals(e.getId(),id);
	}

}
