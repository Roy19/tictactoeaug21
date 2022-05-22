package com.scaler.tictactoe.models;

import com.scaler.tictactoe.exceptions.EmptyMovesUndoOperationException;
import com.scaler.tictactoe.exceptions.MultipleBotsException;
import com.scaler.tictactoe.strategies.gamewinningstrategies.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;

    private Game(List<Player> players, Board board,
                 List<GameWinningStrategy> gameWinningStrategies) {
        this.players = players;
        this.board = board;
        this.gameWinningStrategies = gameWinningStrategies;
        this.moves = new ArrayList<>();
        this.lastMovedPlayerIndex = -1;
    }

    public static Builder create() {
        return new Builder();
    }

    // A B
    // | |
    // |
    // 0 1 (2 % 2 = 0) 1 (2 % 2 = 0)
    // 0 -> -1
    public boolean undo() throws EmptyMovesUndoOperationException {
        if (this.moves.size() == 0) {
            // Handle Edge Case
            throw new EmptyMovesUndoOperationException();
        }
        Move lastMove = this.moves.get(this.moves.size() - 1);
        Cell relevantCell = lastMove.getCell();
        relevantCell.clearCell();
        this.lastMovedPlayerIndex -= 1;
        this.lastMovedPlayerIndex = (this.lastMovedPlayerIndex + this.players.size()) % this.players.size();
        this.moves.remove(relevantCell);
        return true;
    }

    public static class Builder {
        private List<Player> players;
        private Board board;
        private List<GameWinningStrategy> gameWinningStrategies;

        public Builder() {
            this.players = new ArrayList<>();
            this.gameWinningStrategies = new ArrayList<>();
        }

        public Builder addPlayers(List<Player> players) {
            this.players.addAll(players);
            return this;
        }

        public Builder withBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder addGameWinningStrategies(List<GameWinningStrategy> strategies) {
            this.gameWinningStrategies.addAll(strategies);
            return this;
        }

        private boolean checkIfSingleBotMax() {
            int count = 0;

            for (Player player: players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    count += 1;
                }
            }

            return count <= 1;
        }
        public Game build() throws MultipleBotsException {
            if (!checkIfSingleBotMax()) {
                throw new MultipleBotsException();
            }

            return new Game(this.players, this.board, this.gameWinningStrategies);
        }
    }
}
