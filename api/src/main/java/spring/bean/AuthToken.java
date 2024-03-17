package spring.bean;

public class AuthToken {
	
	private String token;	
	
	private String role;

	
	public AuthToken(String token, int mainRole) {
		this.token = token;
		switch (mainRole) {
	    case 1:
	    	this.role = "ADMIN";
	    	break;
	    case 2:
	    	this.role = "SALES";
	        break;
	    case 3:
	    	this.role = "DOCS";
	        break;
	    default:
	    	this.role = "CLIENTS";
	}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
