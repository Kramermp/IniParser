package com.kramermp.iniparser.parser;

public class BadFormatException extends Exception {
    String message = "";
    public BadFormatException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
