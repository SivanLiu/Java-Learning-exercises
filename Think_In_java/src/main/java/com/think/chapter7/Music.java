package com.think.chapter7;

//上溯造型
class Note{
    private int value;
    private Note(int val){
        value = val;
    }

    public static final Note middleC = new Note(0),
                            cSharp = new Note(1),
                            CFlat = new Note(2);
}

class Instrument{
    public void play(Note n){
        System.out.println("instrument.play");
    }
}

class Wind extends Instrument{
    @Override
    public void play(Note n){
        System.out.println("wind.play()");
    }
}

public class Music {
    public static void tune(Instrument instrument){
        instrument.play(Note.middleC);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}
