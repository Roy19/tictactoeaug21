package com.scaler.tictactoe.controllers;

import com.scaler.tictactoe.models.Game;
import com.scaler.tictactoe.models.GameStatus;
import com.scaler.tictactoe.models.Move;
import com.scaler.tictactoe.models.Player;

// Start a game
// Make a move
// Undo
// CheckWinner
// GetCurrentState
public class GameController {
    public Game createGame() {
        return null;
    }

    public MoveResult makeMove(Game game, Move move) {
        return MoveResult.Failure;
    }

    public boolean undo(Game game) {
        return false;
    }

    public Player getWinner(Game game) {
        return null;
    }

    public GameStatus getGameStatus(Game game) {
        return GameStatus.IN_PROGRESS;
    }
}
