package com.myproject.graphite.result;

public record MSTEdge(
        int source,
        int destination,
        int weight
) {

    @Override
    public String toString() {
        return source + " -> " + destination + " (" + weight + ")";
    }
}
