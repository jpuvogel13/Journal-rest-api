package org.justinswork.JournalApp.exception;

public class EntryNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5482039635510190374L;
	
	public EntryNotFoundException(String message) {
		super(message);
	}

}
