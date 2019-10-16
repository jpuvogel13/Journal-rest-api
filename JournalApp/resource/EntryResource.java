package org.justinswork.JournalApp.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.justinswork.JournalApp.model.Entry;
import org.justinswork.JournalApp.service.EntryService;

@Path("/enteries")
public class EntryResource {

	EntryService entryService = new EntryService();


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Entry createEntry(Entry entry) {	
		return entryService.addEntry(entry);
	}


	@GET
	@Path("/{username}")
	public List<Entry> getAllEntriesByAUser(@PathParam("username") String username){
		return entryService.getUserEntries(username);
	}

	@GET
	@Path("/all/{entryTitle}")
	public List<Entry> getEntriesByTitle(@PathParam("entryTitle") String entryTitle){
		String updatedEntryTitle = entryService.removeUnderScores(entryTitle);
		return entryService.getEntriesByTitle(updatedEntryTitle);
	}
	
	@PUT
	@Path("/{username}")
	public Entry editEntry(Entry entry){
		return entryService.updateEntry(entry);
	}

	@DELETE
	@Path("/{username}/{entryTitle}")
	public void deleteEntry(@PathParam("username")String username,
			@PathParam("entryTitle") String entryTitle){
		entryService.deleteEntry(username,entryTitle);
	} 

}

    
    
	
	
	


	
	
