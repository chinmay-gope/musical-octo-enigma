package com.myproject.graphite.exceptions.validation;

import com.myproject.graphite.exceptions.GraphException;

public class InvalidVertexException extends GraphException {
    public InvalidVertexException(int vertex) {
        super("Invalid vertex " + vertex);
    }
}
