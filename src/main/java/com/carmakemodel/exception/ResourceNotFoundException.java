package com.carmakemodel.exception;

public class ResourceNotFoundException extends RuntimeException{

	private String resourceName;
	private String filedValue;
	private Object fieldValue;
	public ResourceNotFoundException(String resourceName, String filedValue, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName,filedValue,fieldValue));
		this.resourceName = resourceName;
		this.filedValue = filedValue;
		this.fieldValue = fieldValue;
	}
	
}
