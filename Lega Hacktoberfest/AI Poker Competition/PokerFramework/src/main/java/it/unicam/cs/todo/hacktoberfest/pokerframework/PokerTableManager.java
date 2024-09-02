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

import it.unicam.cs.todo.hacktoberfest.pokerframework.players.BasePlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PokerTableManager extends Thread {
    private static final Logger logger = LogManager.getLogger(PokerTableManager.class);
    private final List<? extends BasePlayer> players;
    private List<? extends BasePlayer> finalWinners;
    private boolean gameFinished = false;

    public PokerTableManager(List<? extends BasePlayer> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException("At least 2 players are required to play a game of poker");
        }
        if (players.size() > 9) {
            throw new IllegalArgumentException("A maximum of 9 players are allowed to play a game of poker");
        }
        this.players = new ArrayList<>(players);
        this.finalWinners = null;
    }

    @Override
    public void run() {
        int smallBlindIndex = 0;
        int smallBlindAmount = 10;
        int availablePlayers = availablePlayers(smallBlindAmount);
        while (availablePlayers > 1) {
            logger.info("Starting round with {} players", availablePlayers);
            PokerTable pokerTable = new PokerTable(players);
            pokerTable.playGame(smallBlindIndex, smallBlindAmount);
            smallBlindIndex += 1;
            if (smallBlindIndex >= players.size()) {
                smallBlindIndex = smallBlindIndex % players.size();
                smallBlindAmount += 10;
            }
            availablePlayers = availablePlayers(smallBlindAmount);
        }
        finalWinners = players.stream().filter(p ->
                        p.getChips() == players.stream().map(BasePlayer::getChips).max(Integer::compareTo).orElseThrow())
                .toList();
        gameFinished = true;
        logger.info("Game finished with winners: {}",
                finalWinners.stream().map(Object::toString).collect(Collectors.joining(", ")));

        fullTableLeaderboard();
    }

    private void fullTableLeaderboard() {
        StringBuilder sb = new StringBuilder("Full Table Leaderboard:");
        var sortedPlayers = players.stream().sorted(BasePlayer::compareTo).toList();
        IntStream.range(1, players.size() + 1).mapToObj(i -> i + " " + sortedPlayers.stream().skip(i - 1)
                .findFirst().orElseThrow()).forEach(s -> sb.append("\n").append(s));
        logger.info(sb.toString());
    }

    private int availablePlayers(int smallBlindAmount) {
        return (int) players.stream().filter(player -> player.getChips() >= smallBlindAmount).count();
    }

    public List<? extends BasePlayer> getFinalWinners() {
        if (!gameFinished) {
            throw new IllegalStateException("Game is not finished yet");
        }
        return finalWinners;
    }
}
