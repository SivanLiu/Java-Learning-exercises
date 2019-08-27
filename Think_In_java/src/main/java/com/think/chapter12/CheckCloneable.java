package com.think.chapter12;

/**
 * Checking to see if a handle can be cloned
 */

/**
 * Can't clone this because it doesn't override clone()
 */
class Ordinary {
}

/**
 * Overrides clone, but doesn't implement Cloneable:
 */
class WrongClone extends Ordinary {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/**
 * Does all the right things for cloning:
 */
class IsCloneable extends Ordinary implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/**
 * Turn off cloning by throwing the exception:
 */
class NoMore extends IsCloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
}

class TryMore extends NoMore {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //Calls NoMore.clone(), throws exception
        return super.clone();
    }
}

class BackOn extends NoMore {
    private BackOn duplicate(BackOn b) {
        return new BackOn();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //doesn't call NoMore.clone()
        return duplicate(this);
    }
}

final class ReallyNoMore extends NoMore {
}

public class CheckCloneable {
    static Ordinary tryToClone(Ordinary ord) {
        String id = ord.getClass().getName();
        Ordinary x = null;
        if (ord instanceof Cloneable) {
            try {
                System.out.println("Attempting " + id);
                x = (Ordinary) ((IsCloneable) ord).clone();
                System.out.println("Cloned " + id);
            } catch (CloneNotSupportedException e) {
                System.out.println("Could not clone " + id);
            }catch (ClassCastException e){
                System.out.println("Could not cast "+id);
            }
        }
        return x;
    }

    public static void main(String[] args) {
        //Upcasting
        Ordinary[] ord = { new IsCloneable(), new WrongClone(), new NoMore(), new TryMore(), new BackOn(),
                new ReallyNoMore(), };

        Ordinary x = new Ordinary();
        for (int i = 0; i < ord.length; ++i) {
            tryToClone(ord[i]);
        }
    }
}
