package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// Task is to provide customized exception handling across the all request

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {


	private Date timeStamp;
    private String message;
    private String detail;


}
