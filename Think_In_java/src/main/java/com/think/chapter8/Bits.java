package com.think.chapter8;

import java.util.BitSet;
import java.util.Random;

/**
 * Demonstration of BitSet
 */
public class Bits {
    public static void main(String[] args) {
        Random random = new Random();

        byte bt = (byte) random.nextInt();
        BitSet bitSet = new BitSet();
        for (int i = 7; i >= 0; i--) {
            if (((1 << i) & bt) != 0) {
                bitSet.set(i);
            } else {
                bitSet.clear(i);
            }
        }
        System.out.println("byte value : " + bt);
        printBitSet(bitSet);

        short st = (short) random.nextInt();
        BitSet bs = new BitSet();
        for (int i = 15; i >= 0; i--) {
            if (((1 << i) & st) != 0) {
                bs.set(i);
            } else {
                bs.clear(i);
            }
        }
        System.out.println("byte value : " + st);
        printBitSet(bs);

        int it = (short) random.nextInt();
        BitSet bi = new BitSet();
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & st) != 0) {
                bi.set(i);
            } else {
                bi.clear(i);
            }
        }
        System.out.println("byte value : " + it);
        printBitSet(bi);

        //Test bitsets >= 64 bits;
        BitSet b127 = new BitSet();
        b127.set(127);
        System.out.println("set bit 127: " + b127);
        BitSet b255 = new BitSet(65);
        b255.set(255);
        System.out.println("set bit 255: " + b255);
        BitSet b1023 = new BitSet(1023);
        b1023.set(1023);
        System.out.println("set bit 1023: " + b1023);
    }

    static void printBitSet(BitSet bitSet) {
        System.out.println("bits: " + bitSet);
        String bbits = new String();
        for (int j = 0; j < bitSet.size(); j++) {
            bbits += (bitSet.get(j) ? "1" : "0");
        }

        System.out.println("bit pattern: " + bbits);
    }
}
