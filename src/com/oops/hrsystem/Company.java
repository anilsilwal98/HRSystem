package com.oops.hrsystem;
import java.util.List;

public class Company {
	private int id;
	private String name;
	private List<Employee> employee;
	

	public Company(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public List<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public boolean addEmployee(Employee emp) {
		for (Employee e : this.getEmployee()) {
			if (e.getId() == emp.getId()) {
				return false;
			}
	      }
		this.getEmployee().add(emp);
		return true;			
	}

	public int removeEmployee(Employee employee) {
		try {
			this.getEmployee().remove(employee);
			return 1;
			
		}catch(Exception e) {
			System.out.println("Failure: Given Employee Not Available In Order to Remove from this Company!\n");
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "CompanyId: "+getId()+",Name: " + getName() +  "\nList of Employees\n" + getEmployee();		
	}


}
