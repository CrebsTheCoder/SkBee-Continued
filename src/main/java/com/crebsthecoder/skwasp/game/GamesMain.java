package com.crebsthecoder.skwasp.game;

import com.crebsthecoder.skwasp.game.checkers.Checkers;
import com.crebsthecoder.skwasp.game.pong.Pong;

import java.util.Random;

public class GamesMain {
    public static void main(String[] args) {
        var games = new Class<?>[]{
            Pong.class,
            Checkers.class
        };

        try {
            var game = games[new Random().nextInt(games.length)];
            game.getConstructor().newInstance();
        } catch (ReflectiveOperationException ignored) {
            System.err.println("we failed to pick a game :( defaulting to pong");
            new Pong();
        }
    }
}
