package com.zmslabs.minet.exception;

import com.zmslabs.minet.model.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> dataNotFoundExceptionHandler(DataNotFoundException exception){
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .code("9001").message(exception.getMessage()).build();
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MinetAppException.class)
    public ResponseEntity<ErrorResponseDTO> minetAppExceptionHandler(MinetAppException exception){
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .code(exception.getCode()).message(exception.getMessage()).build();
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> exceptionHandler(Exception exception){
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .code("9000")
                .message("internal error").build();
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(AssetNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> assetNotFoundExceptionHandler(AssetNotFoundException assetNotFoundException){
        ErrorResponseDTO errorResponseDTO =ErrorResponseDTO.builder()
                .message(assetNotFoundException.getMessage()).code("9020").build();
        return new ResponseEntity<>(errorResponseDTO,HttpStatus.NOT_FOUND);
    }
}
