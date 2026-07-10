package com.myproject.graphite.exceptions.validation;

import com.myproject.graphite.exceptions.GraphException;

public class NullGraphException extends GraphException {
    public NullGraphException() {
        super("Graph cannot be null.");
    }
}
