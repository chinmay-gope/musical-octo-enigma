package com.myproject.graphite.exceptions;

public class InvalidVertexException extends RuntimeException {
    public InvalidVertexException(int vertex) {
        super("Invalid vertex " + vertex);
    }
}
