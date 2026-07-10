package com.myproject.graphite.exceptions.validation;

import com.myproject.graphite.exceptions.GraphException;

public class NegativeWeightException extends GraphException {
    public NegativeWeightException(String message) {
        super(message);
    }
}
