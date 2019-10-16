package org.justinswork.JournalApp.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.justinswork.JournalApp.model.ErrorMessage;


import javax.ws.rs.core.Response.Status;

@Provider  
public class EntryNotFoundExceptionMapper implements ExceptionMapper<EntryNotFoundException> {

	@Override
	public Response toResponse(EntryNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), "The entry you are searching for is not in the database. Re-check the entries title for spelling errors.", 404);
		return Response.status(Status.NOT_FOUND).
				entity(errorMessage).
				type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	

}
