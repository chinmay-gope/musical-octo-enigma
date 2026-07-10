package com.myproject.graphite.exceptions;

public class GraphCycleException extends RuntimeException {
    public GraphCycleException() {
        super("The graph contains one or more cycles.");
    }

    public GraphCycleException(String message) {
        super(message);
    }
}
