package com.think.chapter10;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Testing for the end of file while reading a byte at a time
 */
public class TestEOF {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("build.gradle")
                    )
            );

            while (in.available()!= 0){
                System.out.println((char)in.readByte());
            }
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("IOException");
        }
    }
}
