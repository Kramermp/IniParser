package com.kramermp.iniparser.parser;

public class Parser {
    public static final char COMMENT_CHAR = '#';
    public static final char KEY_OPENER = '[';
    public static final char KEY_CLOSER = ']';

    public static boolean isComment(String testString) {
        return testString != null && testString.length() > 0 && testString.charAt(0) == COMMENT_CHAR;
    }

    public static boolean isKey(String testString) {
        return testString != null
                && testString.length() > 0
                && testString.charAt(0) == KEY_OPENER
                && testString.charAt(testString.length() - 1) == KEY_CLOSER;
    }

    public static boolean isLine(String testString) {
        return false;
    }

}
