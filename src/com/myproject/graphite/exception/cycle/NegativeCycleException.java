package com.myproject.graphite.exception.cycle;

import com.myproject.graphite.exception.GraphException;

public class NegativeCycleException extends GraphException {
    public NegativeCycleException() {
        super("The graph contains a negative weight cycle.");
    }
}
