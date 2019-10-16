package org.justinswork.JournalApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.justinswork.JournalApp.database.DatabaseClass;
import org.justinswork.JournalApp.exception.EntryNotFoundException;
import org.justinswork.JournalApp.model.Entry;
import org.justinswork.JournalApp.model.Profile;

@XmlRootElement
public class EntryService {
	Map<String, List<Entry>> enteries = DatabaseClass.getEntries();
	Map<String, Profile> profiles = DatabaseClass.getProfiles();


	public EntryService() {

	}

	//******The adding a profile by making an entry for the first time and making a profile through profile
	// service are not connected. Two different "DataBases"****

	public List<Entry> getUserEntries(String username) {
		return enteries.get(username);
	}

	public List<Entry> getEntriesByTitle(String entryTitle){
		List<Entry> entryList = new ArrayList<Entry>();
		for(List<Entry> entry1 : this.enteries.values()) {
			for(Entry entry : entry1) {
				if(entry.getEntryName().equals(entryTitle)) {
					entryList.add(entry);
				}
			}
		}
		return entryList;
	}

	public Entry addEntry(Entry entry) {
		if(!(enteries.containsKey(entry.getUsername()))) {
			enteries.put(entry.getUsername(), new ArrayList<Entry>());
			enteries.get(entry.getUsername()).add(entry);
		} else {
			enteries.get(entry.getUsername()).add(entry);
		}
		if(containProfile(entry.getUsername())==false) {
			profiles.put(entry.getEntryName(), (new Profile(entry.getUsername(), "", " ")));	

		}
		return entry;
	}


	//If entry is not found, throw EntryNotFoundException(make yourself)
	public void deleteEntry (String username, String entryTitle) {
		List<Entry> userEntries = enteries.get(username);
		if(userEntries==null) {
			throw new EntryNotFoundException("The entry " + entryTitle + " is not in the database.");
		}
		
		List<Entry> toBeRemoved = new ArrayList<Entry>();
		for(Entry entry : userEntries) {
			if(entry.getEntryName().equals(removeUnderScores(entryTitle))) {
				toBeRemoved.add(entry);
			}
		}
		userEntries.removeAll(toBeRemoved);	

	}

	//PUT QUOTATIONS AROUND ENTRy TITLE
	public Entry updateEntry(Entry entry) {
		if(!(enteries.containsKey(entry.getUsername()))){
			throw new  EntryNotFoundException("Entry " + entry.getEntryName() + " not found.");
		}else {
			//IS THERE A CLEANER WAY TO DO THIS?????
			List<Entry> userEntries = enteries.get(entry.getUsername());
			for(Entry entry2 : userEntries) {
				if(entry2.getEntryName().equals(entry.getEntryName())) {
					entry2.setEntry(entry.getEntry());
				}
			}
		}
		return entry;
	}

	public String removeUnderScores(String entryTitle){
		return entryTitle.replaceAll("_", " ");
	}

	public boolean containProfile(String username) {
		if(this.profiles.containsKey(username)){
			return true;
		}
		return false;
	}

}
