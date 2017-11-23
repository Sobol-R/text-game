package com.banana.textgame;

import java.util.ArrayList;

public class User {

    boolean[] knownLanguages = {true, false, false, false, false};
    ArrayList<String> jobs = new ArrayList<>();
    int money = 0;

    void printInfo() {
        printKnownLanguage();
    }

    void printKnownLanguage() {
        System.out.println("Эти языки вы теперь знаете: ");
        for (int i = 0; i < Main.languages.length; i++) {
            if (knownLanguages[i] == true) {
                System.out.println(Main.languages[i]);
            }
        }
    }

}
