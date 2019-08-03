package com.think.chapter7.innerscopes;

public class Parcel8 {

    public Destination dest(final String dest) {
        return new Destination() {
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        parcel8.dest("Tanzania");
    }
}
