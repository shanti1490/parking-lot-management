package org.example.exception;

public class GeneralServiceException extends RuntimeException{
    public GeneralServiceException(String msg)
    {
        super(msg);
    }
}
