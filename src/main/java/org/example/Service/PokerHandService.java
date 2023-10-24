package org.example.Service;

import org.example.Entity.PokerHand;
import org.example.Entity.PokerPlayers;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class PokerHandService {

    public static void sortedPlayersAsc(List<PokerHand> hands) {
        hands.sort(new RankAscendingComparator());
    }

    public static void sortedPlayersDesc(List<PokerHand> hands) {
        hands.sort(new RankDescendingComparator());
    }

    public static void sortedPlayersAsc(PokerPlayers hands) {
        hands.getPokerHand().sort(new RankAscendingComparator());
    }

    public static void sortedPlayersDesc(PokerPlayers hands) {
        hands.getPokerHand().sort(new RankDescendingComparator());
    }

    public static boolean isValidHand(String str) {
        String regex = "^(?:[2-9TJQKA][SHDC] ){4}[2-9TJQKA][SHDC]$";
        return Pattern.matches(regex, str);
    }

    private static class RankDescendingComparator implements Comparator<PokerHand> {
        public int compare(PokerHand hand1, PokerHand hand2) {
            String[] cards1 = hand1.getCards();
            String[] cards2 = hand2.getCards();

            return IntStream.range(0, cards1.length)
                    .map(i -> Integer.compare(getRankIndex(cards2[i]), getRankIndex(cards1[i])))
                    .filter(result -> result != 0)
                    .findFirst()
                    .orElse(0);
        }

        private int getRankIndex(String card) {
            String ranks = "23456789TJQKA";
            return ranks.indexOf(card.charAt(0));
        }
    }

    private static class RankAscendingComparator implements Comparator<PokerHand> {
        public int compare(PokerHand hand1, PokerHand hand2) {
            String[] cards1 = hand1.getCards();
            String[] cards2 = hand2.getCards();

            for (int i = 0; i < cards1.length; i++) {
                int rankIndex1 = getRankIndex(cards1[i]);
                int rankIndex2 = getRankIndex(cards2[i]);

                if (rankIndex1 != rankIndex2) {
                    return Integer.compare(rankIndex1, rankIndex2);
                }
            }

            return IntStream.range(0, cards1.length)
                    .map(i -> Integer.compare(getRankIndex(cards1[i]), getRankIndex(cards2[i])))
                    .filter(result -> result != 0)
                    .findFirst()
                    .orElse(0);
        }

        private int getRankIndex(String card) {
            String ranks = "23456789TJQKA";
            return ranks.indexOf(card.charAt(0));
        }
    }

}
