package br.com.jkavdev.ed.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = false)
public class EDException extends RuntimeException {

	public EDException() {
		super();
	}

	public EDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EDException(String message, Throwable cause) {
		super(message, cause);
	}

	public EDException(String message) {
		super(message);
	}

	public EDException(Throwable cause) {
		super(cause);
	}

}
