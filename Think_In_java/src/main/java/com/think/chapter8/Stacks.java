package com.think.chapter8;

import java.util.Stack;

/**
 * Demonstratioin of Stack Class
 */
public class Stacks {
    static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < months.length; ++i) {
            stack.push(months[i] + " ");
        }

        System.out.println("stack  = " + stack);
        //Treating a stack as a vector
        stack.addElement("The last line");
        System.out.println("element 5 = " + stack.elementAt(5));
        System.out.println("poping elements:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
