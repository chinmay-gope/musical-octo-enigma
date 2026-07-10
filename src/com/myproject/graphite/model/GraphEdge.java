package com.myproject.graphite.model;

public record GraphEdge(
        int source,
        int destination,
        int weight
) {
}
