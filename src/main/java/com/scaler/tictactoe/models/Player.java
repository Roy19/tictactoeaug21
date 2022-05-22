package com.scaler.tictactoe.models;

public abstract class Player {
    private Symbol symbol;
    private PlayerType playerType;

    public Player(PlayerType type, Symbol symbol) {
        this.playerType = type;
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}

// StartGame
// NumberOfPlayers
// Human email name phone_number symbol
// Bot strategyType
// DimensionOfBoard (n)
// WinningStrategies
// This will lead to creation of Game object
// => Builder to be used for game
// Game(int n, List<Player>, Strategy, int dimension,)