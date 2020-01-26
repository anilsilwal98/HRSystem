package com.oops.hrScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.oops.hrsystem.Phone;

public class PhoneScanner {
	public static List<String> readUserInputDataForPhone(BufferedReader bfreader) throws IOException{
		System.out.println("Enter phone in this form exactly\nID,CountryCode,AreaCode,Number");
		String phoneInput = bfreader.readLine();
		List<String> phoneParam = new ArrayList<String>(Arrays.asList(phoneInput.split(",")));
		while(phoneParam.size() != 4) {
			System.out.println("Failed to enter detail in given format for 4 different fields");
			System.out.println("Enter phone in this form exactly\nID,CountryCode,AreaCode,Number");
			phoneInput = bfreader.readLine();
			phoneParam = new ArrayList<String>(Arrays.asList(phoneInput.split(",")));
		}
		return phoneParam;
	}

	public static Phone createPhoneFromUserInput(BufferedReader bfreader) throws IOException {
		List<String> phoneParam = readUserInputDataForPhone(bfreader);
		Integer id = Integer.parseInt(phoneParam.get(0));
		String countryCode = phoneParam.get(1);
		String areaCode = phoneParam.get(2);
		String number = phoneParam.get(3);
		return new Phone(id,countryCode,areaCode,number);		
	}

}
