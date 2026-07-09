package com.myproject.graphite.result;

import java.util.List;

public record MSTResult(int cost, List<WeightedEdge> edges) {
    public MSTResult {
        edges = List.copyOf(edges);
    }

    @Override
    public String toString() {
        return "MSTResult{" +
                "cost=" + cost +
                ", edges=" + edges +
                '}';
    }
}
