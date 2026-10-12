package com.myproject.poc.graphite.exception.cycle;

import com.myproject.poc.graphite.exception.GraphException;

public class GraphCycleException extends GraphException {
    public GraphCycleException() {
        super("The graph contains one or more cycles.");
    }

    public GraphCycleException(String message) {
        super(message);
    }
}
