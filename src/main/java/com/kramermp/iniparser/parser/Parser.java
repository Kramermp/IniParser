package com.kramermp.iniparser.parser;

public class Parser {

    public static boolean isComment(String testString) {
        return testString != null && testString.length() > 0 && testString.charAt(0) == '#';
    }

    public static boolean isKey(String testString) {
        return false;
    }

    public static boolean isLine(String testString) {
        return false;
    }

}
