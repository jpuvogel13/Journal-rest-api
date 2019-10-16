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

import org.justinswork.JournalApp.model.Profile;
import org.justinswork.JournalApp.service.ProfileService;

@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		profileService.addProfile(profile);
		return profile;
	}
	
	@GET
	public List<Profile> getAllProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{username}")
	public Profile getProfileByUsername(@PathParam ("username") String username) {
		return profileService.getProfile(username);
		}
	
	@GET
	@Path("sortBy/{location}")
	public List<Profile> getProfilesByLocation(@PathParam("location")String location){
		return profileService.getProfilesByLocation(location);

	 }
	
	@PUT
	@Path("/{username}/{location}")
	public void updateLocation(@PathParam("username")String username,
								 @PathParam("location")  String location) {
		profileService.updateLocation(username,location);
		
	}
	
	@DELETE
	@Path("/{username}")
	public void deleteProfile(@PathParam("username")String username) {
		profileService.deleteProfile(username);
	}
	
	
	
	

}
