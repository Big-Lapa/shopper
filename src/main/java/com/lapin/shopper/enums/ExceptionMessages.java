package com.lapin.shopper.enums;

public enum ExceptionMessages {

    NOT_FOUND("Can't found value with ID: ");

    private String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}