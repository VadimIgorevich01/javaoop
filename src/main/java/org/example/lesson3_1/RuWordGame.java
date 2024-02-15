package org.example.lesson3_1;

import java.util.ArrayList;
import java.util.List;

public class RuWordGame extends AbstractGame{
    @Override
    protected List<String> generateCharList() {
        List<String> ruLetters = new ArrayList<>();
        ruLetters.add("й");
        ruLetters.add("ц");
        ruLetters.add("у");
        ruLetters.add("к");
        ruLetters.add("е");
        ruLetters.add("н");
        ruLetters.add("г");
        ruLetters.add("ш");
        ruLetters.add("щ");
        ruLetters.add("з");
        ruLetters.add("х");
        ruLetters.add("ъ");
        ruLetters.add("ф");
        ruLetters.add("ы");
        ruLetters.add("в");
        ruLetters.add("а");
        ruLetters.add("п");
        ruLetters.add("р");
        ruLetters.add("о");
        ruLetters.add("л");
        ruLetters.add("д");
        ruLetters.add("ж");
        ruLetters.add("э");
        ruLetters.add("я");
        ruLetters.add("ч");
        ruLetters.add("с");
        ruLetters.add("м");
        ruLetters.add("и");
        ruLetters.add("т");
        ruLetters.add("ь");
        ruLetters.add("б");
        ruLetters.add("ю");
        return ruLetters;
    }
}
