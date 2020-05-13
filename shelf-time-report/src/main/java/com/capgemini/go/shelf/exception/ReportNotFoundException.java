package com.capgemini.go.shelf.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReportNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public ReportNotFoundException(String message){
        super(message);
    }
}