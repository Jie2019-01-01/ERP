package cn.itcast.erp.exception;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 8515831352283184429L;

	public AppException() {}
	
	public AppException(String message) {super(message);}
}
