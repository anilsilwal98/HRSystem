package com.oops.hrfixture;

import com.oops.hrsystem.Role;

public class RoleFixture {
	public static Role createRole() {
		return new Role(1,"Manager");
	}
}
