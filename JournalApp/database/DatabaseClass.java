package org.justinswork.JournalApp.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.justinswork.JournalApp.model.Entry;
import org.justinswork.JournalApp.model.Profile;

public class DatabaseClass {

	private static Map<String, List<Entry>> entries = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<String, List<Entry>> getEntries() {
		return entries;
	}
	
	public static Map<String, Profile> getProfiles (){
		return profiles;
	}

	
	

}
