package org.justinswork.JournalApp.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.justinswork.JournalApp.model.ErrorMessage;

public class ProfileNotFoundExceptionMapper implements ExceptionMapper<ProfileNotFoundException> {

	@Override
	public Response toResponse(ProfileNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage("The profile your looking for is not in our database.", "The profile your searching for is not found.", 404);
		return Response.status(Status.NOT_FOUND).
				entity(errorMessage).
				type(MediaType.APPLICATION_JSON).
				build();
	}
	

}
