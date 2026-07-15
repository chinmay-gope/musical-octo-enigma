package com.myproject.graphite.exception.validation;

import com.myproject.graphite.exception.GraphException;
import com.myproject.graphite.factory.GraphType;

public class UnsupportedGraphTypeException extends GraphException {
    public UnsupportedGraphTypeException(GraphType expected,
                                         GraphType actual) {
        super("Expected graph type: " + expected +
                ", but found: " + actual + ".");
    }
}
