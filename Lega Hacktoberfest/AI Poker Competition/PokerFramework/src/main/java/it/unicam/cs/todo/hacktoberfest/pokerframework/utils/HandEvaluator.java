/**
 *     This file is part of the PokerFramework project.
 *
 *     Copyright (C) 2024  HarlockOfficial
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 **/


package it.unicam.cs.todo.hacktoberfest.pokerframework.utils;

import it.unicam.cs.todo.hacktoberfest.pokerframework.models.Card;
import it.unicam.cs.todo.hacktoberfest.pokerframework.models.Rank;
import it.unicam.cs.todo.hacktoberfest.pokerframework.models.Suit;

import java.util.ArrayList;
import java.util.List;

public class HandEvaluator {
    public static int evaluate(Card[] hand, Card[] communityCards) {
        if (hand.length != 2) {
            throw new IllegalArgumentException("Hand must have 2 cards");
        }
        if (communityCards.length != 5) {
            throw new IllegalArgumentException("Community cards must have 5 cards");
        }
        Card[] allCards = new Card[7];
        System.arraycopy(hand, 0, allCards, 0, 2);
        System.arraycopy(communityCards, 0, allCards, 2, 5);

        if (isRoyalFlush(allCards)) {
            return 25;
        }
        if (isStraightFlush(allCards)) {
            return 24;
        }
        if (isFourOfAKind(allCards)) {
            return 23;
        }
        if (isFullHouse(allCards)) {
            return 22;
        }
        if (isFlush(allCards)) {
            return 21;
        }
        if (isStraight(allCards)) {
            return 20;
        }
        if (isThreeOfAKind(allCards)) {
            return 19;
        }
        if (isTwoPair(allCards)) {
            return 18;
        }
        if (isPair(allCards)) {
            return 17;
        }
        if (hand[0].rank().compareTo(hand[1].rank()) > 0) {
            return hand[0].rank().getValue();
        }
        return hand[1].rank().getValue();
    }

    private static boolean isRoyalFlush(Card[] allCards) {
        List<Suit> suits = new ArrayList<>();
        List<Rank> ranks = new ArrayList<>();
        for (Card card : allCards) {
            suits.add(card.suit());
            ranks.add(card.rank());
        }
        for (Suit suit : Suit.values()) {
            if (suits.stream().filter(s -> s.equals(suit)).count() >= 5) {
                if (ranks.contains(Rank.ACE) &&
                        ranks.contains(Rank.KING) &&
                        ranks.contains(Rank.QUEEN) &&
                        ranks.contains(Rank.JACK) &&
                        ranks.contains(Rank.TEN)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isStraightFlush(Card[] allCards) {
        List<Suit> suits = new ArrayList<>();
        List<Rank> ranks = new ArrayList<>();
        for (Card card : allCards) {
            suits.add(card.suit());
            ranks.add(card.rank());
        }
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                if (ranks.contains(rank) &&
                        suits.stream().filter(s -> s.equals(suit)).count() >= 5) {
                    int count = 0;
                    for (Card allCard : allCards) {
                        if (allCard.rank().equals(rank) && allCard.suit().equals(suit)) {
                            count++;
                        }
                    }
                    if (count >= 5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isFourOfAKind(Card[] allCards) {
        List<Rank> ranks = new ArrayList<>();
        for (Card card : allCards) {
            ranks.add(card.rank());
        }
        for (Rank rank : Rank.values()) {
            if (ranks.stream().filter(r -> r.equals(rank)).count() == 4) {
                return true;
            }
        }
        return false;
    }

    private static boolean isFullHouse(Card[] allCards) {
        List<Rank> ranks = new ArrayList<>();
        for (Card card : allCards) {
            ranks.add(card.rank());
        }
        for (Rank rank : Rank.values()) {
            if (ranks.stream().filter(r -> r.equals(rank)).count() == 3) {
                for (Rank rank2 : Rank.values()) {
                    if (ranks.stream().filter(r -> r.equals(rank2)).count() == 2) {
                        if (!rank.equals(rank2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean isFlush(Card[] allCards) {
        List<Suit> suits = new ArrayList<>();
        for (Card card : allCards) {
            suits.add(card.suit());
        }
        for (Suit suit : Suit.values()) {
            if (suits.stream().filter(s -> s.equals(suit)).count() >= 5) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStraight(Card[] allCards) {
        List<Rank> ranks = new ArrayList<>();
        for (Card card : allCards) {
            ranks.add(card.rank());
        }
        for (Rank rank : Rank.values()) {
            try {
                if (ranks.contains(rank) &&
                        ranks.contains(Rank.values()[rank.ordinal() + 1]) &&
                        ranks.contains(Rank.values()[rank.ordinal() + 2]) &&
                        ranks.contains(Rank.values()[rank.ordinal() + 3]) &&
                        ranks.contains(Rank.values()[rank.ordinal() + 4])) {
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        return false;
    }

    private static boolean isThreeOfAKind(Card[] allCards) {
        List<Rank> ranks = new ArrayList<>();
        for (Card card : allCards) {
            ranks.add(card.rank());
        }
        for (Rank rank : Rank.values()) {
            if (ranks.stream().filter(r -> r.equals(rank)).count() == 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTwoPair(Card[] allCards) {
        List<Rank> ranks = new ArrayList<>();
        for (Card card : allCards) {
            ranks.add(card.rank());
        }
        int count = 0;
        for (Rank rank : Rank.values()) {
            if (ranks.stream().filter(r -> r.equals(rank)).count() == 2) {
                count++;
            }
        }
        return count >= 2;
    }

    private static boolean isPair(Card[] allCards) {
        List<Rank> ranks = new ArrayList<>();
        for (Card card : allCards) {
            ranks.add(card.rank());
        }
        for (Rank rank : Rank.values()) {
            if (ranks.stream().filter(r -> r.equals(rank)).count() == 2) {
                return true;
            }
        }
        return false;
    }
}
