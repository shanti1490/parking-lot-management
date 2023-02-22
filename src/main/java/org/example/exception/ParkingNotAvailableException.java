package org.example.exception;

public class ParkingNotAvailableException extends RuntimeException {
    public ParkingNotAvailableException(String msg)
    {
        super(msg);
    }
}
