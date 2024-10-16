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


package it.unicam.cs.todo.hacktoberfest.pokerframework.players;

import it.unicam.cs.todo.hacktoberfest.pokerframework.models.Card;

public class RandomBot extends BasePlayer {
    @Override
    public void play(Card[] table, int toCall, int minRaise, int maxBet, int pot, int numPlayers) {
        if (toCall == 0) {
            if (Math.random() < 0.5) {
                check();
            } else {
                int bet = (int) (Math.random() * chips);
                if (bet == 0) {
                    check();
                } else {
                    try {
                        raise(toCall, bet);
                    } catch (IllegalArgumentException e) {
                        fold();
                    }
                }
            }
        } else {
            if (Math.random() < 0.5) {
                fold();
            } else {
                int bet = (int) (Math.random() * chips);
                if (bet == 0) {
                    if (toCall < chips) {
                        call(toCall);
                    } else {
                        allIn();
                    }
                } else {
                    try {
                        raise(toCall, bet);
                    } catch (IllegalArgumentException e) {
                        fold();
                    }
                }
            }
        }
    }
}
