package com.example.api.v1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestControllerError implements Serializable {
	
	private String message;
	
	@JsonProperty("documentation_url")
	private String documentationURL;

	public RestControllerError(String message, String documentationURL) {
		this.message = message;
		this.documentationURL = documentationURL;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	
	private static final long serialVersionUID = 1L;
}
