package com.oops.hrScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.oops.hrsystem.Role;

public class RoleScanner {
	public static List<String> readUserInputDataForRole(BufferedReader bfreader) throws IOException{
		System.out.println("Enter Role in this form exactly\nID,Name");
		String roleInput = bfreader.readLine();
		List<String> roleParam = new ArrayList<String>(Arrays.asList(roleInput.split(",")));
		while(roleParam.size() != 2) {
			System.out.println("Failed to enter detail in given format for 2 different fields");
			System.out.println("Enter Role in this form exactly\nID,Name");
			roleInput = bfreader.readLine();
			roleParam = new ArrayList<String>(Arrays.asList(roleInput.split(",")));
		}
		return roleParam;
	}

	public static Role createRoleFromUserInput(BufferedReader bfreader) throws IOException {
		List<String> roleParam = readUserInputDataForRole(bfreader);
		Integer id = Integer.parseInt(roleParam.get(0));
		String name = roleParam.get(1);
		return new Role(id,name);		
	}
}
