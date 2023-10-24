package org.example.Entity;


import org.example.exception.PokerHandException;

import static org.example.Service.PokerHandService.isValidHand;

public class PokerHand {
    private String[] cards;

    public PokerHand(String hand) throws PokerHandException {
        if (isValidHand(hand)) {
            this.cards = hand.split(" ");
        } else {
            throw new PokerHandException("The object could not be created. Error in argument.");
        }
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return String.join(" ", cards);
    }
}
