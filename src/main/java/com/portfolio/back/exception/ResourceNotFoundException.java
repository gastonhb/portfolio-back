package com.portfolio.back.exception;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter @Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String attributeName;
	private UUID attributeValue;

	public ResourceNotFoundException(String resourceName, String attributeName, UUID attributeValue) {
		super(String.format("%s not found with: %s:'%s'", resourceName, attributeName, attributeValue));
		this.resourceName = resourceName;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}

}
