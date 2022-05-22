package com.scaler.tictactoe;

import com.scaler.tictactoe.controllers.GameController;
import com.scaler.tictactoe.factories.player.PlayerFactory;
import com.scaler.tictactoe.models.*;
import com.scaler.tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;
import com.scaler.tictactoe.strategies.botplayingstrategies.RandomBotPlayingStrategy;
import com.scaler.tictactoe.strategies.gamewinningstrategies.GameWinningStrategy;
import com.scaler.tictactoe.strategies.gamewinningstrategies.OrderOneGameWinningStrategy;

import java.util.List;

public class Application {
    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        BotPlayingStrategy botPlayingStrategy = new RandomBotPlayingStrategy();
        Player human = PlayerFactory.getHuman(new Symbol('X'), new User()),
                bot = PlayerFactory.getBot(new Symbol('O'), botPlayingStrategy);
        List<Player> players1 = List.of(
                human, bot
        );

        List<GameWinningStrategy> gameWinningStrategies1 = List.of(
                new OrderOneGameWinningStrategy()
        );

        Game game1 = gameController.createGame(3, players1, gameWinningStrategies1);

        gameController.makeMove(game1, new Move(human, new Cell(0, 0, human.getSymbol())));
        // gameController.makeMove(game1, botPlayingStrategy.makeNextMove(game1.getBoard(), bot));
        gameController.makeMove(game1, new Move(bot, new Cell(2, 1, bot.getSymbol())));
        gameController.makeMove(game1, new Move(human, new Cell(1, 0, human.getSymbol())));
        gameController.makeMove(game1, new Move(bot, new Cell(2, 2, bot.getSymbol())));
        gameController.makeMove(game1, new Move(human, new Cell(2, 0, human.getSymbol())));

        System.out.println(gameController.getGameStatus(game1));
        System.out.println(gameController.getWinner(game1));
        // g2 move 1 2 X


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