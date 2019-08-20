package com.think.chapter10;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Shorthand class for opening an output file for data storage
 */
public class OutFile extends DataOutputStream {
    public OutFile(String filename) throws IOException {
        super(new BufferedOutputStream(new FileOutputStream(filename)));
    }

    public OutFile(File file) throws IOException {
        this(file.getPath());
    }
}
