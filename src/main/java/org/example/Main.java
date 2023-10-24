package org.example;

import org.example.Entity.PokerHand;
import org.example.Entity.PokerPlayers;
import org.example.Service.PokerHandService;
import org.example.exception.PokerHandException;
import org.example.exception.PokerPlayersException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PokerPlayers players = new PokerPlayers();
        try {
            PokerHand pokerHand = new PokerHand("TS KH QC JD TD");
            PokerHand pokerHand2 = new PokerHand("7C 7S 5H 5C KS");
            PokerHand pokerHand3 = new PokerHand("3H 2H 5C 9D TD");
            PokerHand pokerHand4 = new PokerHand("3H 3D 3C 3S 2D");
            PokerHand pokerHand5 = new PokerHand("TH TD TS 8C 8S");
            players.add(pokerHand);
            players.add(pokerHand2);
            players.add(pokerHand3);
            players.add(pokerHand4);
            players.add(pokerHand5);
        } catch (PokerHandException | PokerPlayersException e) {
            System.out.println(e);
        }

        PokerHandService.sortedPlayersAsc(players); //возрастание
        players.getPokerHand().forEach(System.out::println);
        PokerHandService.sortedPlayersDesc(players); //убывание
        players.getPokerHand().forEach(System.out::println);
    }
}