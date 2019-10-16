package org.justinswork.JournalApp.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import org.justinswork.JournalApp.model.ErrorMessage;

public class CommentNotFoundExceptionMapper implements ExceptionMapper<CommentNotFoundException>{

	@Override
	public Response toResponse(CommentNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage("The comment your looking for cannot be found.", "The comment your looking for isn't in the database." ,404);
		return Response.status(Status.NOT_FOUND).
				entity(errorMessage).
				type(MediaType.APPLICATION_JSON).
				build();
	}

}
