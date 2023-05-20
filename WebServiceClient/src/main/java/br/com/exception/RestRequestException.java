package br.com.exception;

public class RestRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	public RestRequestException() {
	}

	public RestRequestException(String message) {
		super(message);		
	}

	public RestRequestException(Throwable cause) {
		super(cause);		
	}

	public RestRequestException(String message, Throwable cause) {
		super(message, cause);		
	}

	public RestRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);		
	}

}
