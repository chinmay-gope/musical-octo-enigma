package com.myproject.poc.graphite.exception.validation;

import com.myproject.poc.graphite.exception.GraphException;

public class InvalidVertexException extends GraphException {
    public InvalidVertexException(int vertex) {
        super("Invalid vertex " + vertex);
    }
}
