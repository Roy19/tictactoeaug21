package com.scaler.tictactoe.strategies.gamewinningstrategies;

import com.scaler.tictactoe.exceptions.CellOutOfBoundsException;
import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Cell;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {
    private int[] rowCount;

    private int[] colCount;

    private int diagonal1 = 0;

    private int diagonal2 = 0;

    private boolean fieldsInitialized = false;

    @Override
    public boolean checkIfWon(Board board, Cell lastMoveCell) throws CellOutOfBoundsException {
        if(!fieldsInitialized) {
            initializeFields(board.getDimension());
        }
        int dimension = board.getDimension(),
                row = lastMoveCell.getRow(),
                col = lastMoveCell.getColumn(),
                toAdd = 0;
        if(lastMoveCell.getSymbol().getCharacter() == 'X') {
            toAdd = 1;
        } else {
            toAdd = -1;
        }

        if (!(row >= 0 && row < dimension && col >= 0 && col < dimension)) {
            throw new CellOutOfBoundsException();
        }
        if(row == col) {
            diagonal1 += toAdd;
        } else if(row == dimension - col - 1) {
            diagonal2 += toAdd;
        }
        rowCount[row] += toAdd;
        colCount[col] += toAdd;

        //System.out.println(diagonal1 + " " + diagonal2 + " " + rowCount[row] + " " + colCount[col]);

        if(Math.abs(diagonal1) == dimension ||
                Math.abs(diagonal2) == dimension ||
                Math.abs(rowCount[row]) == dimension ||
                Math.abs(colCount[col]) == dimension) {
            return true;
        } else {
            return false;
        }
    }

    private void initializeFields(int dimension) {
        rowCount = new int[dimension];
        colCount = new int[dimension];
        fieldsInitialized = true;
    }
}
