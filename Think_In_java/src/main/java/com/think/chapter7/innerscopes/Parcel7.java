package com.think.chapter7.innerscopes;


public class Parcel7 {
    public Wrapping wrap(int x) {
        return new Wrapping(x) {
            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        parcel7.wrap(10);
    }
}
