package com.myproject.tictactoe;

public class Game {

    private final Board board;
    private final WinChecker winChecker;

    private final PlayerPieces xPieces;
    private final PlayerPieces oPieces;

    private Player currentPlayer;
    private Player winner;

    public Game() {

        board = new Board();
        winChecker = new WinChecker();

        xPieces = new PlayerPieces();
        oPieces = new PlayerPieces();

        currentPlayer = Player.O;
    }

    public void play(Position position) {

        if (winner != null) {
            throw new IllegalStateException(
                    "Game already finished. Winner: " + winner
            );
        }

        if (!position.isValid()) {
            throw new IllegalArgumentException(
                    "Invalid position: " + position
            );
        }

        if (!board.isEmpty(position)) {
            throw new IllegalArgumentException(
                    "Position already occupied: " + position
            );
        }

        PlayerPieces pieces = piecesFor(currentPlayer);

        /*
         * Add the new piece.
         *
         * If the player already has 3 pieces,
         * add() returns the oldest piece.
         */
        Position removedPiece = pieces.add(position);

        if (removedPiece != null) {
            board.remove(removedPiece);

            System.out.println(
                    currentPlayer + "'s oldest piece disappeared from "
                            + format(removedPiece)
            );
        }

        board.place(position, currentPlayer);

        /*
         * Check victory AFTER the old piece has disappeared
         * and the new piece has been placed.
         */
        if (winChecker.hasWon(board, currentPlayer)) {
            winner = currentPlayer;
            return;
        }

        currentPlayer = currentPlayer.opponent();
    }

    private PlayerPieces piecesFor(Player player) {

        return player == Player.X
                ? xPieces
                : oPieces;
    }

    public Player currentPlayer() {
        return currentPlayer;
    }

    public Player winner() {
        return winner;
    }

    public Board board() {
        return board;
    }

    public boolean isGameOver() {
        return winner != null;
    }

    public String format(Position position) {

        return "("
                + (position.row() + 1)
                + ","
                + (position.col() + 1)
                + ")";
    }

    public void printPieces() {

        System.out.println("X pieces: " + xPieces.pieces());
        System.out.println("O pieces: " + oPieces.pieces());
    }
}
