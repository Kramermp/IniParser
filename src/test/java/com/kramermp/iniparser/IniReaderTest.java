package com.kramermp.iniparser;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class IniReaderTest {
    @Test
    public void constructorTest() {
        try {
            new IniReader("Test");
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}