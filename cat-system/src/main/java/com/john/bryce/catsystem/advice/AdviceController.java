package com.john.bryce.catsystem.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.john.bryce.catsystem.exceptions.CatSystemException;

@RestControllerAdvice
public class AdviceController {

  @ExceptionHandler(value = { CatSystemException.class })
  public ProblemDetail catSystemHandlerError(CatSystemException e) {
    return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
  }

  @ExceptionHandler(value = { Exception.class })
  public ProblemDetail generalHandlerError(Exception e) {
    return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "something went wrong please try again latter :(");
  }

}
