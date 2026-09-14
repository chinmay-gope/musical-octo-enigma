package com.myproject.tictactoe.exception;

import com.myproject.tictactoe.Position;

public class InvalidState extends RuntimeException {

    public InvalidState(String message) {
        super(message);
    }

    public InvalidState(String message, Position position) {
        super(message + position);
    }
}
