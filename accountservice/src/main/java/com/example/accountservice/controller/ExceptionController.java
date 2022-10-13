//package com.example.accountservice.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.sql.SQLIntegrityConstraintViolationException;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//@Slf4j
//public class ExceptionController {
//
//    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public Map<String, String> conflictData(Exception exception) {
//        log.info(exception.getMessage());
//        Map<String, String> response = new HashMap<>();
//        response.put("code", "409");
//        response.put("error", "Conflict data");
//        return response;
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    public Map<String, String> methodNotSupportedException(Exception exception) {
//        log.info(exception.getMessage());
//        Map<String, String> response = new HashMap<>();
//        response.put("code", "405");
//        response.put("error", "Method Not Allow");
//        return response;
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public Map<String, String> badRequestHandler(Exception exception) {
//        log.info(exception.getMessage());
//        Map<String, String> response = new HashMap<>();
//        response.put("code", "400");
//        response.put("error", "Params are wrong types");
//        return response;
//    }
//}
