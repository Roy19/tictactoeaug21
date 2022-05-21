package com.scaler.tictactoe.models;

import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;
    }

    Cell getCell(int i, int j) {
        return board.get(i).get(j);
    }
}
