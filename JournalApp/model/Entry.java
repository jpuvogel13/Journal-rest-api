package org.justinswork.JournalApp.model;


import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;



public class Entry {
	
	private String username;
	private String title;
	private String entry;

	public Entry () {

	}
	
	public Entry(String username, String entryName, String entry) {
		this.entry= entry;
		this.title = entryName;
		this.username = username;
		new Entry("Jpuvogel13","Welcome", "Welcome to the journal App");
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEntryName() {
		return title;
	}
	public void setEntryName(String entryName) {
		this.title = entryName;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	
	
	

}
