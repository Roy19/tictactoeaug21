package com.scaler.tictactoe.factories.player;

import com.scaler.tictactoe.models.*;
import com.scaler.tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;

public class PlayerFactory {
    public static Player getBot(Symbol symbol, BotPlayingStrategy playingStrategy) {
        return new Bot(symbol, playingStrategy);
    }

    public static Player getHuman(Symbol symbol, User user) {
        return new HumanPlayer(symbol, user);
    }
}
