package com.myproject.graphite.exceptions.cycle;

import com.myproject.graphite.exceptions.GraphException;

public class NegativeCycleException extends GraphException {
    public NegativeCycleException() {
        super("The graph contains a negative weight cycle.");
    }
}
