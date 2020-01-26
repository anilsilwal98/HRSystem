package com.oops.hrservice;

import java.util.Map;
import java.util.HashMap;

import com.oops.hrsystem.Company;
import com.oops.hrsystem.Employee;

public class CompanyData {
	
	public Map<Integer,Company> compList = new HashMap<>();

	public int addCompany(Company c) {
		Company comp = compList.get(c.getId());
		if(comp == null) {
			compList.put(c.getId(), c);
			return c.getId();
		}
		return 0;
	}
	
	public int removeCompany(Integer id) {
		Company comp = compList.get(id);
		if(comp != null) {
			compList.remove(id);
			return id;
		}
		return 0;
	}
	public Company searchCompany(Integer id) {
		Company comp = compList.get(id);
		if(comp != null) {
			System.out.println(comp.toString());
			return comp;
		}
		System.out.println("No Company Found With CompanyId:" + id);			
		return null;
	}
	
	public void searchEmployee(Integer compId, Integer empId) {
		Company comp = compList.get(compId);
		if(comp != null) {
			for (Employee e : comp.getEmployee()) {
				if (e.getId() == empId) {
					System.out.println(e.toString());
					break;
				}
		      }
		}else {
			System.out.println("No Search Found!!");			
		}
	}
	
	public void searchEmployee(Integer compId, String fName, String lName) {
		Company comp = compList.get(compId);
		if(comp != null) {
			for (Employee e:comp.getEmployee()) {
				if (fName.equalsIgnoreCase(e.getFirstName()) ||lName.equalsIgnoreCase(e.getLastName())) {
					System.out.println(e.toString());
				}
		      }
		}
		else {
			System.out.println("No Search Found!!");
		}
	}
	
	public void removeEmployee(Integer compId, Integer empId) {
		Company comp = compList.get(compId);
		if(comp != null) {
			for (Employee e : comp.getEmployee()) {
				if (e.getId() == empId) {
					comp.removeEmployee(e);
					System.out.println("SucessFully Added  To The Company!!");			
					break;
				}
		      }
		}else {
			System.out.println("Failed To Remove !!");			
		}
	}
	
}
