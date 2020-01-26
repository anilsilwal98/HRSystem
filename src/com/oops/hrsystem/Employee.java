package com.oops.hrsystem;
import java.util.List;

public class Employee{

	private int id;
	private String firstName;
	private String lastName;
	private Phone phone;
	private Address address;
	private List<Role> role;
	
	public Employee(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Role> getRole() {
		return this.role;
	}
	
	public void setRole(List<Role> role) {
		this.role = role;
	}
	
	public boolean addRole(Role role) {
		for (Role rol : this.getRole()) {
			if (rol.getId() == role.getId()) {
				return false;
			}
	      }
		this.getRole().add(role);
		return true;
	}

	public int removeRole(Role role) {
		try {
			this.getRole().remove(role);
			return 1;
			
		}catch(Exception e) {
			System.out.println("Failure: Given Role Not Available In Order to Remove from this Employee !\n");
			return 0;
		}
	}

	@Override
	public String toString() {
		return "\nid: "+getId()+"\nName: " + getFirstName() + getLastName()+ " \nPhone: " + getPhone() +"\nAddress: " + getAddress() + "\nRole:" +getRole()+"\n";		
	}


	
}
