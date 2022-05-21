package com.scaler.tictactoe.models;

public class Move {
    private Symbol symbol;
    private Cell cell;
    private Player player;

    public Cell getCell() {
        return cell;
    }
}

// IBotPlayingStrategy
// BotPlayingStrategyImpl