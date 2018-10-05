package igt.todolist.igttodolist.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @file: MyResponseEntity.java
 * @author: Arun Dhwaj
 * @date: 5th Oct, 2018
 * @purpose: Creating custom Response entity class 
 */

public class MyResponseEntity 
{
    private final static String ERROR_MESSAGE = "ErrorMessage";
    private final static String EXCEPTION_MESSAGE = "ExceptionMessage";
    private final static String EXCEPTION_MESSAGE_NOT_PROVIDED = "Not provided";

    public static <T> ResponseEntity<T> ok(T obj) 
    {
        return ResponseEntity.ok(obj);
    }

    public static <T> ResponseEntity<T> ok(T obj, HttpHeaders headers) 
    {
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(obj);
    }

    public static <T> ResponseEntity<T> error(HttpStatus httpStatus, String errorMessage, Exception exception, T obj) 
    {
        return ResponseEntity.status(httpStatus)
                .header(ERROR_MESSAGE, errorMessage)
                .header(EXCEPTION_MESSAGE, exception != null ? exception.getMessage() : EXCEPTION_MESSAGE_NOT_PROVIDED)
                .body(obj);
    }

    public static <T> ResponseEntity<T> error(HttpStatus httpStatus, String errorMessage, Exception exception) 
    {
        return error(httpStatus, errorMessage, exception, null);
    }

    public static <T> ResponseEntity<T> error(HttpStatus httpStatus, String errorMessage) 
    {
        return error(httpStatus, errorMessage, null);
    }
}
