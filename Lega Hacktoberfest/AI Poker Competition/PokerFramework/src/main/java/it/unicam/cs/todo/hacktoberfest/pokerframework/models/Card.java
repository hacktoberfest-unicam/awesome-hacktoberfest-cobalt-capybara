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


package it.unicam.cs.todo.hacktoberfest.pokerframework.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record Card(Suit suit, Rank rank) implements Comparable<Card> {
    public static List<Card> getDeck() {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public int compareTo(Card o) {
        int result = rank.compareTo(o.rank);
        if (result == 0) {
            return suit.compareTo(o.suit);
        }
        return result;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
