package com.telran.bankapplication.service.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException (String message){
        super(message);
    }

}
