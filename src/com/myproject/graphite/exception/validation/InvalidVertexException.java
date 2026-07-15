package com.myproject.graphite.exception.validation;

import com.myproject.graphite.exception.GraphException;

public class InvalidVertexException extends GraphException {
    public InvalidVertexException(int vertex) {
        super("Invalid vertex " + vertex);
    }
}
