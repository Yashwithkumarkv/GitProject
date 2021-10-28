package com.te.springproject.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(EmployeeException.class)
	public String getException(HttpServletRequest request, EmployeeException exception) {
		request.setAttribute("msg", exception.getMessage());
		return "login";
	}
}
