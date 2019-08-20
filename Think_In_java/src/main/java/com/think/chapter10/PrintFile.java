package com.think.chapter10;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Shorthand class for opening an output file for human-readable output
 */
public class PrintFile extends PrintStream {

    public PrintFile(String filename) throws IOException {
        super(new BufferedOutputStream(new FileOutputStream(filename)));
    }

    public PrintFile(File file) throws IOException {
        this(file.getPath());
    }

}
