package com.think.chapter7;

public class Parcel1 {

    class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }

        String readLabel(){
            return label;
        }
    }

    public void ship(String dest){
        Contents contents = new Contents();
        Destination destination = new Destination(dest);
    }

    public static void main(String[] args) {
        Parcel1 parcel1 = new Parcel1();
        parcel1.ship("Tanzania");
    }
}
