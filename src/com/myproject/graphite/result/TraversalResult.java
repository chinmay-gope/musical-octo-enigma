package com.myproject.graphite.result;

import java.util.List;

public record TraversalResult(int source, List<Integer> traversalOrder) {
    public TraversalResult {
        traversalOrder = List.copyOf(traversalOrder);
    }

    @Override
    public String toString() {
        return "TraversalResult{" +
                "source=" + source +
                ", traversalOrder=" + traversalOrder +
                '}';
    }
}
