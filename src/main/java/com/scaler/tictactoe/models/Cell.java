package com.scaler.tictactoe.models;

public class Cell {
    private int row;
    private int column;
    private Symbol symbol;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Cell(int row, int col, Symbol symbol) {
        this.row = row;
        this.column = col;
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void clearCell() {
        this.symbol = new Symbol(' ');
    }
}
