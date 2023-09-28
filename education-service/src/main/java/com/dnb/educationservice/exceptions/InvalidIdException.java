package com.dnb.educationservice.exceptions;

public class InvalidIdException extends Exception {
	public InvalidIdException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}
}
