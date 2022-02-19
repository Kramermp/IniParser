package com.kramermp.iniparser.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    String sampleSectionKey = Parser.KEY_OPENER + "SampleKey" + Parser.KEY_CLOSER;
    String sampleBadKey1  = "SampleBadKey1" + Parser.KEY_CLOSER;
    String sampleBadKey2  = Parser.KEY_OPENER + "SampleBadKey2";
    String sampleKey = "SampleKey";
    String sampleValue = "SampleValue";
    String sampleLine = sampleKey + Parser.LINE_SPLIT + sampleValue;
    String sampleComment = Parser.COMMENT_CHAR + "SampleComment";
    String emptyLine = "";

    @Test
    void isCommentTrue() {
        assertTrue(Parser.isComment(sampleComment));
    }

    @Test
    void isCommentEmptyLine() {
        assertFalse(Parser.isComment(emptyLine));
    }

    @Test
    void isCommentNull() {
        assertFalse(Parser.isComment(null));
    }

    @Test
    void isCommentFalseLine() {
        assertFalse(Parser.isComment(sampleLine));
    }
    @Test
    void isCommentFalseKey() {
        assertFalse(Parser.isComment(sampleSectionKey));
    }

    @Test
    void isKeyTrue() {
        assertTrue(Parser.isSectionKey(sampleSectionKey));
    }

    @Test
    void isKeyFalseBadKey1() {
        assertFalse(Parser.isSectionKey(sampleBadKey1));
    }
    @Test
    void isKeyFalseBadKey2() {
        assertFalse(Parser.isSectionKey(sampleBadKey2));
    }


    @Test 
    void isKeyFalseLine() {
        assertFalse(Parser.isSectionKey(sampleLine));
    }
    @Test
    void isKeyFalseComment() {
        assertFalse(Parser.isSectionKey(sampleComment));
    }

    @Test
    void getValuesSimple() {
        String[] results = new String[0];
        try {
            results = Parser.getValues(sampleLine);
            assertEquals(sampleKey, results[0]);
            assertEquals(sampleValue, results[1]);
        } catch (BadFormatException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void getValuesInLineComment() {
        String[] results = new String[0];
        try {
            results = Parser.getValues(sampleLine + " " + sampleComment);
            assertEquals(sampleKey, results[0]);
            assertEquals(sampleValue, results[1]);
        } catch (BadFormatException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void getValuesEscapedComment() {
        String[] results = new String[0];
        try {
            results = Parser.getValues(sampleLine + Parser.ESCAPE + sampleComment);
            assertEquals(sampleKey, results[0]);
            assertEquals(sampleValue + sampleComment, results[1]);
        } catch (BadFormatException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void getValuesEscapedSplit() {
        String[] results = new String[0];
        try {
            results = Parser.getValues(sampleKey + Parser.ESCAPE  + Parser.LINE_SPLIT + sampleLine);
            assertEquals(sampleKey + Parser.LINE_SPLIT + sampleKey, results[0]);
            assertEquals(sampleValue, results[1]);
        } catch (BadFormatException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void getValuesBadNoSplit() {
        BadFormatException ex = null;
        try {
            String[] results = Parser.getValues(sampleKey + sampleValue);
        } catch (BadFormatException e) {
            ex = e;
        }
        assertNotNull(ex);
    }

    @Test
    void getValuesBadNoKey() {
        BadFormatException ex = null;
        try {
            String[] results = Parser.getValues(Parser.LINE_SPLIT + sampleValue);
        } catch (BadFormatException e) {
            ex = e;
        }
        assertNotNull(ex);
    }

    @Test
    void getValuesBadNoValue() {
        BadFormatException ex = null;
        try {
            String[] results = Parser.getValues(sampleKey + Parser.LINE_SPLIT);
        } catch (BadFormatException e) {
            ex = e;
        }
        assertNotNull(ex);
    }

    @Test
    void getValuesBadEmptyLine() {
        BadFormatException ex = null;
        try {
            String[] results = Parser.getValues(emptyLine);
        } catch (BadFormatException e) {
            ex = e;
        }
        assertNotNull(ex);
    }

    @Test
    void getValuesBadEmptyNull() {
        BadFormatException ex = null;
        try {
            String[] results = Parser.getValues(null);
        } catch (BadFormatException e) {
            ex = e;
        }
        assertNotNull(ex);
    }
}