/**
 *     This class is the entry point of the application.
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
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors() / 2;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Reflections reflections = new Reflections("it.unicam.cs.todo.hacktoberfest.pokerframework.players");
        Set<Class<? extends BasePlayer>> playerClasses = reflections.getSubTypesOf(BasePlayer.class);

        List<BasePlayer> players = new ArrayList<>(playerClasses.stream()
                .map(Class::getName)
                .map(name -> {
                    try {
                        return Class.forName(name);
                    } catch (ClassNotFoundException e) {
                        logger.fatal("IMPOSSIBLE: Error while getting class", e);
                        throw new RuntimeException(e);
                    }
                })
                .filter(BasePlayer.class::isAssignableFrom)
                .map(aClass -> {
                    try {
                        Class<? extends BasePlayer> subclass = aClass.asSubclass(BasePlayer.class);
                        Constructor<? extends BasePlayer> constructor = subclass.getConstructor();
                        return constructor.newInstance();
                    } catch (NoSuchMethodException e) {
                        logger.fatal("IMPOSSIBLE: Error while getting constructor", e);
                        throw new RuntimeException(e);
                    } catch (InstantiationException e) {
                        logger.fatal("IMPOSSIBLE: Error while instantiating class", e);
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        logger.fatal("IMPOSSIBLE: Error while accessing constructor", e);
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        logger.fatal("IMPOSSIBLE: Error while invoking constructor", e);
                        throw new RuntimeException(e);
                    }
                })
                .toList());

        players.forEach(logger::info);
        Collections.shuffle(players);

        logger.info("Starting Tournament with {} players", players.size());
        int round = 1;
        do {
            logger.info("Starting round {}", round);
            List<PokerTableManager> tables = new ArrayList<>();
            // Decided 9 players per table to have fair card distribution
            int numberOfTables = players.size() / 9 + (players.size() % 9 == 0 ? 0 : 1);
            ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
            for (int i = 0; i < numberOfTables; i++) {
                int upperBound = Math.min((i + 1) * 9, players.size());
                PokerTableManager tableManager = new PokerTableManager(new ArrayList<>(players.subList(i * 9, upperBound)));
                executor.execute(tableManager);
                tables.add(tableManager);
            }
            executor.shutdown();
            try {
                executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            logger.info("All tables for round {} are done! Announcing the winners...", round++);
            players = new ArrayList<>();
            for (PokerTableManager table : tables) {
                players.addAll(table.getFinalWinners());
            }
            players.forEach(logger::info);
        } while (players.size() > 1);
    }
}
