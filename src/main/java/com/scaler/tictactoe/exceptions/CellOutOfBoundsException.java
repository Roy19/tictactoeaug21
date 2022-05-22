package com.scaler.tictactoe.exceptions;

public class CellOutOfBoundsException extends Exception {

    public CellOutOfBoundsException() {
        super("The cell is out of bounds of the board");
    }

}
