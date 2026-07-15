package com.myproject.graphite.exception.validation;

import com.myproject.graphite.exception.GraphException;

public class NegativeWeightException extends GraphException {
    public NegativeWeightException(String message) {
        super(message);
    }
}
