package com.scaler.tictactoe.strategies.gamewinningstrategies;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Cell;

public interface GameWinningStrategy {

    boolean checkIfWon(Board board, Cell lastMoveCell);
}
