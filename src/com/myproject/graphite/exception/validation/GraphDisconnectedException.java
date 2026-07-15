package com.myproject.graphite.exception.validation;

import com.myproject.graphite.exception.GraphException;

public class GraphDisconnectedException extends GraphException {
    public GraphDisconnectedException(String message) {
        super(message);
    }
}
