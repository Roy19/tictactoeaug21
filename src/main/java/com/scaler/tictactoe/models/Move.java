package com.scaler.tictactoe.models;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public Player getPlayer() {
        return player;
    }
}

// IBotPlayingStrategy
// BotPlayingStrategyImpl