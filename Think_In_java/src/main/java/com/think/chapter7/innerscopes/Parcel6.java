package com.think.chapter7.innerscopes;

public class Parcel6 {

    public Contents cont() {
        return new Contents() {

            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        Contents contents = parcel6.cont();
    }
}
