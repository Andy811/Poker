package com.andy.poker.poker;

public class Card {
    char[] suits = {'\u2663', '\u2666', '\u2665', '\u2660'};
    int value;
    public Card(int value) {
        this.value = value;
    }

    public String get() {
        return value%13+1 + "" + suits[value/13];
    }
}
