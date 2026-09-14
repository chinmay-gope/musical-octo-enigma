package com.myproject.tictactoe;

public class Board {

    private final Player[][] board = new Player[3][3];

    public Player get(Position position) {
        if (!position.isValid()) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        return board[position.row()][position.col()];
    }

    public boolean isEmpty(Position position) {
        return get(position) == null;
    }

    public void place(Position position, Player player) {

        if (!position.isValid()) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        if (!isEmpty(position)) {
            throw new IllegalArgumentException(
                    "Position already occupied: " + position
            );
        }

        board[position.row()][position.col()] = player;
    }

    public void remove(Position position) {

        if (!position.isValid()) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        board[position.row()][position.col()] = null;
    }

    public void print() {

        System.out.println();
        System.out.println("    1   2   3");
        System.out.println("  +---+---+---+");

        for (int row = 0; row < 3; row++) {

            System.out.print((row + 1) + " ");

            for (int col = 0; col < 3; col++) {

                Player player = board[row][col];

                String value = player == null
                        ? " "
                        : player.toString();

                System.out.print("| " + value + " ");

            }

            System.out.println("|");
            System.out.println("  +---+---+---+");
        }

        System.out.println();
    }
}
