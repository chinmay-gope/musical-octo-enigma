package com.myproject.graphite.exceptions.cycle;

import com.myproject.graphite.exceptions.GraphException;

public class GraphCycleException extends GraphException {
    public GraphCycleException() {
        super("The graph contains one or more cycles.");
    }

    public GraphCycleException(String message) {
        super(message);
    }
}
