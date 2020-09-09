package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//Applicable to all controller of the project

@ControllerAdvice

@RestController
public class CustomizedResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    public final ResponseEntity<Object> handleUserExceptions(UserNotFound ex, WebRequest request) throws Exception{

        // we want exception handling in a specific format that we defined in Exception Response

        //ex.getMessage() prints the message via UserNotFound class that we defined in UserController--> User Not found

        //request.getDescription() returns the url in which error happened --> uri=/users/1

        // so now whenever some bad request is sent it will come in format of timestamp,message(user not found),detail(url)

        ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

    }


    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception{

        // we want exception handling in a specific format that we defined in Exception Response

        ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }



//This method getfired when binding to a specific method argument fails.
// In user controller inside create method User user is binding object at when validation is failed at user then this is called.
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        //ex.getBindingResult() shows what actually went wrong in validation
        ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(),ex.getBindingResult().toString());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
