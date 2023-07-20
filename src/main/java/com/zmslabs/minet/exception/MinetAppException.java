package com.zmslabs.minet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MinetAppException extends RuntimeException{
    private final String message;
    private final String code;

}
