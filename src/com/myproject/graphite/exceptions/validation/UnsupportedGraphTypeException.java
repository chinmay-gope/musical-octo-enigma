package com.myproject.graphite.exceptions.validation;

import com.myproject.graphite.exceptions.GraphException;
import com.myproject.graphite.factory.GraphType;

public class UnsupportedGraphTypeException extends GraphException {
    public UnsupportedGraphTypeException(GraphType expected,
                                         GraphType actual) {
        super("Expected graph type: " + expected +
                ", but found: " + actual + ".");
    }
}
