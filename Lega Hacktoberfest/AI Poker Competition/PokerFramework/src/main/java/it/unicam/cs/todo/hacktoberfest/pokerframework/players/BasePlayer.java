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
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public abstract class BasePlayer implements Comparator<BasePlayer>, Comparable<BasePlayer> {
    private static final Logger logger = LogManager.getLogger(BasePlayer.class);
    @Getter
    private final String name;
    @Getter
    protected Card[] hand;
    @Getter
    protected int chips;
    @Getter
    protected int bet;
    private boolean isPlaying;
    private boolean hasChecked = false;
    @Getter
    private int deltaBet;

    public BasePlayer() {
        this(1000);
    }

    public BasePlayer(int chips) {
        this.chips = chips;
        this.name = this.getClass().getSimpleName();
        this.isPlaying = true;
        bet = 0;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
        isPlaying = true;
        bet = 0;
    }

    protected void check() {
        logger.info("{} checks", name);
        this.hasChecked = true;
    }

    protected void call(int amount) {
        logger.info("{} calls {}", name, amount);
        bet(amount - bet, true);
    }

    protected void raise(int toCall, int raiseAmount) {
        logger.info("{} raises {}", name, raiseAmount);
        bet(toCall - bet);
        bet(raiseAmount, true);
    }

    protected void allIn() {
        logger.info("{} goes all in with {}", name, chips);
        bet(chips, true);
    }

    protected void fold() {
        logger.info("{} folds", name);
        this.isPlaying = false;
    }

    private void bet(int amount) {
        bet(amount, false);
    }

    private void bet(int amount, boolean isRaise) {
        if (amount > chips) {
            throw new IllegalArgumentException("Not enough chips to bet " + amount + " chips, while bet was " + bet);
        }
        chips -= amount;
        if (isRaise) {
            deltaBet = amount;
            bet += amount;
        } else {
            deltaBet = amount;
            bet = amount;
        }
    }

    public boolean hasChecked() {
        boolean returnValue = hasChecked;
        hasChecked = false;
        return returnValue;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void win(int amount) {
        chips += amount;
        bet = 0;
    }

    public abstract void play(Card[] table, int toCall, int minRaise, int maxBet, int pot, int numPlayers);

    public void blindBet(int amount) {
        try {
            bet(amount, true);
        } catch (IllegalArgumentException e) {
            if (chips > 0)
                allIn();
            else
                loose();
        }
    }

    @Override
    public String toString() {
        return name + " has " + chips + " chips";
    }

    public void loose() {
        isPlaying = false;
    }

    @Override
    public int compare(BasePlayer o1, BasePlayer o2) {
        int result = o2.chips - o1.chips;
        if (result == 0) {
            return o1.name.compareTo(o2.name);
        }
        return result;
    }

    @Override
    public int compareTo(@NotNull BasePlayer o) {
        return compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasePlayer that = (BasePlayer) o;
        return chips == that.chips && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chips, name);
    }
}
