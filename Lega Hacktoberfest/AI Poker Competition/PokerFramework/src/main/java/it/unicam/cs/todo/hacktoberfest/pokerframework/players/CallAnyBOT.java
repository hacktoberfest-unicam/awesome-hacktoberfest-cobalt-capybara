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

public class CallAnyBOT extends BasePlayer {
    @Override
    public void play(Card[] table, int toCall, int minRaise, int maxBet, int pot, int numPlayers) {
        if (toCall < chips) {
            call(toCall);
        } else if (chips > 0) {
            allIn();
        } else if (toCall > chips) {
            fold();
        } else {
            check();
        }
    }
}
