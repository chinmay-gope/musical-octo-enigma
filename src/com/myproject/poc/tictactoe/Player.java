package com.myproject.poc.tictactoe;

public enum Player {
    X, O;


    public Player opponent() {
        return this == X ? O : X;
    }
}
