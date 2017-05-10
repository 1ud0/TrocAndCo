package com.tac.exception;

public class NotEnoughCreditException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotEnoughCreditException(String message) {
		super(message);
	}
}
