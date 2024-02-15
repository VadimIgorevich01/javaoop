package org.example.lesson3_1;

import java.util.ArrayList;
import java.util.List;

public class EnWordGame extends AbstractGame{
    @Override
    protected List<String> generateCharList() {
        List<String> enLetters = new ArrayList<>();
        enLetters.add("q");
        enLetters.add("w");
        enLetters.add("e");
        enLetters.add("r");
        enLetters.add("t");
        enLetters.add("y");
        enLetters.add("u");
        enLetters.add("i");
        enLetters.add("o");
        enLetters.add("p");
        enLetters.add("a");
        enLetters.add("s");
        enLetters.add("d");
        enLetters.add("f");
        enLetters.add("g");
        enLetters.add("h");
        enLetters.add("j");
        enLetters.add("k");
        enLetters.add("l");
        enLetters.add("z");
        enLetters.add("x");
        enLetters.add("c");
        enLetters.add("v");
        enLetters.add("b");
        enLetters.add("n");
        enLetters.add("m");
        return enLetters;
    }
}
