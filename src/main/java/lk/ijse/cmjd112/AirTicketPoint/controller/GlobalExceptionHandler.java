package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.ErrorMessage;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataSaveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

import static lk.ijse.cmjd112.AirTicketPoint.util.CustomStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleDataNotFoundException(DataNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(ex.getMessage(),DATA_NOT_FOUND));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(DELETE_CONSTRAINT, CANNOT_DELETE));
    }

    @ExceptionHandler(DataSaveException.class)
    public ResponseEntity<ErrorMessage> handleDataSaveException(DataSaveException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(ex.getMessage(),CANNOT_PROCESS));
    }

}
