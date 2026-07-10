package com.myproject.graphite.exceptions;

import com.myproject.graphite.factory.GraphType;

public class UnsupportedGraphTypeException extends RuntimeException {
    public UnsupportedGraphTypeException(GraphType expected,
                                         GraphType actual) {
        super("Expected graph type: " + expected +
                ", but found: " + actual + ".");
    }
}
