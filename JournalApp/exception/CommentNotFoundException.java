package org.justinswork.JournalApp.exception;

public class CommentNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 4519995423206126593L;

	public CommentNotFoundException (String message) {
		super(message);
	}
	
}
