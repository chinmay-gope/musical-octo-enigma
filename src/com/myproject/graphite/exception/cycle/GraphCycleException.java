package com.myproject.graphite.exception.cycle;

import com.myproject.graphite.exception.GraphException;

public class GraphCycleException extends GraphException {
    public GraphCycleException() {
        super("The graph contains one or more cycles.");
    }

    public GraphCycleException(String message) {
        super(message);
    }
}
