package com.think.chapter10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.StringBufferInputStream;

/**
 * Typical IO Stream Configurations
 */
public class IOStreamDemo {
    public static void main(String[] args) {
        try {
            //1、Buffered input file
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(args[0])));
            String s, s2 = new String();
            while ((s = in.readLine()) != null) {
                s2 += s + "\n";
            }

            in.close();

            //2. Input from memory
            StringBufferInputStream in2 = new StringBufferInputStream(s2);
            int c;
            while ((c = in2.read()) != -1) {
                System.out.println((char) c);
            }

            //3. Formatted memory input
            try {
                DataInputStream in3 = new DataInputStream(new DataInputStream(new StringBufferInputStream(s2)));
                while (true) {
                    System.out.println((char) in3.readByte());
                }
            } catch (EOFException e) {
                System.out.println("End of stream encountered");
            }

            //4. Line numbering & file output
            try {
                LineNumberInputStream li = new LineNumberInputStream(new StringBufferInputStream(s2));
                DataInputStream in4 = new DataInputStream(li);
                PrintStream out1 = new PrintStream(new BufferedOutputStream(new FileOutputStream("IODemo.out")));
                while ((s = in4.readLine()) != null) {
                    out1.println("Line " + li.getLineNumber() + s);
                }

                out1.close();
            } catch (EOFException e) {
                System.out.println("End of stream encountered");
            }

            //5. Storing & recovering data
            try {
                DataOutputStream out2 = new DataOutputStream(
                        new BufferedOutputStream(new FileOutputStream("Data.txt")));
                out2.writeBytes("Here's the value of pi: \n");
                out2.writeDouble(3.1415926);
                out2.close();

                DataInputStream in5 = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
                System.out.println(in5.readLine());
                System.out.println(in5.readDouble());
            } catch (EOFException e) {
                System.out.println("End of stream encountered");
            }

            //6. Reading/writing random access files
            RandomAccessFile rf = new RandomAccessFile("rtest.dat", "rw");
            for (int i = 0; i < 10; i++) {
                rf.writeDouble(i * 1.414);
            }

            rf.close();

            rf = new RandomAccessFile("rtest.dat", "rw");
            rf.seek(5 * 8);
            rf.writeDouble(47.00001);
            rf.close();

            rf = new RandomAccessFile("rtest.dat", "r");
            for (int i = 0; i < 10; ++i) {
                System.out.println("Value " + i + " : " + rf.readDouble());
            }
            rf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
