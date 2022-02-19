package com.kramermp.iniparser.parser;

public class Parser {
    public static final char COMMENT_CHAR = '#';
    public static final char KEY_OPENER = '[';
    public static final char KEY_CLOSER = ']';
    public static final char LINE_SPLIT = '=';
    public static final char ESCAPE = '`';

    private static StringBuilder sb = new StringBuilder();
    public static boolean isComment(String testString) {
        return testString != null && testString.length() > 0 && testString.charAt(0) == COMMENT_CHAR;
    }

    public static boolean isSectionKey(String testString) {
        return testString != null
                && testString.length() > 0
                && testString.charAt(0) == KEY_OPENER
                && testString.charAt(testString.length() - 1) == KEY_CLOSER;
    }

    public static String[] getValues(String testString) throws BadFormatException {
        if(testString == null || testString.length() == 0) {
            throw new BadFormatException("Empty or Null Line");
        }
        String[] results = new String[2];
        //results = testString.split(LINE_SPLIT);
        sb.setLength(0);
        int targetIndex  = 0;
        char[] testChar = {LINE_SPLIT, COMMENT_CHAR};
        for(int i = 0; i < testString.length(); i++) {
            if(testString.charAt(i) == testChar[targetIndex]) {
                if(i != 0 && testString.charAt(i - 1) == ESCAPE) {
                    sb.replace(sb.length() - 1, sb.length(), String.valueOf(testString.charAt(i)));
                } else {
                    results[targetIndex] = sb.toString().trim();
                    sb.setLength(0);
                    targetIndex++;
                }
            } else {
                sb.append(testString.charAt(i));
            }
            if(targetIndex >= 2) {
                break;
            }
        }
        // Flush the Remainder
        if(sb.length() != 0 && results[1] == null) {
            results[1] = sb.toString();
            sb.setLength(0);
        }
        if(results[0] == null || results[1] == null || results[0].length() == 0 || results[1].length() == 0) {
            throw new BadFormatException("Bad Format");
        }
        return results;
    }

}
