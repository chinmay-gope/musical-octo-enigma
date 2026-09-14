package com.myproject.tictactoe;

public class WinChecker {

    private static final int[][] WINNING_LINES = {

            // Rows
            {0, 0, 0, 1, 0, 2},
            {1, 0, 1, 1, 1, 2},
            {2, 0, 2, 1, 2, 2},

            // Columns
            {0, 0, 1, 0, 2, 0},
            {0, 1, 1, 1, 2, 1},
            {0, 2, 1, 2, 2, 2},

            // Diagonals
            {0, 0, 1, 1, 2, 2},
            {0, 2, 1, 1, 2, 0}
    };

    public boolean hasWon(Board board, Player player) {

        for (int[] line : WINNING_LINES) {

            Position first =
                    new Position(line[0], line[1]);

            Position second =
                    new Position(line[2], line[3]);

            Position third =
                    new Position(line[4], line[5]);

            if (board.get(first) == player
                    && board.get(second) == player
                    && board.get(third) == player) {

                return true;
            }
        }

        return false;
    }
}
