package com.kramermp.iniparser.reader;

import com.kramermp.iniparser.reader.Reader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ReaderTest {
    @Test
    public void constructorTest() {
        try {
            new Reader("Test");
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}