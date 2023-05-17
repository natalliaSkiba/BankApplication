package com.telran.bankapplication.validation;

import java.util.UUID;

public class UUIDValidator {
    public static boolean isValidUUID(String uuidString) {
        try {
            UUID uuid = UUID.fromString(uuidString);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
