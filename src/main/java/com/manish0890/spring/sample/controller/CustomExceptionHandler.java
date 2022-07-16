package com.manish0890.spring.sample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manish0890.spring.sample.model.ErrorSummary;
import com.manish0890.spring.sample.model.exceptions.NotFoundException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    private final ObjectMapper mapper = new ObjectMapper();

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) throws JsonProcessingException {
        ErrorSummary summary = new ErrorSummary(e.getMessage(), ExceptionUtils.getRootCauseMessage(e), new Date());
        LOGGER.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapper.writeValueAsString(summary));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgEx(IllegalArgumentException e) throws JsonProcessingException {
        ErrorSummary summary = new ErrorSummary(e.getMessage(), ExceptionUtils.getRootCauseMessage(e), new Date());
        LOGGER.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(mapper.writeValueAsString(summary));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleIllegalArgEx(Exception e) throws JsonProcessingException {
        ErrorSummary summary = new ErrorSummary(e.getMessage(), ExceptionUtils.getRootCauseMessage(e), new Date());
        LOGGER.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapper.writeValueAsString(summary));
    }
}
