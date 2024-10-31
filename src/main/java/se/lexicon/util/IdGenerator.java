package se.lexicon.util;

public class IdGenerator {
    private static int counter=0;


    public static int nextId(){
        return ++counter;
    }
}

