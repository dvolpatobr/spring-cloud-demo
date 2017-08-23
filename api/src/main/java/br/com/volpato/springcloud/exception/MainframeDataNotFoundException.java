package br.com.volpato.springcloud.exception;

public class MainframeDataNotFoundException extends Exception {

	String message,error;
	
	
	public MainframeDataNotFoundException(String message, String error) {
		
		this.error = error;
		this.message = message;
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

}
