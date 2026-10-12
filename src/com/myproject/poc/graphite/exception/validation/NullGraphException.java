package com.myproject.poc.graphite.exception.validation;

import com.myproject.poc.graphite.exception.GraphException;

public class NullGraphException extends GraphException {
    public NullGraphException() {
        super("Graph cannot be null.");
    }
}
