package com.think.chapter9;

/**
 * Overridden methods may throw only the exceptions specified in their base-class versions,
 * or exceptions derived from the base-class exceptions
 */
class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
    Inning() throws BaseballException {
    }

    void event() throws BaseballException {

    }

    abstract void atBat() throws Strike, Foul;

    void walk() {
    }
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    //OK to add new exceptions for constructors, but you must deal with the base constructor exceptions
    StormyInning() throws RainedOut, BaseballException {
    }

    StormyInning(String s) throws Foul, BaseballException {

    }

    @Override
    void atBat() throws PopFoul {

    }

    @Override
    public void event() {

    }

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args) {
        try {
            StormyInning stormyInning = new StormyInning();
            stormyInning.atBat();
        } catch (PopFoul popFoul) {
            popFoul.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        }

        try {
            Inning inning = new StormyInning();
            inning.atBat();
        } catch (Strike strike) {
            strike.printStackTrace();
        } catch (Foul foul) {
            foul.printStackTrace();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }
    }
}
