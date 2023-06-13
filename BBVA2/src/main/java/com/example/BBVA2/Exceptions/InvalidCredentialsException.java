package com.example.BBVA2.Exceptions;

public class InvalidCredentialsException extends Exception{
    public InvalidCredentialsException(String name) {
        super("User: "+name+" not found.");
    }
}
