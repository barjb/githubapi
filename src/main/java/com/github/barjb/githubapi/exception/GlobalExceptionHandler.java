package com.github.barjb.githubapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<CustomError> handleBadRequestException(BadRequestException e) {
    log.debug(e.getMessage());
    return new ResponseEntity<>(
        new CustomError(400, e.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity<CustomError> handleInternalServerErrorException(InternalServerErrorException e) {
    log.debug(e.getMessage());
    return new ResponseEntity<>(
        new CustomError(500, e.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<CustomError> handleException(Exception e) {
    log.debug(e.getMessage());
    return new ResponseEntity<>(
        new CustomError(500, e.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
