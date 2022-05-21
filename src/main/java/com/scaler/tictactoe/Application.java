package com.scaler.tictactoe;

import com.scaler.tictactoe.controllers.GameController;
import com.scaler.tictactoe.factories.player.PlayerFactory;
import com.scaler.tictactoe.models.*;
import com.scaler.tictactoe.strategies.botplayingstrategies.RandomBotPlayingStrategy;
import com.scaler.tictactoe.strategies.gamewinningstrategies.OrderOneGameWinningStrategy;

public class Application {
    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        Game game;

        try {
            game = Game.create()
                    .withBoard(new Board(3))
                    .addPlayer(PlayerFactory.getHuman(new Symbol('X'), new User()))
                    .addPlayer(PlayerFactory.getBot(new Symbol('0'), new RandomBotPlayingStrategy()))
                    .addGameWinningStrategy(new OrderOneGameWinningStrategy())
                    .build();
        } catch (Exception exception) {
            System.out.println("We did something wrong");
        }

        Game game1 = gameController.createGame();
        Game game2 = gameController.createGame();

        gameController.makeMove(game1, new Move());

        // We get some input
        // MOVE 1 2 X

    }

    // Board withBoard(BoardFactory.getBoardWithDimensions(n))
    // Builder - Board.create().withDimension(n).build()
    // Board.getBoardOfDimension(n)
    // new Board(dimension)
}

// BotFactory.getBotForStrategy(RANDOM).setSymbol(symbol).build()
// PlayerFactory.createBot(Symbol, Strategy)
// PlayerFactory.createHuman(Sumbol, User)

// controllers
// GameController
//   - createGame
//   - makeMove(Game, Move)
//   - checkState(Game)

// Actions over a game:
// Start a game
// Make a move
// Undo
// CheckWinner
// GetCurrentState