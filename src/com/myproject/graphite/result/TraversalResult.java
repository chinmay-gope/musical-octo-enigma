package com.myproject.graphite.result;

import java.util.List;

import static com.myproject.graphite.result.ResultColors.*;

public record TraversalResult(int source, List<Integer> traversalOrder) {
    public TraversalResult {
        traversalOrder = List.copyOf(traversalOrder);
    }

    @Override
    public String toString() {
        return "TraversalResult{" +
                "source=" + GREEN + source + RESET +
                ", traversalOrder=" + MAGENTA + traversalOrder + RESET +
                '}';
    }
}
