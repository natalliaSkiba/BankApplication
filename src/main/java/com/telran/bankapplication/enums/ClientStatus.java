package com.telran.bankapplication.enums;

public enum ClientStatus {
    ACTIVE(1),
    PENDING(2),
    REMOVED(3),
    BLOCKED(4);
    private final int value;
    ClientStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}