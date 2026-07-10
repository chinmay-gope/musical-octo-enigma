package com.myproject.graphite.result;

import java.util.List;

public record MSTResult(int cost, List<MSTEdge> edges) {
    public MSTResult {
        edges = List.copyOf(edges);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (MSTEdge edge : edges) {
            builder.append(edge).append('\n');
        }

        builder.append("Cost = ").append(cost);

        return builder.toString();
    }
}
