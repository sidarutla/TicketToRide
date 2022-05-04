package com.thesidproject;

public enum TakeCard {

    card1(1), card2(2), card3(3), card4(4), card5(5), drawpile(6);

    private int index;

    TakeCard(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }


    public static TakeCard getTakeCard(int index) {
        for (TakeCard value : values()) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        return null;
    }
}
