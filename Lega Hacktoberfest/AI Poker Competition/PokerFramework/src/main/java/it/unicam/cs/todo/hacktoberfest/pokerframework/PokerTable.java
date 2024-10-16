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

package it.unicam.cs.todo.hacktoberfest.pokerframework;

import it.unicam.cs.todo.hacktoberfest.pokerframework.models.Card;
import it.unicam.cs.todo.hacktoberfest.pokerframework.models.Deck;
import it.unicam.cs.todo.hacktoberfest.pokerframework.players.BasePlayer;
import it.unicam.cs.todo.hacktoberfest.pokerframework.utils.HandEvaluator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class PokerTable {
    private final static Logger logger = LogManager.getLogger(PokerTable.class);
    private final Deck deck;
    private final List<? extends BasePlayer> players;
    private final List<Card> communityCards = new ArrayList<>();
    private final UUID uuid;

    public PokerTable(List<? extends BasePlayer> players) {
        this.uuid = UUID.randomUUID();
        this.deck = new Deck();
        this.players = new ArrayList<>(players);
        this.deck.shuffle();
        // this.logger = logger;
    }

    private void dealCards() {
        Set<BasePlayer> playersToRemove = new HashSet<>();
        for (BasePlayer player : players) {
            if (player.getChips() == 0) {
                player.setHand(null);
                player.loose();
                logger.info("[{}]: {} has lost (no chips), skipping", this, player);
                playersToRemove.add(player);
                continue;
            }
            Card[] hand = new Card[2];
            hand[0] = deck.drawCard();
            hand[1] = deck.drawCard();
            player.setHand(hand);
            logger.info("[{}]: {} has been dealt [{}, {}]", this, player, hand[0], hand[1]);
        }
        players.removeAll(playersToRemove);
    }

    private void dealFlop() {
        for (int i = 0; i < 3; i++) {
            communityCards.add(deck.drawCard());
        }
        logger.info("[{}]: Flop: {}", this,
                communityCards.stream().map(Card::toString).collect(Collectors.joining(", ")));
    }

    private void dealTurn() {
        communityCards.add(deck.drawCard());
        logger.info("[{}]: Turn: {}", this,
                communityCards.stream().map(Card::toString).collect(Collectors.joining(", ")));
    }

    private void dealRiver() {
        dealTurn();
        logger.info("[{}]: River: {}", this,
                communityCards.stream().map(Card::toString).collect(Collectors.joining(", ")));
    }

    public void playGame(int smallBlindIndex, int smallBlindAmount) {
        int pot = 0;

        dealCards();
        logger.info("[{}]: Cards have been dealt", this);

        if (players.size() == 1) {
            BasePlayer player = players.getFirst();
            logger.info("[{}]: {} is the only player left, skipping", this, player);
            return;
        }

        smallBlindIndex = smallBlindIndex % players.size();

        players.get(smallBlindIndex).blindBet(smallBlindAmount);
        pot += players.get(smallBlindIndex).getDeltaBet();
        logger.info("[{}]: {} has placed the small blind of {}", this, players.get(smallBlindIndex),
                players.get(smallBlindIndex).getDeltaBet());

        int minRaise = players.get(smallBlindIndex).getDeltaBet() * 2;
        players.get((smallBlindIndex + 1) % players.size()).blindBet(minRaise);
        pot += players.get((smallBlindIndex + 1) % players.size()).getDeltaBet();
        logger.info("[{}]: {} has placed the big blind of {}", this,
                players.get((smallBlindIndex + 1) % players.size()),
                players.get((smallBlindIndex + 1) % players.size()).getDeltaBet());

        pot = doBetRound(minRaise, smallBlindIndex + 2, minRaise, pot);
        logger.info("[{}]: Bet round 1 completed", this);

        dealFlop();

        pot = doBetRound(minRaise, smallBlindIndex, 0, pot);
        logger.info("[{}]: Bet round 2 completed", this);

        dealTurn();

        pot = doBetRound(minRaise, smallBlindIndex, 0, pot);
        logger.info("[{}]: Bet round 3 completed", this);

        dealRiver();

        pot = doBetRound(minRaise, smallBlindIndex, 0, pot);
        logger.info("[{}]: Bet round 4 completed", this);

        List<BasePlayer> winner = getWinners();
        for (BasePlayer player : winner) {
            // integer division
            player.win(pot / winner.size());
            logger.info("[{}]: {} has won {} chips", this, player,
                    pot / winner.size());
        }
    }

    private int getMaxRaise() {
        int maxRaise = Integer.MAX_VALUE;
        for (BasePlayer player : players) {
            if (player.isPlaying() && player.getChips() < maxRaise) {
                maxRaise = player.getChips();
            }
        }
        return maxRaise;
    }

    private int getActivePlayers() {
        return (int) players.stream().filter(BasePlayer::isPlaying).count();
    }

    private int doBetRound(int minRaise, int smallBlindIndex, int toCall, int pot) {
        Card[] table = communityCards.toArray(new Card[0]);
        boolean hasToRepeat;
        do {
            hasToRepeat = false;
            for (int i = smallBlindIndex; i < players.size() + smallBlindIndex; i++) {
                int maxRaise = getMaxRaise();
                if (minRaise > maxRaise) {
                    minRaise = maxRaise;
                }
                int numPlayers = getActivePlayers();
                BasePlayer player = players.get(i % players.size());
                if (!player.isPlaying()) {
                    continue;
                }
                if (getActivePlayers() == 1) {
                    hasToRepeat = false;
                    logger.info("[{}]: {} is the only player left, skipping", this, player);
                    break;
                }
                player.play(table, toCall, minRaise, maxRaise, pot, numPlayers);
                if (!player.isPlaying()) {
                    continue;
                }
                if (player.hasChecked()) {
                    continue;
                }
                int bet = player.getDeltaBet();
                if (player.isPlaying() && (player.getBet() > toCall || player.getBet() < toCall)) {
                    hasToRepeat = true;
                    toCall = player.getBet();
                }
                pot += bet;
                logger.info("[{}]: {} has bet {}, the pot is now {}", this, player, bet, pot);
            }
        } while (hasToRepeat);

        return pot;
    }

    private List<BasePlayer> getWinners() {
        Map<Integer, List<BasePlayer>> winners = new HashMap<>();
        for (BasePlayer player : players) {
            if (player.isPlaying()) {
                int handValue = HandEvaluator.evaluate(player.getHand(), communityCards.toArray(new Card[0]));
                if (!winners.containsKey(handValue)) {
                    winners.put(handValue, new ArrayList<>());
                }
                winners.get(handValue).add(player);
            }
        }
        return winners.keySet().stream().sorted().max(Integer::compareTo).map(winners::get).orElseThrow();
    }

    @Override
    public String toString() {
        return "Table " + uuid;
    }
}
