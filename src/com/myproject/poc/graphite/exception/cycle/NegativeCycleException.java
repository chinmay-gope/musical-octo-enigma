package com.myproject.poc.graphite.exception.cycle;

import com.myproject.poc.graphite.exception.GraphException;

public class NegativeCycleException extends GraphException {
    public NegativeCycleException() {
        super("The graph contains a negative weight cycle.");
    }
}
