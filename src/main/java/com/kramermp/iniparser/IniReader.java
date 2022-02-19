package com.kramermp.iniparser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class IniReader {

    String targetFile = "";
    BufferedReader in = null;
    HashMap<String, HashMap<String, String>> results = new HashMap<>();

    public IniReader(String targetFile) throws IOException {
        this.targetFile = targetFile;
        this.in = new BufferedReader(new FileReader(targetFile));
        loadFile();
    }

    private void loadFile() throws IOException {
        String curLine = in.readLine();
        HashMap<String, String> curSection = new HashMap<>();
        while(curLine != null) {
            curSection.put(curLine, curLine);
        }
        results.put("Section", curSection);
    }
}
