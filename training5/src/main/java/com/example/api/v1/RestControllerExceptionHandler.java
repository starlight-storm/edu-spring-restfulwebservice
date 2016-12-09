package com.example.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import common.example.common.exception.EmployeeDeleteException;

@RestControllerAdvice
public class RestControllerExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    RestControllerError notFoundException(RuntimeException e) {
        return new RestControllerError(e.getMessage(), "http://localhost:8080/v1/employees");
    }
	
	@org.springframework.web.bind.annotation.ExceptionHandler({ EmployeeDeleteException.class })
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    RestControllerError notFoundException(EmployeeDeleteException e) {
        return new RestControllerError(e.getMessage(), "http://localhost:8080/v1/employees");
    }
	
	@org.springframework.web.bind.annotation.ExceptionHandler({ BindException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    List<RestControllerError> bindException(BindException e) {
		List<RestControllerError> errors = new ArrayList<RestControllerError>();
		  for(ObjectError err : e.getAllErrors()){
		      errors.add(new RestControllerError(err.getDefaultMessage(),
		    		  "http://localhost:8080/v1/employees"));
		  }
        return errors;
    }
}