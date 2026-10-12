package com.myproject.poc.graphite.exception.validation;

import com.myproject.poc.graphite.exception.GraphException;

public class NegativeWeightException extends GraphException {
    public NegativeWeightException(String message) {
        super(message);
    }
}
