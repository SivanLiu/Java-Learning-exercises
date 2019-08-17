package com.think.chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Demonstrates performance differences in Lists
 */
public class ListPerformance {
    private static final int REPS = 100;

    private abstract static class Tester {
        String name;
        int size;

        Tester(String name, int size) {
            this.name = name;
            this.size = size;
        }

        abstract void test(List a);
    }

    private static Tester[] testers = { new Tester("get", 300) {
        @Override
        void test(List a) {
            for (int i = 0; i < REPS; ++i) {
                for (int j = 0; j < a.size(); ++j) {
                    a.get(j);
                }
            }
        }
    }, new Tester("iteration", 300) {
        @Override
        void test(List a) {
            for (int i = 0; i < REPS; ++i) {
                Iterator iterator = a.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                }
            }
        }
    }, new Tester("remove", 300) {
        @Override
        void test(List a) {
            ListIterator iterator = a.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
    } };

    public static void test(List a){
        System.out.println("Testing "+a.getClass().getName());
        for(int i =0;i<testers.length;++i){
            Collection1.fill(a, testers[i].size);
            System.out.println(testers[i].name);
            long t1 = System.currentTimeMillis();
            testers[i].test(a);
            long t2 = System.currentTimeMillis();
            System.out.println(": "+(t2 - t1));
        }
    }
    public static void main(String[] args) {
            test(new ArrayList());
            test(new LinkedList());
    }
}
