package com.scaler.tictactoe.strategies.botplayingstrategies;

import com.scaler.tictactoe.models.*;

import java.util.Random;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeNextMove(Board board, Player player) {
        int dimensionOfBoard = board.getDimension();
        Random randomGenerator = new Random();
        int row = randomGenerator.nextInt() % dimensionOfBoard,
            col = randomGenerator.nextInt() % dimensionOfBoard;
        return new Move(player, new Cell(row, col));
    }
}
