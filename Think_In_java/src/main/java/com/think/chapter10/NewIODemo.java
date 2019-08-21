package com.think.chapter10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.io.StringReader;

public class NewIODemo {
    public static void main(String[] args) {
        try {
            //1. Reading input by lines;
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            String s, s2 = new String();
            while ((s = in.readLine()) != null) {
                s2 += s + "\n";
            }

            in.close();

            //2. Input from memory
            StringReader in2 = new StringReader(s2);
            int c;
            while ((c = in2.read()) != -1) {
                System.out.println((char) c);
            }

            //3. Formatted memory input
            try {
                DataInputStream in3 = new DataInputStream(new StringBufferInputStream(s2));
                while (true) {
                    System.out.println((char) in3.readByte());
                }
            } catch (EOFException e) {
                System.out.println("End of stream");
            }

            //4. Line number & file output
            try {
                LineNumberReader li = new LineNumberReader(new StringReader(s2));

                BufferedReader in4 = new BufferedReader(li);
                PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("IODemo.out")));

                while ((s = in4.readLine()) != null) {
                    out1.println("Line " + li.getLineNumber() + s);
                }

                out1.close();
            } catch (EOFException e) {
                System.out.println("End of stream");
            }

            // 5. Storing & recovering data
            try {
                DataOutputStream out2 = new DataOutputStream(
                        new BufferedOutputStream(new FileOutputStream("Data.txt")));
                out2.writeDouble(3.1415926);
                out2.writeBytes("That was pi");
                out2.close();

                DataInputStream in5 = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
                BufferedReader in5br = new BufferedReader(new InputStreamReader(in5));

                //Must use DataInputStream for data
                System.out.println(in5.readDouble());

                //Can now use the proper readLine()
                System.out.println(in5br.readLine());

            } catch (EOFException e) {
                System.out.println("End of stream");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + args[1]);
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }
}
