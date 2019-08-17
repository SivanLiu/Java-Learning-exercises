package com.think.chapter8;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {

    public static Collection fill(Collection c, int start, int size) {
        for (int i = start; i < (start + size); ++i) {
            c.add(Integer.toString(i));
        }
        return c;
    }

    public static Collection fill(Collection c, int size){
        return fill(c, 0, size);
    }

    public static Collection fill(Collection collection){
        return fill(collection, 0, 10);
    }

    public static Collection newCollection(int start, int size){
        return fill(new ArrayList(), start, size);
    }
}
