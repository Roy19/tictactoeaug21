package com.scaler.tictactoe.exceptions;

public class EmptyGameWinningStrategiesException extends Exception {

    public EmptyGameWinningStrategiesException() {
        super("There are no game winning strategies listed");
    }

}
