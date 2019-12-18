package ioc2.user;

import lombok.Data;

// 1. VO(Value Object) Class
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
