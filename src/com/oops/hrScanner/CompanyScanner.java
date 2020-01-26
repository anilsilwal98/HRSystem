package com.oops.hrScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.oops.hrsystem.Company;

public class CompanyScanner {
	public static Company createCompanyFromUserInput(BufferedReader bfreader) throws IOException {
		System.out.println("Enter company detail in this form exactly\nId, name");
		String companyInput = bfreader.readLine();
		List<String> companyParam = new ArrayList<String>(Arrays.asList(companyInput.split(",")));
		while(companyParam.size() != 2) {
			System.out.println("Failed to enter detail in given format for 2 different fields");
			System.out.println("Enter address in this form exactly\nId, name");
			companyInput = bfreader.readLine();
			companyParam = new ArrayList<String>(Arrays.asList(companyInput.split(",")));
		}
		Integer id = Integer.parseInt(companyParam.get(0));
		String name = companyParam.get(1);
		return new Company(id,name);
	}
	
}
