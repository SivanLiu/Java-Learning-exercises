package com.think.chapter10;

import java.io.File;

/**
 * Uses Java anonymous inner classes
 */
public class DirList3 {
    public static void main(String[] args) {
        try {
            File path = new File(".");
            String[] list;
            if (args.length == 0) {
                list = path.list();
            } else {
                list = path.list((dir, name) -> {
                    //Strip path information
                    String f = new File(name).getName();
                    return f.indexOf(args[0]) != -1;
                });
            }

            for (int i = 0; i < list.length; ++i) {
                System.out.println(list[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
