package org.justinswork.JournalApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.justinswork.JournalApp.database.DatabaseClass;
import org.justinswork.JournalApp.model.Profile;

public class ProfileService {
	
	Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
	}
	
	public Profile getProfile(String username) {
		return profiles.get(username);
	
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
		
	}
	
	public List<Profile> getProfilesByLocation(String location){
		ArrayList<Profile> profileLocation = new ArrayList<Profile>();
		for(Profile profile : this.profiles.values()){
				if(profile.getLocation().equals(location)){
					profileLocation.add(profile);
				}
		}
			return profileLocation;
	}
	
	public String getUsername(Profile profile) {
		return profile.getUsername();
	}
	
	public Profile addProfile(Profile profile) {
		profiles.put(profile.getUsername(), profile);
		return profile;
	}
	
	public void updateLocation(String username, String newLocation) {
		for(Profile profile2 : this.profiles.values()) {
			if(profile2.getUsername().equals(username)) {
				profile2.setLocation(newLocation);
			}
		}
	}
	
	public void updateName(String username, String name) {
		profiles.get(username).setName(name);
	}
	
	public void deleteProfile (String username) {
		profiles.remove(username);
	}
	
	

}
