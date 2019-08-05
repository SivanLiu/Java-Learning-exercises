package com.think.chapter7;

interface Actor {
    void act();
}

class HappyActor implements Actor {

    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor implements Actor {

    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage {
    Actor actor = new HappyActor();

    void change() {
        actor = new SadActor();
    }

    void go() {
        actor.act();
    }
}

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.go();
        stage.change();
        stage.go();
    }
}
