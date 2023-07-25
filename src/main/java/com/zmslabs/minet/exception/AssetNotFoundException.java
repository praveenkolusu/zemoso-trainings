package com.zmslabs.minet.exception;

import lombok.Getter;

@Getter
public class AssetNotFoundException extends RuntimeException{
    private final String message;
    public AssetNotFoundException(String message){
        super(message);
        this.message= message;
    }
}
