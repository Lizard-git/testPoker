package org.example.Entity;

import org.example.exception.PokerPlayersException;

import java.util.ArrayList;
import java.util.List;

public class PokerPlayers {
    private List<PokerHand> players = new ArrayList<>();

    public PokerPlayers() {}

    public PokerPlayers(List<PokerHand> pokerHand) throws PokerPlayersException {
        if (pokerHand.size() > 10) {
            throw new PokerPlayersException("Error. Too many players");
        }
        this.players = pokerHand;
    }

    public List<PokerHand> getPokerHand() {
        return players;
    }

    public void add(PokerHand pokerHand) throws PokerPlayersException {
        if (players.size() > 10) {
            throw new PokerPlayersException("Error. Too many players");
        }
        players.add(pokerHand);
    }
}
