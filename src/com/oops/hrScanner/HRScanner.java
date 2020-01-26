package com.oops.hrScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.oops.hrservice.CompanyData;
import com.oops.hrsystem.Company;
import com.oops.hrsystem.Employee;

public class HRScanner {
	public static void employeeDirectory(BufferedReader bfreader,Company c,CompanyData comp) throws IOException {
		Scanner scan = new Scanner(System.in);
		boolean emploopContinues = true; 
		while(emploopContinues) {
			System.out.println("Enter 1 to Add Employee\nEnter 2 To Search Employee By Id\nEnter 3 To Search Employee by Employee Names\nEnter 4 To Remove Employee\nEnter 0 For Exit");
			char empCases = Character.toUpperCase(scan.next().charAt(0));
			switch(empCases) {
				case '1':
					if(readFromScanner(bfreader,c) != null) {
						System.out.println("Successfully Added Employee To Company");
					}
					break;
				case '2':
					System.out.println("Enter Employee ID To Search");	
					comp.searchEmployee(c.getId(),Integer.parseInt(scan.next()));
					break;
				case '3':
					System.out.println("Enter Employee First Name or Last Name To Search");
					System.out.print("FirstName:");
					String fName = scan.next().trim();
					System.out.print("LastName:");
					String lName = scan.next().trim();
					comp.searchEmployee(c.getId(),fName,lName);
					break;
				case '4':
					System.out.println("Enter Employee ID To Remove It From Company");	
					comp.removeEmployee(c.getId(),Integer.parseInt(scan.next()));
					break;
				case '0':
					System.out.println("Exiting From Employee Directory");	
					emploopContinues = false;
					break;
			}
		}
	}
	public static void readData(BufferedReader bfreader) throws IOException{
		Scanner scan = new Scanner(System.in);
		CompanyData comp = new CompanyData();
		boolean loopContinues = true; 
		while(loopContinues) {
			System.out.println("Enter 1 to Add Company Detail\nEnter 2 To Search Company\nEnter 3 To Remove Company\nEnter 0 For Exit");
			char cases = Character.toUpperCase(scan.next().charAt(0));
			switch(cases) {
			case '1':
				int addId = comp.addCompany(readFromScanner(bfreader,initializeFirst(bfreader)));
				if(addId != 0 ) {
					System.out.println("Successfully Added: Company" +addId);
				}
				System.out.println("\n");
				break;
			case '2':
				System.out.println("Enter Company ID To Search From CompanyList");	
				Company searchedComp = comp.searchCompany(Integer.parseInt(scan.next()));
				if(searchedComp != null) {
					employeeDirectory(bfreader,searchedComp,comp);		
				}
				System.out.println("\n");
				break;
			case '3':
				System.out.println("Enter Company ID To Remove From CompanyList");
				int removeId = comp.removeCompany(Integer.parseInt(scan.next()));
				if(removeId != 0) {
					System.out.println("Successfully Removed: Company" +removeId);
				}
				System.out.println("\n");
				break;
			case '0':
				loopContinues = false;
				System.out.println("Exiting From The System");
				break;
			}
		}
	}
	public static Company initializeFirst(BufferedReader bfreader) throws IOException{
		Company c = CompanyScanner.createCompanyFromUserInput(bfreader);
		c.setEmployee(new ArrayList<>());
		return c;
	}
	
	public static Company readFromScanner(BufferedReader bfreader,Company c) throws IOException{
		System.out.println("Do you want to add employee?\nEnter  Y for Yes or N for No employee entry: Y|N ");
		char employeeCheck = Character.toUpperCase(bfreader.readLine().charAt(0));
		while(employeeCheck == 'Y') {
			Employee emp = EmployeeScanner.createEmployeeFromUserInput(bfreader);
			if(c.addEmployee(emp)) {					
				System.out.println("Do you want to add Phone Detail?\nEnter  Y for Yes or N for No Phone entry: Y|N");
				char phoneCheck = Character.toUpperCase(bfreader.readLine().charAt(0));
				if(phoneCheck == 'Y') {
					emp.setPhone(PhoneScanner.createPhoneFromUserInput(bfreader));
				}
				
				System.out.println("Do you want to add Address Detail?\nEnter  Y for Yes or N for No Address entry: Y|N");
				char addressCheck = Character.toUpperCase(bfreader.readLine().charAt(0));
				if(addressCheck == 'Y') {
					emp.setAddress(AddressScanner.createAddressFromUserInput(bfreader));
				}
				
				System.out.println("Do you want to add Role Detail?\n:Enter  Y for Yes or N for No Role entry: Y|N");
				emp.setRole(new ArrayList<>());
				char roleCheck = Character.toUpperCase(bfreader.readLine().charAt(0));
				while(roleCheck == 'Y') {
					if(!emp.addRole(RoleScanner.createRoleFromUserInput(bfreader))) {
						System.out.println("Failed to add role because that role id is already entered");
					}
					System.out.println("Do you want to add Role Detail again?\n:Enter  Y for Yes or N for No Role entry: Y|N ");
					roleCheck = Character.toUpperCase(bfreader.readLine().charAt(0));
				}
			}
			System.out.println("Do you want to add employee again?\n:Enter  Y for Yes or N for No employee entry: Y|N");
			employeeCheck = Character.toUpperCase(bfreader.readLine().charAt(0));
		}
		return c;		
	}
}
