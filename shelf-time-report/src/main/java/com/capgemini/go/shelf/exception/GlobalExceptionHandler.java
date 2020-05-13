package com.capgemini.go.shelf.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.sql.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;


public class GlobalExceptionHandler {

	    @ExceptionHandler(ReportNotFoundException.class)
	    public ResponseEntity<?> reportNotFoundException(ReportNotFoundException ex, WebRequest request) {
	         ExceptionDetails errorDetails = new ExceptionDetails(new Date(0), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globalExcpetionHandler(Exception ex, WebRequest request) {
	    	ExceptionDetails errorDetails = new ExceptionDetails(new Date(0), ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    @ExceptionHandler(Exception.class)
		public ResponseEntity<String> globaExceptionHandler(Exception ex, WebRequest request){
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	    
	    @ExceptionHandler(Exception.class)
		public ResponseEntity<String> globalExceptionHandler(Exception ex, WebRequest request){
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}

}
