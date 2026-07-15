package com.myproject.graphite.exception.validation;

import com.myproject.graphite.exception.GraphException;

public class NullGraphException extends GraphException {
    public NullGraphException() {
        super("Graph cannot be null.");
    }
}
