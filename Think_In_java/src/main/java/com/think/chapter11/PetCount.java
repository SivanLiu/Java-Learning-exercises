package com.think.chapter11;

import java.util.Hashtable;
import java.util.Vector;

/**
 * Using instanceof
 */
class Pet {
}

class Dog extends Pet {
}

class Pug extends Dog {
}

class Cat extends Pet {
}

class Rodent extends Pet {
}

class Gerbil extends Rodent {
}

class Hamster extends Rodent {
}

class Counter {
    int i;
}

public class PetCount {
    static String[] typenames = { "Pet", "Dog", "Pug", "Cat", "Rodent", "Gerbil", "Hamster" };

    public static void main(String[] args) {
        Vector pets = new Vector();
        try {
            Class[] petTypes = { Class.forName("com.think.chapter11.Dog"), Class.forName("com.think.chapter11.Pug"),
                    Class.forName("com.think.chapter11.Cat"), Class.forName("com.think.chapter11.Rodent"),
                    Class.forName("com.think.chapter11.Gerbil"), Class.forName("com.think.chapter11.Hamster") };

            for (int i = 0; i < 15; ++i) {
                pets.addElement(petTypes[(int) (Math.random() * petTypes.length)].newInstance());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < typenames.length; ++i) {
            hashtable.put(typenames[i], new Counter());
        }
        for (int i = 0; i < pets.size(); ++i) {
            Object o = pets.elementAt(i);

            if (o instanceof Pet) {
                ((Counter) hashtable.get("Pet")).i++;
            } else if (o instanceof Dog) {
                ((Counter) hashtable.get("Dog")).i++;
            } else if (o instanceof Pug) {
                ((Counter) hashtable.get("Pug")).i++;
            } else if (o instanceof Cat) {
                ((Counter) hashtable.get("Cat")).i++;
            } else if (o instanceof Rodent) {
                ((Counter) hashtable.get("Rodent")).i++;
            } else if (o instanceof Gerbil) {
                ((Counter) hashtable.get("Gerbil")).i++;
            } else if (o instanceof Hamster) {
                ((Counter) hashtable.get("Hamster")).i++;
            }
        }

        for (int i = 0; i < pets.size(); ++i) {
            System.out.println(pets.elementAt(i).getClass().toString());
        }

        for (int i = 0; i < typenames.length; ++i) {
            System.out.println(typenames[i] + " quantity: " + ((Counter) hashtable.get(typenames[i])).i);
        }
    }
}
