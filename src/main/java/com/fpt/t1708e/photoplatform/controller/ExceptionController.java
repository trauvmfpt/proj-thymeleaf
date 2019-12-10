package com.fpt.t1708e.photoplatform.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404Exception(NoHandlerFoundException ex) {
        //do whatever you want
        return "redirect:/error/404";
    }
    @ExceptionHandler(Exception.class)
    public String handle500Exception() {
        //do whatever you want
        return "redirect:/error/500";
    }

}
