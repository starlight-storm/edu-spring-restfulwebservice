package com.example.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.common.exception.EmployeeDeleteException;

@RestControllerAdvice
public class RestControllerExceptionHandler {

	private static final String HTTP_LOCALHOST_8080_V1_EMPLOYEES = "http://localhost:8080/api/v1/employees";

	@ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    RestControllerError notFoundException(RuntimeException e) {
        return new RestControllerError(e.getMessage(), HTTP_LOCALHOST_8080_V1_EMPLOYEES);
    }
	
	// TODO 演習4 EmployeeDeleteExceptionが発生したら、404になるようなアノテーションを記述しなさい
    RestControllerError notFoundException(EmployeeDeleteException e) {
        return new RestControllerError(e.getMessage(), HTTP_LOCALHOST_8080_V1_EMPLOYEES);
    }
	
	// TODO 演習4 BindExceptionが発生したら、400になるようなアノテーションを記述しなさい
    List<RestControllerError> bindException(BindException e) {
		List<RestControllerError> errors = new ArrayList<RestControllerError>();
		  for(ObjectError err : e.getAllErrors()){
		      errors.add(new RestControllerError(err.getDefaultMessage(),
		    		  HTTP_LOCALHOST_8080_V1_EMPLOYEES));
		  }
        return errors;
    }
}