package org.justinswork.JournalApp.exception;

public class ProfileNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 6724942897224258876L;

	public ProfileNotFoundException(String message) {
		super(message);
	}
}
