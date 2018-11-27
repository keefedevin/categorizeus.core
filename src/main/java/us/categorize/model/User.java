package us.categorize.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	private long id;
	private String username;
	private String email;
	
	@JsonIgnore
	private String passhash;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasshash() {
		return passhash;
	}
	public void setPasshash(String passhash) {
		this.passhash = passhash;
	}
}
