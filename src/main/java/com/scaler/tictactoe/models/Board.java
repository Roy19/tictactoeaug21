package com.scaler.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;
        this.board = new ArrayList<>();
        for(int idx = 0; idx < dimension; idx++) {
            this.board.add(new ArrayList<>());
        }
        for(int idx_i = 0; idx_i < dimension; idx_i++) {
            List<Cell> cells = this.board.get(idx_i);
            for(int idx_j = 0; idx_j < dimension; idx_j++) {
                cells.add(new Cell(idx_i, idx_j));
            }
            this.board.set(idx_i, cells);
        }
    }

    public Cell getCell(int i, int j) {
        return board.get(i).get(j);
    }

    public int getDimension() {
        return this.dimension;
    }
}
