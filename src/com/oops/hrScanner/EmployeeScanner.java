package com.oops.hrScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.joda.time.DateTime;
import com.oops.hrsystem.Contractor;
import com.oops.hrsystem.Employee;
import com.oops.hrsystem.Fulltime;

public class EmployeeScanner {
	
	public static boolean checkifvalidDate(String s) {
		try {
			DateTime startDate = new DateTime(s);
		}catch(Exception e) {
			System.out.println("Date Format exactly should follow this format: yyyy-mm-dd");
			return true;
		}
		return false;
	}
	public static Fulltime readUserInputDataForFulltimeEmployee(BufferedReader bfreader) throws IOException{
		System.out.println("Enter employee detail in this form exactly\nId, firstName, lastName, start(format: yyyy-mm-dd),  baseSalaryPerYear, bonusPerYear");
		String fulltimeInput = bfreader.readLine();
		List<String> fulltimeParam = new ArrayList<String>(Arrays.asList(fulltimeInput.split(",")));		
		boolean validateDate = checkifvalidDate(fulltimeParam.get(3).trim());		
		while(fulltimeParam.size() != 6 || validateDate == true) {
			System.out.println("Failed to enter detail in given format for 6 different fields");
			System.out.println("Enter employee detail in this form exactly\nId, firstName, lastName, start(format: yyyy-mm-dd),  baseSalaryPerYear, bonusPerYear");
			fulltimeInput = bfreader.readLine();
			fulltimeParam = new ArrayList<String>(Arrays.asList(fulltimeInput.split(",")));
			validateDate = checkifvalidDate(fulltimeParam.get(3).trim());	
		}
		DateTime startTime = new DateTime(fulltimeParam.get(3).trim());
		Integer id = Integer.parseInt(fulltimeParam.get(0));
		String fName = fulltimeParam.get(1).trim();
		String lName = fulltimeParam.get(2).trim();
		Float baseSalaryPY = Float.parseFloat(fulltimeParam.get(4));
		Float bonusPY = Float.parseFloat(fulltimeParam.get(5));

		return new Fulltime(id,fName,lName,startTime,baseSalaryPY,bonusPY);
	}
	
	public static Contractor readUserInputDataForContractorEmployee(BufferedReader bfreader) throws IOException{
		System.out.println("Enter Address in this form exactly\nId, firstName, lastName, start(format: yyyy-mm-dd), end(format: yyyy-mm-dd), hourlyRate");
		String contractorInput = bfreader.readLine();
		List<String> contractorParam = new ArrayList<String>(Arrays.asList(contractorInput.split(",")));
		boolean validateDate1 = checkifvalidDate(contractorParam.get(3).trim());		
		boolean validateDate2 = checkifvalidDate(contractorParam.get(4).trim());		
		while(contractorParam.size() != 6 || validateDate1 == true || validateDate2 == true) {
			System.out.println("Failed to enter detail in given format for 6 different fields");
			System.out.println("Enter address in this form exactly\nId, firstName, lastName,start(format: yyyy-mm-dd), end(format: yyyy-mm-dd), hourlyRate");
			contractorInput = bfreader.readLine();
			contractorParam = new ArrayList<String>(Arrays.asList(contractorInput.split(",")));
			validateDate1 = checkifvalidDate(contractorParam.get(3).trim());	
			validateDate2 = checkifvalidDate(contractorParam.get(4).trim());	
		}
		Integer id = Integer.parseInt(contractorParam.get(0));
		String fName = contractorParam.get(1).trim();
		String lName = contractorParam.get(2).trim();
		DateTime startDate = new DateTime(contractorParam.get(3).trim());
		DateTime endDate = new DateTime(contractorParam.get(4).trim());
		Float hourlyRate = Float.parseFloat(contractorParam.get(5));
		return new Contractor(id,fName,lName,startDate,endDate,hourlyRate);
	}

	public static Employee createEmployeeFromUserInput(BufferedReader bfreader) throws IOException {
		System.out.println("Enter either C for contractor employee or F for fulltime contractor entry: C|F");
		char check = Character.toUpperCase(bfreader.readLine().charAt(0));		
		if(check == 'F') {
			return readUserInputDataForFulltimeEmployee(bfreader);
		}
		else {
			return readUserInputDataForContractorEmployee(bfreader);		
		}
	}


}
