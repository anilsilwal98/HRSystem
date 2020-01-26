package com.oops.hrScanner;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import com.oops.hrsystem.Address;

public class AddressScanner {
	public static List<String> readUserInputDataForAddress(BufferedReader bfreader) throws IOException{
		System.out.println("Enter Address in this form exactly\nID,Zip,Country,State,City,Line1, Line2");
		String addressInput = bfreader.readLine();
		List<String> addressParam = new ArrayList<String>(Arrays.asList(addressInput.split(",")));
		while(addressParam.size() != 7) {
			System.out.println("Failed to enter detail in given format for 8 different fields");
			System.out.println("Enter address in this form exactly\nID,Zip,Country,State,City,Line1, Line2");
			addressInput = bfreader.readLine();
			addressParam = new ArrayList<String>(Arrays.asList(addressInput.split(",")));
		}
		return addressParam;
	}

	public static Address createAddressFromUserInput(BufferedReader bfreader) throws IOException {
		List<String> addressParam = readUserInputDataForAddress(bfreader);
		Integer id = Integer.parseInt(addressParam.get(0));
		String zip = addressParam.get(1);
		String country = addressParam.get(2);
		String state = addressParam.get(3);
		String city = addressParam.get(4);
		String line1 = addressParam.get(5);
		String line2 = addressParam.get(6);		
		return new Address(id,zip,country,state,city,line1,line2);		
	}

}
