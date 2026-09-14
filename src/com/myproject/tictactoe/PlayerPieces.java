package com.myproject.tictactoe;

import java.util.ArrayDeque;
import java.util.Deque;

public class PlayerPieces {

    private static final int MAX_PIECES = 3;

    private final Deque<Position> pieces = new ArrayDeque<>();

    public Position add(Position position) {

        Position removed = null;

        if (pieces.size() == MAX_PIECES) {
//            removes the oldest piece.
            removed = pieces.removeFirst();
        }

        pieces.addLast(position);

        return removed;
    }

    public boolean contains(Position position) {
        return pieces.contains(position);
    }

    public Deque<Position> pieces() {
        return new ArrayDeque<>(pieces);
    }

    public int size() {
        return pieces.size();
    }
}
