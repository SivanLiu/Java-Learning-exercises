package com.think.chapter10;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Try to recover a serialized file without the class of object that's stored in that file
 */
public class ThawAlien {
    public static void main(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("file.x")
        );
        Object mystery = in.readObject();
        System.out.println(mystery.getClass().toString());
    }
}
