package com.myproject.graphite.exceptions.validation;

import com.myproject.graphite.exceptions.GraphException;

public class GraphDisconnectedException extends GraphException {
    public GraphDisconnectedException(String message) {
        super(message);
    }
}
