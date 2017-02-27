package ca.mcgill.ecse223.tileo.controller;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = -5633933762703837868L;

	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}
}
