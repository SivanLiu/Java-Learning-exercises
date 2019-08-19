package com.think.chapter10;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Uses Java anonymous inner classes
 */
public class DirList2 {
    public static FilenameFilter filter(final String afn) {
        //Creation of anonymous inner class
        return new FilenameFilter() {
            String fn = afn;

            @Override
            public boolean accept(File dir, String name) {
                //Strip path information
                String f = new File(name).getName();
                return f.contains(fn);
            }
        }; // End of anonymous inner class
    }

    public static void main(String[] args) {
        try {
            File path = new File(".");
            String[] list;
            if (args.length == 0) {
                list = path.list();
            } else {
                list = path.list(filter(args[0]));
            }

            for (int i = 0; i < list.length; ++i) {
                System.out.println(list[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
