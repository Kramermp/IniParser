package com.kramermp.iniparser.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    String sampleKey = "[SampleKey]";
    String sampleLine = "SampleLine=This";
    String sampleComment = "#SampleComment";

    @Test
    void isCommentTrue() {
        assertTrue(Parser.isComment(sampleComment));
    }

    @Test
    void isCommentFalseLine() {
        assertFalse(Parser.isComment(sampleLine));
    }
    @Test
    void isCommentFalseKey() {
        assertFalse(Parser.isComment(sampleKey));
    }

    @Test
    void isKeyTrue() {
        assertTrue(Parser.isKey(sampleKey));
    }

    @Test 
    void isKeyFalseLine() {
        assertFalse(Parser.isKey(sampleLine));
    }
    @Test
    void isKeyFalseComment() {
        assertFalse(Parser.isKey(sampleComment));
    }

    @Test
    void isLineTrue() {
        assertTrue(Parser.isLine(sampleLine));
    }
}