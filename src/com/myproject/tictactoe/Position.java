package com.myproject.tictactoe;

public record Position(int row, int col) {

    public boolean isValid() {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
}
