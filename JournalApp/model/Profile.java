package org.justinswork.JournalApp.model;

import java.util.Calendar;

public class Profile {
	private String username;
	private String name;
	private String location;
	private Calendar creationDate;
	
	public Profile() {
		
	}
	
	public Profile(String username, String name, String location) {
		creationDate = Calendar.getInstance();
		this.username = username;
		this.name = name;
		this.location = location;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String firstName) {
		this.name = firstName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Calendar getCreationDate() {
		return this.creationDate;
	}
	
	
	

}
