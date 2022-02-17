package com.example.sms.exception;

public class ResourceNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private long fieldValue;
	
	public ResourceNotFound(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s is not found %s:'%s'", resourceName,fieldName,fieldValue));//
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public long getFieldValue() {
		return fieldValue;
	}
	
	

}
