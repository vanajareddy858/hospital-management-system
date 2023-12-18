package com.marolix.exceptions;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class HospitalExceptionHandler {
 @ExceptionHandler(HospitalException.class)
		    public ResponseEntity<HospitalErrorHospital> handleHospitalException(HospitalException e) {
	 HospitalErrorHospital er = new HospitalErrorHospital();
		        er.setOccurredAt(LocalDateTime.now());
		        er.setErrorMessage(e.getMessage());
		        er.setStatusCode(HttpStatus.BAD_REQUEST.value());
		        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
		    }

		    @ExceptionHandler(ArithmeticException.class)
		    public ResponseEntity<HospitalErrorHospital> handleHospitalArithmeticException(ArithmeticException e) {
		    	HospitalErrorHospital er = new HospitalErrorHospital();
		        er.setOccurredAt(LocalDateTime.now());
		        er.setErrorMessage(e.getMessage());
		        er.setStatusCode(HttpStatus.BAD_REQUEST.value());
		        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
		    }

		    @ExceptionHandler(Exception.class)
		    public ResponseEntity<HospitalErrorHospital> handleGeneralException(Exception e) {
		    	HospitalErrorHospital er = new HospitalErrorHospital();
		        er.setOccurredAt(LocalDateTime.now());
		        er.setErrorMessage("Internal server error occurred. Exception: " + e.toString());
		        er.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
		    }

		    @ExceptionHandler(MethodArgumentNotValidException.class)
		    public ResponseEntity<HospitalErrorHospital> handleHospitalMethodArgumentInvalidException(MethodArgumentNotValidException e) {
		    	HospitalErrorHospital er = new HospitalErrorHospital();
		        er.setOccurredAt(LocalDateTime.now());
		        er.setStatusCode(HttpStatus.BAD_REQUEST.value());
		        List<ObjectError> lor = e.getBindingResult().getAllErrors();
		        String errMessage = lor.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
		        er.setErrorMessage(errMessage);
		        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
		    }

		    //@ExceptionHandler(ConstraintViolationException.class)
		   // public ResponseEntity<HospitalErrorHospital> handleHospitalConstraintViolationException(HospitalConstraintViolationException ce) {
		    	//HospitalErrorHospital er = new HospitalErrorHospital();
		        //er.setOccurredAt(LocalDateTime.now());
		      //  er.setStatusCode(HttpStatus.BAD_REQUEST.value());
		        //String errorMsg = ce.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
		            //    .collect(Collectors.joining(", "));
		       // er.setErrorMessage(errorMsg);
		      //  return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
		   // }

		    // Additional exception handlers can be added for specific exceptions related to the hospital application.

		    // ... other exception handlers ...
	}


