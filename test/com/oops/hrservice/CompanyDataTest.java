package com.oops.hrservice;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.oops.hrfixture.CompanyFixture;
import com.oops.hrfixture.ContractorFixture;
import com.oops.hrfixture.FulltimeFixture;
import com.oops.hrsystem.Company;

public class CompanyDataTest {

		private CompanyData compData;
		
		@BeforeEach
		public void setup() {
			compData = new CompanyData();
		}
		
		@Test
		public void testAddCompanySucessCase() {
			assertEquals(1,compData.addCompany(CompanyFixture.createCompany()));			
		}
		@Test
		public void testAddCompanyAssertSucessCase() {
			assertNotEquals(0,compData.addCompany(CompanyFixture.createCompany()));
		}
		@Test
		public void testRemoveCompanySuccessCase() {
			int id = compData.addCompany(CompanyFixture.createCompany());
			assertNotEquals(0,compData.removeCompany(id));
		}
		
		@Test
		public void testRemoveCompanyAssertSuccessCase() {
			compData.addCompany(CompanyFixture.createCompany());
			assertNotEquals(0,compData.removeCompany(1));
		}

		@Test
		public void testSearchByIdCompanyAssertSuccessCase() {
			int id  = compData.addCompany(CompanyFixture.createCompany());
			assertNotEquals(null,compData.searchCompany(id));
		}
		

		@Test
		public void testAddEmployeeToCompanySuccessCase() {
			compData.addCompany(CompanyFixture.createCompany());
			Company c  = compData.compList.get(1);
			c.setEmployee(new ArrayList<>());
			assertEquals(true,c.addEmployee(ContractorFixture.createContractorEmployee()));
			assertEquals(true,c.addEmployee(FulltimeFixture.createFulltimeEmployee()));	
		}

}

