package com.oops.hrservice;
import java.util.Map;
import java.util.HashMap;

import com.oops.hrsystem.*;

public class HRService {

	public Map<Integer, Employee> db = new HashMap<>();
	
	public void addEmployee(Employee emp) {
		Employee e = db.get(emp.getId());
		if(e == null) {
			db.put(emp.getId(), emp);
		}
	}
	
	
	public Employee search(int id) {
		Employee e = db.get(id);
		if(e != null) {
			return e;
		}
		return null ;
	}

	public int removeEmployee(int id) {
		if(this.search(id) != null){
			db.remove(id);
			return 1;
		}
		else {
			return 0;
		}
	}
	

	
}
