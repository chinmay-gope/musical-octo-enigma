package com.myproject.poc.graphite.exception.validation;

import com.myproject.poc.graphite.exception.GraphException;

public class GraphDisconnectedException extends GraphException {
    public GraphDisconnectedException(String message) {
        super(message);
    }
}
