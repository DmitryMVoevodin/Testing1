package com.artezio.testing;

public class EmptyObjectException extends Exception {

    public EmptyObjectException(){}

    public EmptyObjectException(String message){
        super(message);
    }

}