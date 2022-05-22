package com.scaler.tictactoe.controllers;

import com.scaler.tictactoe.exceptions.CellOutOfBoundsException;
import com.scaler.tictactoe.exceptions.EmptyGameWinningStrategiesException;
import com.scaler.tictactoe.exceptions.EmptyMovesUndoOperationException;
import com.scaler.tictactoe.exceptions.GameNotEndedException;
import com.scaler.tictactoe.factories.player.PlayerFactory;
import com.scaler.tictactoe.models.*;
import com.scaler.tictactoe.strategies.botplayingstrategies.RandomBotPlayingStrategy;
import com.scaler.tictactoe.strategies.gamewinningstrategies.GameWinningStrategy;
import com.scaler.tictactoe.strategies.gamewinningstrategies.OrderOneGameWinningStrategy;

import java.util.List;

// Start a game
// Make a move
// Undo
// CheckWinner
// GetCurrentState
public class GameController {
    public Game createGame(int dimensionOfBoard,
                           List<Player> players,
                           List<GameWinningStrategy> strategies) {
        Game game = null;

        try {
            game = Game.create()
                    .withBoard(new Board(dimensionOfBoard))
                    .addPlayers(players)
                    .addGameWinningStrategies(strategies)
                    .build();
        } catch (Exception exception) {
            System.out.println("We did something wrong");
        }

        return game;
    }

    public MoveResult makeMove(Game game, Move move) {
        Board board = game.getBoard();
        Cell moveCell = move.getCell(),
                cellToMove = board.getCell(moveCell.getRow(), moveCell.getColumn());

        if(cellToMove.getSymbol() == null) {
            cellToMove.setSymbol(move.getPlayer().getSymbol());
            game.getMoves().add(move);
        } else {
            System.out.println("Cell already filled");
            return MoveResult.Failure;
        }

        return checkIfMoveResultsInWin(game, move);
    }

    private MoveResult checkIfMoveResultsInWin(Game game, Move move) {
        Board board = game.getBoard();
        Cell moveCell = move.getCell();

        try {
            if (game.getGameWinningStrategy().checkIfWon(board, moveCell)) {
                System.out.println(String.format("Game ended with winner {}", move.getPlayer()));
                game.setGameStatus(GameStatus.ENDED);
                game.setWinner(move.getPlayer());
                return MoveResult.GameEnd;
            } else {
                return MoveResult.Success;
            }
        } catch (CellOutOfBoundsException ex) {
            System.out.println("Cell out of bounds");
            return MoveResult.Failure;
        }
    }

    public boolean undo(Game game) throws EmptyMovesUndoOperationException {
        return game.undo();
    }

    public Player getWinner(Game game) {
        try {
            return game.getWinner();
        } catch (GameNotEndedException ex) {
            return null;
        }
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }
}
