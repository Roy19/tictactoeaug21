package com.scaler.tictactoe.strategies.gamewinningstrategies;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Cell;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean checkIfWon(Board board, Cell lastMoveCell) {
        return false;
    }
}
