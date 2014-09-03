package us.kbase.toc.exceptions;

public class TypedObjectConversionException extends Exception {

	private static final long serialVersionUID = 1310946294196407521L;
	
	public TypedObjectConversionException(String message) {
		super(message);
	}

	public TypedObjectConversionException(String message, Throwable e) {
		super(message,e);
	}

}
