package com.scaler.tictactoe.exceptions;

public class GameNotEndedException extends Exception {

    public GameNotEndedException() {
        super("Game is still ongoing");
    }

}
