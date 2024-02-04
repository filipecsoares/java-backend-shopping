package com.fcs.userapi.config;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fcs.dto.ErrorDTO;
import com.fcs.exception.UserNotFoundException;

@ControllerAdvice(basePackages = "com.fcs.userapi.controller")
public class UserControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {
        return new ErrorDTO(HttpStatus.NOT_FOUND.value(), userNotFoundException.getMessage(), new Date());
    }
}
